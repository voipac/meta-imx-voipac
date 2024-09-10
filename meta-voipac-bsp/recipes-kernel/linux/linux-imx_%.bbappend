FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " \
	file://0001-Added-dts-to-build.patch \
	file://0002-Added-dtsi-file.patch \
	file://0003-gpio-pca953x-First-read-sometimes-fails-retry.patch \
	file://0004-som-Added-support-for-user-led-move-ethernet-nodes-t.patch \
	file://0005-SBC-Drop-override-for-i2c1.patch \
	file://0006-Added-buttons-handling-SBC-user-led-support.patch \
	file://0007-ASoC-fsl-asoc-card-add-WM8904-support.patch \
	file://0008-ASoC-wm8904-add-DMIC-support.patch \
	file://0009-Audio-card-probed.patch \
	file://0010-Make-usb-host-eeprom-rtc-working.patch \
	file://0011-Added-display-devicetree.patch \
	file://0012-Enable-both-CAN-interfaces.patch \
	file://0013-Added-uart2-uart6-support.patch \
	file://0014-Added-support-for-Bluetooth-port.patch \
	file://0015-Move-pmic-to-proper-i2c-bus.patch \
	file://0016-Fixes-for-audio-card.patch \
	file://0017-Added-wakeup-button-example.patch \
	file://0018-Fix-touch-handling.patch \
	file://0019-Added-camera-support.patch \
	file://0020-ov5640-Not-fail-when-frequency-is-0.patch \
	file://0021-sound-codecs-wm8904-Added-micbias-for-microphone-inp.patch \
	file://0022-Added-dmic-support.patch \
	file://0023-6.6.23-fixes.patch \
"
