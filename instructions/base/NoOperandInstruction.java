package instructions.base;

import rtda.Frame;

public abstract class NoOperandInstruction implements Instruction {
    @Override
    public void fetchOperands(BytecodeReader reader) {
//        nothing to do
    }

}
