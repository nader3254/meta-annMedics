SUMMARY = "A small image just capable of allowing a device to boot with no gui and support eglfs "

PROVIDES += "ann-medics"


################################################################################
# this will install minimum stuff to boot and additional stuff from BSP layer
################################################################################

IMAGE_INSTALL = "packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL}"

IMAGE_LINGUAS = " "


LICENSE = "MIT"

##############################################################
#    inherit some baisic features from core-image class
##############################################################

inherit core-image

####################################
#  minimum root filesystem size
#################################### 

IMAGE_ROOTFS_SIZE ?= "8192"
IMAGE_ROOTFS_EXTRA_SPACE_append = "${@bb.utils.contains("DISTRO_FEATURES", "systemd", " + 4096", "" ,d)}"


#IMAGE_FSTYPES_remove = "ext4 wic.gz tar.bz2 tar.xz"
#IMAGE_FSTYPES_append = " wic"










###################################################
#                installing Systemd
###################################################

LICENSE_FLAGS_WHITELIST_append = "commercial"
#INITRAMFS_FEATURES += "feature-ash"
#DISTRO_FEATURES_append = " sysvinit"
#DISTRO_FEATURES_BACKFILL_CONSIDERED = "sysvinit"
INIT_MANAGER = "systemd"

#################################################
#                   Networking
#################################################
IMAGE_INSTALL += "wifi-start-script"






