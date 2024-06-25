LICENSE = "CLOSED"
IMAGE_FEATURES += " ssh-server-dropbear debug-tweaks"

IMAGE_INSTALL:append = " i2c-tools \
                        alsa-utils alsa-tools alsa-lib alsa-plugins \
                        canutils \
                        iproute2 \
                        kernel-modules \
			packagegroup-core-boot \
			packagegroup-base \
                	${CORE_IMAGE_EXTRA_INSTALL} \
			bluez5 \
			wpa-supplicant \
			evtest \
			stress-ng \
			coreutils \
			iperf3 \
			nxp-wlan-sdk \
			kernel-module-mlan \
			kernel-module-moal \
			firmware-nxp-wifi-nxpiw416-sdio \
"

inherit core-image

IMAGE_LINGUAS = " "

