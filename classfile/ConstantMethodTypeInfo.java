package classfile;

public class ConstantMethodTypeInfo extends ConstantInfo implements Info {

    ConstantMethodTypeInfo() {
        this.tag = TAG.CONSTANT_MethodType;
    }

    @Override
    public void readInfo(ClassReader reader) {

    }
}
