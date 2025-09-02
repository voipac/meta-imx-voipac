FILESEXTRAPATHS:append := ":${THISDIR}/${PN}:"

SRC_URI:append = " \
	file://0001-Added-voipac-machine.patch \
	file://0002-Use-compile-time-dram-size-setup.patch \
	file://0003-Added-support-for-imx91-voipac-evk.patch \
	file://0004-Wip-Fixes.patch \
	file://1001-Added-support-for-voipac-imx8mq-boards.patch \
	file://1002-voipc-Increase-VDD_SOC-to-fix-issue-with-negative-te.patch \
	file://1003-Changes-for-new-u-boot-version.patch \
"	

# dram size selection (default u-boot config is 512M)
SRC_URI:append:mx9-generic-bsp = " \
	${@bb.utils.contains('DRAM_SIZE', '1G', 'file://dram_1g.cfg','',d)} \
	${@bb.utils.contains('DRAM_SIZE', '2G', 'file://dram_2g.cfg','',d)} \
"

# fix issue with deploying u-boot
UUU_BOOTLOADER:mx9-generic-bsp = ""
