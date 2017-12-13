package classfile;

public class ConstantValueAttribute implements Attribute {

    int constantValueIndex;

    @Override
    public void readInfo(ClassReader reader) {
        this.constantValueIndex = reader.parseU2().getInt();
    }

    public int getConstantValueIndex() {
        return this.constantValueIndex;
    }
}
