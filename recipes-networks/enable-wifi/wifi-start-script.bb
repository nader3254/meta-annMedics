SUMMARY = "Enable WiFi script"
DESCRIPTION = "Script to enable WiFi on the target device"

LICENSE = "CLOSED"

SRC_URI += "file://wifi-start"

RDEPENDS_${PN} += "bash"

do_install() {
    install -d ${D}/etc
    install -m 0777 ${WORKDIR}/wifi-start ${D}/etc/
}

FILES_${PN} += "/bin/wifi-start"
