package classfile;

public class LineNumberTableEntry {

    int startPC;
    int lineNumber;

    public LineNumberTableEntry(int startPC, int lineNumber) {
        this.startPC = startPC;
        this.lineNumber = lineNumber;
    }

}
