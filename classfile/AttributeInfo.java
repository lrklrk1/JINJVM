package classfile;

public class AttributeInfo {

    static Attribute[] readAttributes(ClassReader reader, ConstantPool cp) {
        int attributesCount = reader.parseU2().getInt();
        Attribute[] attributes = new Attribute[attributesCount];
        for(int i=0; i < attributesCount; i++) {
            attributes[i] = readAttribute(reader, cp);
        }
        return attributes;
    }

    static Attribute readAttribute(ClassReader reader, ConstantPool cp) {
        JVMU2 attrNameIndex = reader.parseU2();
        String attrName = cp.getUtf(attrNameIndex);
        int length = reader.parseU4().getInt();
        Attribute ai = Attribute.newAttribute(attrName, length, cp);
        ai.readInfo(reader);
        return ai;
    }

}
