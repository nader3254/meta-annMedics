SUMMARY = "Enable WiFi script"
DESCRIPTION = "Script to enable WiFi on the target device"

LICENSE = "CLOSED"

SRC_URI += "file://splash"

RDEPENDS_${PN} += "bash"



do_install() {
    install -d ${D}/etc/init.d
    install -m 0777 ${WORKDIR}/splash ${D}/etc/init.d/splash
    rm -rf  ${D}/etc/rcS.d/S00psplash* 
}

FILES_${PN} += "/etc/init.d/splash"
