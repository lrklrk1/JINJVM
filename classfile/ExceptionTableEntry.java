package classfile;

public class ExceptionTableEntry {

    int startPC;
    int endPC;
    int handlerPC;
    int catchType;

    public ExceptionTableEntry(int startPC, int endPC, int handlePC, int catchType) {
        this.startPC = startPC;
        this.endPC = endPC;
        this.handlerPC = handlePC;
        this.catchType = catchType;
    }

}
