package classfile;

public class LocalVariableTableEntry {

    int startPC;
    int lineNumber;

    public LocalVariableTableEntry(int startPC, int lineNumber) {
        this.startPC = startPC;
        this.lineNumber = lineNumber;
    }

}
