FILESEXTRAPATHS:append := ":${THISDIR}/${PN}:"

SRC_URI:append = " \
	file://0001-Added-support-for-voipac-boards-still-in-evk.patch \
	file://0002-Drop-building-some-dtbs-small-drops.patch \
"	
