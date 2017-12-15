package instructions.base;

public abstract class BranchInstruction implements Instruction {

    int offset;

    @Override
    public void fetchOperands(BytecodeReader reader) {
        this.offset = reader.parse2();
    }
}
