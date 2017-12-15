package instructions.base;

import classfile.ClassReader;
import classfile.ClassReader;
import rtda.Frame;

public interface Instruction {
    void fetchOperands(BytecodeReader reader);
    void execute(Frame frame);
}
