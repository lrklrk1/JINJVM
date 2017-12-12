package classfile;

public class ConstantMethodHandleInfo extends ConstantInfo implements Info {

    ConstantMethodHandleInfo() {
        this.tag = TAG.CONSTANT_MethodHandle;
    }

    @Override
    public void readInfo(ClassReader reader) {

    }
}
