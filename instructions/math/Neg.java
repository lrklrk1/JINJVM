package instructions.math;

import instructions.base.NoOperandInstruction;
import rtda.Frame;

public class Neg {

    public class DNEG extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            double value = frame.getOperandStack().popDouble();
            frame.getOperandStack().pushDouble(-value);
        }
    }

    public class FNEG extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            float value = frame.getOperandStack().popFloat();
            frame.getOperandStack().pushFloat(-value);
        }
    }

    public class LNEG extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            long value = frame.getOperandStack().popLong();
            frame.getOperandStack().pushLong(-value);
        }
    }

    public class INEG extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            int value = frame.getOperandStack().popInt();
            frame.getOperandStack().pushInt(-value);
        }
    }

}
