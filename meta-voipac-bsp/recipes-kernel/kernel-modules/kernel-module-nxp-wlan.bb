require recipes-connectivity/nxp-wlan-sdk/nxp-wlan-sdk_git.inc

SUMMARY = "Kernel loadable module for NXP Wi-Fi module 88w8801/8987/8997/9098 IW416/612"

inherit module

EXTRA_OEMAKE += "-C ${STAGING_KERNEL_BUILDDIR} M=${S}"

KERNEL_MODULE_AUTOLOAD += "moal"
KERNEL_MODULE_PROBECONF += "moal"
module_conf_moal = "options moal mod_para=nxp/wifi_mod_para.conf"
