include u-boot-hostmobility.inc

PV = "v${SRCBRANCH}+git${SRCPV}"

LOCALVERSION = " ${SRCBRANCH}"

SRCREV = "1b121c6ab548a9af0a27876e9eaa0c654c1dc3e1"
SRCBRANCH = "mx4-bsp-2.0.x-IMX7"

DEFAULT_PREFERENCE = "1"

# require u-boot-dtb-tegra.bin to be used
UBOOT_IMAGE_tegra = "u-boot-dtb-tegra-${MACHINE}-${PV}-${PR}.${UBOOT_SUFFIX}"
UBOOT_BINARY_tegra = "u-boot-dtb-tegra.${UBOOT_SUFFIX}"
UBOOT_SYMLINK_tegra = "u-boot-dtb-tegra-${MACHINE}.${UBOOT_SUFFIX}"
