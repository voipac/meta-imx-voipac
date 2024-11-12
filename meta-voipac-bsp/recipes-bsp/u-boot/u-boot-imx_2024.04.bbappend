FILESEXTRAPATHS:append := ":${THISDIR}/${PN}:"

SRC_URI:append = " \
	file://0001-Added-voipac-machine.patch \
	file://0002-Use-compile-time-dram-size-setup.patch \
"	

# dram size selection (default u-boot config is 512M)
SRC_URI:append = " \
	${@bb.utils.contains('DRAM_SIZE', '1G', 'file://dram_1g.cfg','',d)} \
	${@bb.utils.contains('DRAM_SIZE', '2G', 'file://dram_2g.cfg','',d)} \
"

# fix issue with deploying u-boot
UUU_BOOTLOADER:mx9-generic-bsp = ""
