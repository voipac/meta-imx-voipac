SUMMARY = "Wifi/BT Driver for spb228-pcie-uart"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=ab04ac0f249af12befccb94447c08b77"

PR                 = "r0"
FW_PATH            = "nxp"
TXPOWER_FILEPREFIX = "txpower_"

require config.inc
inherit module
#inherit showvars

SRC_URI = "${DRIVERTAR}"
MLAN_INSTALLDIR = "${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless/mlan"


KERNEL_MODULE_PROBECONF += "pcie8997"
module_conf_pcie8997 = "options pcie8997 fw_name=${FW_PATH}/${FW_FILE} cal_data_cfg=none drv_mode=3 mfg_mode=0 cfg80211_wext=0x0F reg_alpha2=US cntry_txpwr=1"

KERNEL_MODULE_PROBECONF += "hci_uart"


FILES_${PN} += "${base_libdir}/firmware/${FW_PATH}/${FW_FILE}"
FILES_${PN} += "${base_libdir}/firmware/${FW_PATH}/${TXPOWER_FILEPREFIX}*.bin"

do_patch_append() {
    bb.utils.copyfile(d.getVar('WORKDIR',True)+"/"+d.getVar('P',True)+"/wlan_src/gpl-2.0.txt", d.getVar('WORKDIR',True)+"/"+d.getVar('P',True)+"/COPYING")

    topmake_file = d.getVar('S',True)+"/Makefile"
    topmake      = open(topmake_file, 'w')
    topmake.write('all $(MAKECMDGOALS):\n')
    topmake.write('\tcd wlan_src &&')
    topmake.write(" $(MAKE) CONFIG_ANDROID_KERNEL=$(CONFIG_ANDROID_KERNEL) ARCH=$(ARCH) KERNELDIR=$(KERNELDIR) CROSS_COMPILE=$(CROSS_COMPILE) $(MAKECMDGOALS) &&")
    topmake.write(' cd ../muart_src &&')
    topmake.write(" $(MAKE) CONFIG_ANDROID_KERNEL=$(CONFIG_ANDROID_KERNEL) ARCH=$(ARCH) KERNELDIR=$(KERNELDIR) CROSS_COMPILE=$(CROSS_COMPILE) $(MAKECMDGOALS)\n")
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
}

do_install_append() {
    install -d ${D}${base_libdir}/firmware/${FW_PATH}
    install -m 755 ${WORKDIR}/${P}/FwImage/${FW_FILE}                                     ${D}${base_libdir}/firmware/${FW_PATH}
    install -m 755 ${WORKDIR}/${P}/config/${TXPOWER_FILEPREFIX}WW_${ANTENNA_VERSION}.bin  ${D}${base_libdir}/firmware/${FW_PATH}/${TXPOWER_FILEPREFIX}WW.bin
}

