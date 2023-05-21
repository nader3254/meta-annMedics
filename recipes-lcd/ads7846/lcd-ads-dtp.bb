SUMMARY = "Enable adc7846 chip of our lcd "
DESCRIPTION = "this recipe will add ads7846 device tree binary for our rpi to load screen toutch kernel drivers"

LICENSE = "CLOSED"

SRC_URI += "file://ads7846.dtbo"

RDEPENDS_${PN} += "bash"

inherit deploy nopackages


do_install() {
    install -d ${D}/boot/overlays/
    install -m 0777 ${WORKDIR}/ads7846.dtbo ${D}/boot/overlays/
    
    
}

do_deploy() {

	install -d ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}
	echo "aha by nader hany" >> ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt
}
 
FILES_${PN} += "boot/overlays/ads7846.dtbo"
