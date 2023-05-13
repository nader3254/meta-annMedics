#!/bin/bash

#######################################################################
#    This bash script will enable the wifi using the wpa_supplicant
#######################################################################



DEVICE_IP=150

wpa_supplicant  -B -D nl80211  -i wlan0  -c /etc/wpa_supplicant.conf
ifconfig wlan0 192.168.1.${DEVICE_IP}
route add default gw  192.168.1.1


