package instructions.conversions;

import instructions.base.NoOperandInstruction;
import rtda.Frame;

public class D2x {

    public class D2F extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            double value = frame.getOperandStack().popDouble();
            frame.getOperandStack().pushFloat((float)value);
        }
    }

    public class D2I extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            double value = frame.getOperandStack().popDouble();
            frame.getOperandStack().pushInt((int)value);
        }
    }

    public class D2L extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            double value = frame.getOperandStack().popDouble();
            frame.getOperandStack().pushLong((long)value);
        }
    }


}
