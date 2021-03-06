require recipes-kernel/linux/linux-imx.inc

SUMMARY = "Linux kernel for MX-4 products using Toradex Colibri VFxx COMs"

SRC_URI = "git://github.com/viktorfriberg/linux-toradex.git;protocol=https;branch=${SRCBRANCH} \
           file://defconfig \
           file://*.dts \
           file://*.dtsi \
           file://*.h \
           file://Makefile"

KERNEL_MODULE_AUTOLOAD += "${@bb.utils.contains('COMBINED_FEATURES', 'usbgadget', ' libcomposite', '',d)}"

LOCALVERSION = "-${SRCBRANCH}"
SRCBRANCH = "mx4-bsp-2.0.x-IMX7"
SRCREV = "cc798791dffa2a4cc9716207e42e1cb2f81acac7"
DEPENDS += "lzop-native bc-native u-boot-mkimage-native"
COMPATIBLE_MACHINE = "(mx4-v61-imx7)"

# We use CONFIG_ARM_APPENDED_DTB=y and below shall take care of that

do_configure_append() {
    install -m 0644 ${WORKDIR}/*.dts ${S}/arch/arm/boot/dts/
    install -m 0644 ${WORKDIR}/*.dtsi ${S}/arch/arm/boot/dts/
    install -m 0644 ${WORKDIR}/*.h ${S}/arch/arm/boot/dts/
    install -m 0644 ${WORKDIR}/Makefile ${S}/arch/arm/boot/dts/
}

do_uboot_mkimage() {
    cd ${B}
    echo "test"
    cat ${KERNEL_OUTPUT_DIR}/zImage ${KERNEL_OUTPUT_DIR}/dts/${KERNEL_DEVICETREE} > combined-image
    mkimage -A arm -C none -a ${UBOOT_ENTRYPOINT} -e ${UBOOT_ENTRYPOINT} -T kernel -d combined-image ${KERNEL_OUTPUT_DIR}/uImage
}

do_deploy_append() {
    type=uImage
    base_name=${type}-${KERNEL_IMAGE_BASE_NAME}
    install -m 0644 ${KERNEL_OUTPUT_DIR}/${type} ${DEPLOYDIR}/${base_name}.bin

    symlink_name=uImage-${KERNEL_IMAGE_SYMLINK_NAME}
    ln -sf ${base_name}.bin ${DEPLOYDIR}/${symlink_name}.bin
    ln -sf ${base_name}.bin ${DEPLOYDIR}/${type}
}
