LICENSE = "CLOSED"
IMAGE_FEATURES += " ssh-server-dropbear debug-tweaks"

IMAGE_INSTALL:append = " i2c-tools \
                        linux-firmware-pcie8897 \
                        linux-firmware-pcie8997 \
                        alsa-utils alsa-tools alsa-lib alsa-plugins \
                        canutils \
                        iproute2 \
                        kernel-modules \
			packagegroup-fsl-gstreamer1.0-full \
			packagegroup-core-boot \
			packagegroup-base \
                	${CORE_IMAGE_EXTRA_INSTALL} \
			bluez5 \
			wpa-supplicant \
			v4l-utils \
			yavta \
			linux-firmware-pcie8897 linux-firmware-pcie8997 \
			evtest \
			glmark2 \
			stress-ng \
			coreutils \
			weston \
			iperf3 \
"

inherit core-image

IMAGE_LINGUAS = " "

