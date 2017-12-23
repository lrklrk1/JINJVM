package instructions.base;

public abstract class Index16Instruction implements Instruction {

    private int index;

    @Override
    public void fetchOperands(BytecodeReader reader) {
        this.index = reader.parse2();
    }

    public int getIndex() {
        return index;
    }

}
