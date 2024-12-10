FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
	file://0001-Added-support-for-handling-fan-leds.patch \
	file://asound.conf_imx93voipac \
	file://run.sh \
"

do_patch:append() {
        cp ${WORKDIR}/0001-Added-support-for-handling-fan-leds.patch ${WORKDIR}/git
        cd ${WORKDIR}/git/ && git apply 0001-Added-support-for-handling-fan-leds.patch
}

do_install:append() {
    install  -m 644 ${WORKDIR}/asound.conf_imx93voipac ${D}${GPNT_APPS_FOLDER}/scripts/multimedia/smart-kitchen/conf
    install  -m 755 ${WORKDIR}/run.sh ${D}${GPNT_APPS_FOLDER}/scripts/multimedia/smart-kitchen/
}
