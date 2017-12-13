package classfile;

public interface Attribute {

    void readInfo(ClassReader reader);

    static Attribute newAttribute(String name, int length, ConstantPool cp) {

        switch (name) {
            case "Code":
                return new CodeAttribute(cp);
            case "ConstantValue":
                return new ConstantValueAttribute();
            case "Synthetic":
            case "Deprecated":
                return new MarkerAttribute();
            case "Exceptions":
                return new ExceptionAttribute();
            case "LineNumberTable":
                return new LineNumberTableAttribute();
            case "LocalVariableTable":
                return new LocalVariableTableAttribute();
            case "SourceFile":
                return new SourceFileAttribute(cp);
            default:
                return new UnparsedAttribute(name, length);
        }
    }

}
