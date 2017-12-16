package instructions.conversions;

import instructions.base.NoOperandInstruction;
import rtda.Frame;

public class F2x {

    public class F2I extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            float value = frame.getOperandStack().popFloat();
            frame.getOperandStack().pushInt((int)value);
        }
    }

    public class F2L extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            float value = frame.getOperandStack().popFloat();
            frame.getOperandStack().pushLong((long)value);
        }
    }

    public class F2D extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            float value = frame.getOperandStack().popFloat();
            frame.getOperandStack().pushDouble((double)value);
        }
    }

}
