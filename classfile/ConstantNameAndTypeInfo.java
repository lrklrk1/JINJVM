package classfile;

public class ConstantNameAndTypeInfo extends ConstantInfo implements Info {

    private JVMU2 nameIndex;
    private JVMU2 descriptorIndex;

    ConstantNameAndTypeInfo() {
        this.tag = TAG.CONSTANT_NameAndType;
    }

    @Override
    public void readInfo(ClassReader reader) {
        this.nameIndex = reader.parseU2();
        this.descriptorIndex = reader.parseU2();
        System.out.println(this.tag + " " + this.descriptorIndex + " " + this.nameIndex);
    }

    JVMU2 getName() {
        return this.nameIndex;
    }

    JVMU2 getDescriptorIndex() {
        return this.descriptorIndex;
    }
}
