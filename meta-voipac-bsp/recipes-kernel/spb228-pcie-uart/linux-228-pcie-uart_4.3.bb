SUMMARY = "Wifi/BT Driver for spb228-pcie-uart"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

PR                 = "r0"
FW_PATH            = "nxp"
TXPOWER_FILEPREFIX = "txpower_"
MOD_PARAM_FILE	   = "wifi_mod_para.conf"

require config.inc
inherit module

SRC_URI = "${DRIVERTAR}"
SRC_URI += "file://blacklist-mwifiex.conf"
MLAN_INSTALLDIR = "${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless/mlan"


KERNEL_MODULE_PROBECONF += "moal"
module_conf_moal = "options moal mod_para=nxp/${MOD_PARAM_FILE}"

KERNEL_MODULE_PROBECONF += "hci_uart"

S = "${WORKDIR}/${DRIVERNAME}"

FILES_${PN} += "${base_libdir}/firmware/${FW_PATH}/${FW_FILE}"
FILES_${PN} += "${base_libdir}/firmware/${FW_PATH}/${TXPOWER_FILEPREFIX}*.bin"
FILES_${PN} += "${base_libdir}/firmware/${FW_PATH}/${MOD_PARAM_FILE}"
FILES_${PN} += "${sysconfdir}/modprobe.d/blacklist-mwifiex.conf"

do_patch_append() {
    bb.utils.copyfile(d.getVar('S',True)+"/wlan_src/gpl-2.0.txt", d.getVar('S',True)+"/FwImage/COPYING")

    topmake_file = d.getVar('S',True)+"/Makefile"
    topmake      = open(topmake_file, 'w')
    topmake.write('all $(MAKECMDGOALS):\n')
    topmake.write('\tcd wlan_src &&')
    topmake.write(" $(MAKE) CONFIG_ANDROID_KERNEL=$(CONFIG_ANDROID_KERNEL) ARCH=$(ARCH) KERNELDIR=$(KERNELDIR) CROSS_COMPILE=$(CROSS_COMPILE) $(MAKECMDGOALS)")
#    topmake.write(' cd ../muart_src &&')
#    topmake.write(" $(MAKE) CONFIG_ANDROID_KERNEL=$(CONFIG_ANDROID_KERNEL) ARCH=$(ARCH) KERNELDIR=$(KERNELDIR) CROSS_COMPILE=$(CROSS_COMPILE) $(MAKECMDGOALS)\n")
    topmake.close()
}

module_do_compile() {
	unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
	oe_runmake KSRC=${STAGING_KERNEL_DIR} \
	BUILD_KERNEL=${KERNEL_VERSION} \
	KVER=${KERNEL_VERSION} \
	INSTALL_MOD_PATH="${D}" \
	CC="${KERNEL_CC}" LD="${KERNEL_LD}" \
	AR="${KERNEL_AR}" \
	CONFIG_ANDROID_KERNEL=n \
	KERNELDIR=${STAGING_KERNEL_DIR} \
	CROSS_COMPILE=${STAGING_BINDIR_TOOLCHAIN}/${CROSS_COMPILE} \
	INSTALLDIR=${MLAN_INSTALLDIR} \
	default
}

module_do_install() {
	unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
	CROSS_COMPILE=$STAGING_BINDIR_TOOLCHAIN/$CROSS_COMPILE
	oe_runmake DEPMOD=echo INSTALL_MOD_PATH="${D}" \
	BUILD_KERNEL=${KERNEL_VERSION} \
	KSRC=${STAGING_KERNEL_DIR} \
	KVER=${KERNEL_VERSION} \
	CC="${KERNEL_CC}" LD="${KERNEL_LD}" \
	AR="${KERNEL_AR}" \
	CONFIG_ANDROID_KERNEL=n \
	KERNELDIR=${STAGING_KERNEL_DIR} \
	CROSS_COMPILE=${STAGING_BINDIR_TOOLCHAIN}/${CROSS_COMPILE} \
	INSTALLDIR=${MLAN_INSTALLDIR} \
	install
}

do_install_prepend() {
    install -d ${MLAN_INSTALLDIR}
    install -d ${D}${sysconfdir}/modprobe.d
}

do_install_append() {
    install -d ${D}${base_libdir}/firmware/${FW_PATH}
    install -m 755 ${S}/FwImage/${FW_FILE}					${D}${base_libdir}/firmware/${FW_PATH}
    install -m 755 ${S}/config/${TXPOWER_FILEPREFIX}WW_${ANTENNA_VERSION}.bin   ${D}${base_libdir}/firmware/${FW_PATH}/${TXPOWER_FILEPREFIX}WW.bin
    install -m 755 ${S}/wlan_src/mapp/mlanconfig/config/${MOD_PARAM_FILE}	${D}${base_libdir}/firmware/${FW_PATH}
    install -m 755 ${WORKDIR}/blacklist-mwifiex.conf                            ${D}${sysconfdir}/modprobe.d
}

