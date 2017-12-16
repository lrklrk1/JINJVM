package instructions.comparisons;

import instructions.base.NoOperandInstruction;
import rtda.Frame;

public class Lcmp {

    public class LCMP extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            long value2 = frame.getOperandStack().popLong();
            long value1 = frame.getOperandStack().popLong();
            if (value1 > value2) {
                frame.getOperandStack().pushInt(1);
            } else if (value1 == value2) {
                frame.getOperandStack().pushInt(0);
            } else {
                frame.getOperandStack().pushInt(-1);
            }
        }
    }
}
