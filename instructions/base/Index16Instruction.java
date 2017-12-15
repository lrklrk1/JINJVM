package instructions.base;

public abstract class Index16Instruction implements Instruction {

    int index;

    @Override
    public void fetchOperands(BytecodeReader reader) {
        this.index = reader.parse2();
    }
}
