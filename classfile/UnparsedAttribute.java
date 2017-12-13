package classfile;

public class UnparsedAttribute extends MarkerAttribute {

    String name;
    int length;
    byte[] info;

    @Override
    public void readInfo(ClassReader reader) {
        this.info = reader.parseBytes(length);
    }

    public UnparsedAttribute(String name, int length) {
        this.name = name;
        this.length = length;
    }
}
