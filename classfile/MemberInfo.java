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

    public CodeAttribute getCodeArrtibute() {
        for (AttributeInfo attr : attributes) {
            if (attr instanceof CodeAttribute) {
                return (CodeAttribute)attr;
            }
        }
        return null;
    }

    public String getName() {
        return constantPool.getUtf(nameIndex);
    }

    public String getDescriptor() {
        return constantPool.getUtf(deacriptorIndex);
    }

    public String getAttributeCount() {
        return attributes.length + "";
    }

}
