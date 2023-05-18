SUMMARY = "Enable WiFi script"
DESCRIPTION = "Script to enable WiFi on the target device"

LICENSE = "CLOSED"

SRC_URI += "file://wifi-start.sh"

RDEPENDS_${PN} += "bash"


#DISTRO_FEATURES_append += "  wifi linux-firmware-bcm43430 linux-firmware-brcmfmac43430"
#IMAGE_INSTALL_append += "  linux-firmware-bcm43430 bridge-utils hostapd dhcp-server iptables wpa-supplicant kernel-modules linux-#firmware-ralink linux-firmware-rtl8192ce linux-firmware-rtl8192cu linux-firmware-rtl8192su linux-firmware-rpidistro-bcm43430" 


do_install() {
    install -d ${D}/etc/rcS.d
    install -m 0777 ${WORKDIR}/wifi-start ${D}/etc/rcS.d/S05wifi-start.sh
}

FILES_${PN} += "/etc/rcS.d/S05wifi-start.sh"
