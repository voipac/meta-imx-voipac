LICENSE = "CLOSED"

SRC_URI = "file://test.wav"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install() {
    install -d ${D}${datadir}/multimedia
    install -m 644 ${WORKDIR}/test.wav ${D}${datadir}/multimedia/sample.wav
}
