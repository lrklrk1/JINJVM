package classfile;

public class ConstantInvokeDynamicInfo extends ConstantInfo implements Info {

    ConstantInvokeDynamicInfo() {
        this.tag = TAG.CONSTANT_InvokeDynamic;
    }

    @Override
    public void readInfo(ClassReader reader) {

    }
}
