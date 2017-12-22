package classfile;

import rtda.heap.Constant;

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

    public CodeAttribute[] getArrtibute() {
        CodeAttribute[] codeAttributes = new CodeAttribute[attributes.length];
        for (int i = 0; i < attributes.length; i++) {
            if (attributes[i] instanceof CodeAttribute) {
                codeAttributes[i] = (CodeAttribute)attributes[i];
            }
        }
        return codeAttributes;
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

    public int getAccessFlag() {
        return accessFlag.getInt();
    }

    public ConstantValueAttribute getConstantValueAttribute() {
        ConstantValueAttribute cva = null;
        for (AttributeInfo attr : attributes) {
            if (attr instanceof ConstantValueAttribute) {
                cva = (ConstantValueAttribute) attr;
            }
        }
        return cva;
    }

}
