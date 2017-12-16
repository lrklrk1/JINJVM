package instructions.math;

import instructions.base.NoOperandInstruction;
import rtda.Frame;

public class And {

    public class IAND extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            int value2 = frame.getOperandStack().popInt();
            int value1 = frame.getOperandStack().popInt();
            int result = value1 & value2;
            frame.getOperandStack().pushInt(result);
        }
    }

    public class LAND extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            long value2 = frame.getOperandStack().popLong();
            long value1 = frame.getOperandStack().popLong();
            long result = value1 & value2;
            frame.getOperandStack().pushLong(result);
        }
    }

}
