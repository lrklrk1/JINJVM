package instructions.conversions;

import instructions.base.NoOperandInstruction;
import rtda.Frame;

public class L2x {

    public class L2I extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            long value = frame.getOperandStack().popLong();
            frame.getOperandStack().pushInt((int)value);
        }
    }

    public class L2D extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            long value = frame.getOperandStack().popLong();
            frame.getOperandStack().pushDouble((double)value);
        }
    }

    public class L2F extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            long value = frame.getOperandStack().popLong();
            frame.getOperandStack().pushFloat((float)value);
        }
    }

}
