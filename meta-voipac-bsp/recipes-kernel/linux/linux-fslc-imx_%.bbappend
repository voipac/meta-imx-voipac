FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " \
	file://0001-Added-custom-voipac-devicetree.patch \
	file://0002-ASoC-wm8904-extend-device-tree-support.patch \
	file://0003-ASoC-wm8904-add-DMIC-support.patch \
	file://0004-ASoC-fsl-asoc-card-add-WM8904-support.patch \
	file://0005-ASoC-fsl-asoc-card-Defer-probe-when-fail-to-find-cod.patch \
	file://0006-Input-touchscreen-Driver-for-SiS-95xx-controller.patch \
	file://0007-Input-touchscreen-Driver-for-SiS-95xx-controller.patch \
	file://0008-Input-touchscreen-SiS95xx-driver-Bug-fix-touch.patch \
	file://0009-Input-touchscreen-Select-FW_LOADER-config.patch \
	file://0010-Input-touchscreen-SiS95xx-driver-removed-recalib-add.patch \
	file://0011-Input-touchscreen-SiS95xx-drv-change-in-update_fw-an.patch \
	file://0012-Input-touchscreen-SiS95xx-driver-added-fwmode.patch \
	file://0013-Input-touchscreen-SiS95xx-driver-added-diffdata.patch \
	file://0014-sis_i2c_95xx_ts-Drop-using-of-reset-pin.patch \
	file://0015-Added-driver-for-mcp251xfd-chips.patch \
	file://0016-ov5640_mipi_v2-When-regulator-fails-to-be-probed-ret.patch \
	file://0017-Added-mipi-lvds-bridge.patch \
	file://0018-can-spi-mcp25xxfd-Don-t-retry-when-device-cannot-be-.patch \
	file://0019-extcon-ptn5150-Don-t-request-vbus-gpio.patch \
	file://0020-sound-codecs-wm8904-Added-micbias-for-microphone-inp.patch \
	\
	file://bluetooth.cfg \
	file://wifi.cfg \
	file://audio.cfg \
	file://rtc.cfg \
	file://koe_touch.cfg \
	file://nh_touch.cfg \
	file://nh_lcd.cfg \
	file://can.cfg \
	file://usbc.cfg \
	file://iwlwifi.cfg \
"
