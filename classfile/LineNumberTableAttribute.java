package classfile;

public class
LineNumberTableAttribute implements AttributeInfo {

    LineNumberTableEntry[] lineNumberTable;

    @Override
    public void readInfo(ClassReader reader) {
        int lineNumberLength = reader.parseU2().getInt();
        lineNumberTable = new LineNumberTableEntry[lineNumberLength];
        for (int i = 0; i < lineNumberLength; i++) {
            lineNumberTable[i] = new LineNumberTableEntry(reader.parseU2().getInt(), reader.parseU2().getInt());
        }
    }
}
