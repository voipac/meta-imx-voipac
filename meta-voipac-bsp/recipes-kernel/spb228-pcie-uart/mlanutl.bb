SUMMARY = "mlanutl for spb228-pcie-uart"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

PR                 = "r0"
FW_PATH            = "nxp"
TXPOWER_FILEPREFIX = "txpower_"

require config.inc

S = "${WORKDIR}/${DRIVERNAME}"
SRC_URI = "${DRIVERTAR}"

TARGET_CC_ARCH += "${LDFLAGS}"

FILES:${PN} += "${bindir}/mlanutl"

do_compile () {
        cd wlan_src
        oe_runmake CC="$CC" mapp/mlanutl
}

do_install:prepend() {
    install -d ${D}${bindir}
}

do_install:append() {
    install -m 755 ${S}/wlan_src/mlanutl				        ${D}${bindir}
}

