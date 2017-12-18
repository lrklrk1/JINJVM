package instructions.math;

import instructions.base.BytecodeReader;
import instructions.base.NoOperandInstruction;
import rtda.Frame;

public class Xor {

    public class IXOR extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            int value1 = frame.getOperandStack().popInt();
            int value2 = frame.getOperandStack().popInt();
            int result = value1 ^ value2;
            frame.getOperandStack().pushInt(result);
        }
    }

    public class LXOR extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            long value1 = frame.getOperandStack().popLong();
            long value2 = frame.getOperandStack().popLong();
            long result = value1 ^ value2;
            frame.getOperandStack().pushLong(result);
        }
    }

}
