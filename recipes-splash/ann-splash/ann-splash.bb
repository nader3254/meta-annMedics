SUMMARY = "replace the static splash with ann medics splash"
DESCRIPTION = "Script to change splash screen on the target device"

LICENSE = "CLOSED"

SRC_URI += "file://annSplash \
            file://psplash-raspberrypi \
            file://psplash-write"

RDEPENDS_${PN} += "bash psplash"
INSANE_SKIP_${PN}_append = "already-stripped"


do_install() {
    install -d ${D}/usr/bin
    install -m 0777 ${WORKDIR}/annSplash ${D}/usr/bin
    ln -s ${D}/usr/bin/annSplash ${D}/usr/bin/psplash
}


