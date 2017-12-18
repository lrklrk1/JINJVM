package classfile;

public class CodeAttribute implements AttributeInfo {

    ConstantPool cp;
    int maxStack;
    int maxLocals;
    byte[] code;
    ExceptionTableEntry[] exceptionTable;
    AttributeInfo[] attributes;

    @Override
    public void readInfo(ClassReader reader) {
        this.maxStack = reader.parseU2().getInt();
        this.maxLocals = reader.parseU2().getInt();
        int codelength = reader.parseU4().getInt();
        this.code = reader.parseBytes(codelength);
        this.exceptionTable = readExceptionTable(reader);
        this.attributes = Attribute.readAttributes(reader, cp);
    }

    private ExceptionTableEntry[] readExceptionTable(ClassReader reader) {
        int exceptionTableLength = reader.parseU2().getInt();
        exceptionTable = new ExceptionTableEntry[exceptionTableLength];
        for (int i = 0; i < exceptionTableLength; i++) {
            exceptionTable[i] = new ExceptionTableEntry(reader.parseU2().getInt(),
                                                        reader.parseU2().getInt(),
                                                        reader.parseU2().getInt(),
                                                        reader.parseU2().getInt());
        }
        return exceptionTable;
    }

    public CodeAttribute(ConstantPool cp) {
        this.cp = cp;
    }

    public int getMaxStack() {
        return maxStack;
    }

    public int getMaxLocals() {
        return maxLocals;
    }

    public byte[] getCode() {
        return code;
    }

    public ExceptionTableEntry[] getExceptionTable() {
        return exceptionTable;
    }

    public AttributeInfo[] getAttributes() {
        return attributes;
    }
}
