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


IMAGE_FSTYPES_remove = "ext4 ext3 .manifest .json .bmap wic.gz wic.bz2 "
IMAGE_FSTYPES_append = " wic "





########################################################################
#                       installing Systemd 
#  will not working unless you copy the following lines to local.conf
########################################################################

#LICENSE_FLAGS_WHITELIST_append = " commercial_faad2"
#VIRTUAL-RUNTIME_init_manager = "systemd"
#VIRTUAL-RUNTIME_initscripts = "systemd-compat-units"
#DISTRO_FEATURES_append = " systemd"
#DISTRO_FEATURES_BACKFILL_CONSIDERED += "sysvinit"
#INIT_MANAGER = "systemd"

#########################################################################
#                       installing Systvinit
#   will not working unless you copy the following lines to local.conf
#########################################################################

#LICENSE_FLAGS_WHITELIST_append = "commercial"
#INITRAMFS_FEATURES += "feature-ash"
#DISTRO_FEATURES_append = " sysvinit"
#DISTRO_FEATURES_BACKFILL_CONSIDERED = "sysvinit"
#INIT_MANAGER = "sysvinit"

#################################################
#                   Networking
#################################################

DISTRO_FEATURES_append += " wifi linux-firmware-bcm43430 linux-firmware-brcmfmac43430"
IMAGE_INSTALL_append += "  linux-firmware-bcm43430  wpa-supplicant kernel-modules linux-firmware-rpidistro-bcm43430" 

IMAGE_INSTALL += "wifi-start-script"

#################################################
#                   Splash 
#################################################


IMAGE_INSTALL_append = " psplash"
IMAGE_FEATURES += " splash "
IMAGE_INSTALL += "ann-medics-splash  ann-splash"



#################################################
#                   LCD HDMI
#################################################

IMAGE_INSTALL += "lcd-ads-dtp"
DISABLE_OVERSCAN = "1"
DISABLE_SPLASH = "1"
BOOT_DELAY = "0"
BOOT_DELAY_MS = "0"
HDMI_GROUP = "2"
HDMI_MODE = "87"
DISABLE_RPI_BOOT_LOGO = "1"
ENABLE_SPI_BUS = "1"
ENABLE_I2C = "1"
KERNEL_MODULE_AUTOLOAD:rpi += "i2c-dev i2c-bcm2708"
ENABLE_UART = "1"

hdmi_force_hotplug="1"
config_hdmi_boost="7"
HDMI_DRIVE ="1"
HDMI_CTV ="800 480 60 6 0 0 0"
DTOVERLAY += "ads7846,cs=1,penirq=25,penirq_pull=2,speed=50000,keep_vref_on=0,swapxy=0,pmax=255,xohms=150,xmin=200,xmax=3900,ymin=200,ymax=3900"

#dtoverlay=disable-bt


