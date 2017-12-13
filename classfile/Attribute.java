package classfile;

public class Attribute {

    static AttributeInfo[] readAttributes(ClassReader reader, ConstantPool cp) {
        int attributeCount = reader.parseU2().getInt();
        AttributeInfo[] attributes = new AttributeInfo[attributeCount];
        for (int i = 0; i < attributeCount; i++) {
            attributes[i] = readAttribute(reader, cp);
        }
        return attributes;
    }

    static AttributeInfo readAttribute(ClassReader reader, ConstantPool cp) {
        JVMU2 attrNameIndex = reader.parseU2();
        String attrName = cp.getUtf(attrNameIndex);
        int length = reader.parseU4().getInt();
        AttributeInfo ai = AttributeInfo.newAttribute(attrName, length, cp);
        ai.readInfo(reader);
        return ai;
    }

}
