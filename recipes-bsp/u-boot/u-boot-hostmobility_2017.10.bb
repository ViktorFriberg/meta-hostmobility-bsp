include u-boot-hostmobility.inc

LIC_FILES_CHKSUM = "file://Licenses/README;md5=a2c678cfd4a4d97135585cad908541c6"

PV = "v${SRCBRANCH}+git${SRCPV}"

LOCALVERSION = " ${SRCBRANCH}"

SRCREV = "e4a409d47db1f62a8deb8a417dc6afbec6f2c81f"
SRCBRANCH = "mx4-bsp-2.0.x-IMX7"

DEFAULT_PREFERENCE = "1"

# require u-boot-dtb-tegra.bin to be used
UBOOT_IMAGE_tegra = "u-boot-dtb-tegra-${MACHINE}-${PV}-${PR}.${UBOOT_SUFFIX}"
UBOOT_BINARY_tegra = "u-boot-dtb-tegra.${UBOOT_SUFFIX}"
UBOOT_SYMLINK_tegra = "u-boot-dtb-tegra-${MACHINE}.${UBOOT_SUFFIX}"
