package classfile;

public class MemberInfo {

    private ConstantPool constantPool;
    private JVMU2 accessFlag;
    private JVMU2 nameIndex;
    private JVMU2 deacriptorIndex;
    AttributeInfo[] attributes;

    MemberInfo(ConstantPool cp, JVMU2 accessFlag, JVMU2 nameIndex, JVMU2 descriptorIndex, AttributeInfo[] attributes) {
        this.constantPool = cp;
        this.accessFlag = accessFlag;
        this.nameIndex = nameIndex;
        this.deacriptorIndex = descriptorIndex;
        this.attributes = attributes;
    }

    public String getName() {
        return this.constantPool.getUtf(this.nameIndex);
    }

    public String getDescriptor() {
        return this.constantPool.getUtf(this.deacriptorIndex);
    }

    public String getAttributeCount() {
        return this.attributes.length + "";
    }

}
