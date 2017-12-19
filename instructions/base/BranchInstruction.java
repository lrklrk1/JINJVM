package instructions.base;

public abstract class BranchInstruction implements Instruction {

    private int offset;

    @Override
    public void fetchOperands(BytecodeReader reader) {
        this.offset = reader.parse2();
        short s = (short)offset;
    }

    public int getOffset() {
        return offset;
    }
}
