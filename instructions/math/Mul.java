package instructions.math;

import instructions.base.NoOperandInstruction;
import rtda.Frame;

public class Mul {

    public class DMUL extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            double value2 = frame.getOperandStack().popDouble();
            double value1 = frame.getOperandStack().popDouble();
            double result = value2 * value1;
            frame.getOperandStack().pushDouble(result);
        }
    }

    public class FMUL extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            float value2 = frame.getOperandStack().popFloat();
            float value1 = frame.getOperandStack().popFloat();
            float result = value2 * value1;
            frame.getOperandStack().pushFloat(result);
        }
    }

    public class LMUL extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            long value2 = frame.getOperandStack().popLong();
            long value1 = frame.getOperandStack().popLong();
            long result = value2 * value1;
            frame.getOperandStack().pushLong(result);
        }
    }

    public class IMUL extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            int value2 = frame.getOperandStack().popInt();
            int value1 = frame.getOperandStack().popInt();
            int result = value2 * value1;
            frame.getOperandStack().pushInt(result);
        }
    }

}
