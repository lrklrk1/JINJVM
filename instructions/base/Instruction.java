package instructions.base;

import rtda.Frame;

public interface Instruction {
    void fetchOperands(BytecodeReader reader);
    void execute(Frame frame);
}
