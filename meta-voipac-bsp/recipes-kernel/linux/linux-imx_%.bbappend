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
	file://0024-Fix-display-pwm.patch \
	file://0025-Added-robot-board-pwm-handling.patch \
	file://0026-Restructure-dts-to-common-parts-and-machine-specific.patch \
	file://0027-Added-support-for-imx91-board.patch \
	file://voipac.cfg \
"

SRC_URI:append:imx8mq-voipac = " \
	file://1001-Added-custom-voipac-devicetree.patch \
	file://1002-Input-touchscreen-Driver-for-SiS-95xx-controller.patch \
	file://1003-Input-touchscreen-Driver-for-SiS-95xx-controller.patch \
	file://1004-Input-touchscreen-SiS95xx-driver-Bug-fix-touch.patch \
	file://1005-Input-touchscreen-Select-FW_LOADER-config.patch \
	file://1006-Input-touchscreen-SiS95xx-driver-removed-recalib-add.patch \
	file://1007-Input-touchscreen-SiS95xx-drv-change-in-update_fw-an.patch \
	file://1008-Input-touchscreen-SiS95xx-driver-added-fwmode.patch \
	file://1009-Input-touchscreen-SiS95xx-driver-added-diffdata.patch \
	file://1010-sis_i2c_95xx_ts-Drop-using-of-reset-pin.patch \
	file://1011-ov5640_mipi_v2-When-regulator-fails-to-be-probed-ret.patch \
	file://1012-extcon-ptn5150-Don-t-request-vbus-gpio.patch \
	file://audio.cfg \
	file://bluetooth.cfg \
	file://can.cfg \
	file://nh_lcd.cfg \
	file://rtc.cfg \
	file://usbc.cfg \
	file://wifi.cfg \
"

DELTA_KERNEL_DEFCONFIG = "voipac.cfg"
DELTA_KERNEL_DEFCONFIG:imx8mq-voipac = "audio.cfg  bluetooth.cfg  can.cfg  nh_lcd.cfg  rtc.cfg  usbc.cfg  wifi.cfg"
