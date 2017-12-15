package classfile;

public class LocalVariableTableAttribute implements AttributeInfo {

    LocalVariableTableEntry[] localVariableTable;

    @Override
    public void readInfo(ClassReader reader) {
        int localVariableLength = reader.parseU2().getInt();
        localVariableTable = new LocalVariableTableEntry[localVariableLength];
        for (int i = 0; i < localVariableLength; i++) {
            localVariableTable[i] = new LocalVariableTableEntry(reader.parseU2().getInt(), reader.parseU2().getInt());
        }
    }
}
