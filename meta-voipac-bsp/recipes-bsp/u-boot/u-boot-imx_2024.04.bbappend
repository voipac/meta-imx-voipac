FILESEXTRAPATHS:append := ":${THISDIR}/${PN}:"

SRC_URI:append = " \
	file://0001-Added-voipac-machine.patch \
"	

# fix issue with deploying u-boot
UUU_BOOTLOADER:mx9-generic-bsp = ""
