package instructions.math;

import instructions.base.NoOperandInstruction;
import rtda.Frame;

public class Add {

    public class DADD extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            double value1 = frame.getOperandStack().popDouble();
            double value2 = frame.getOperandStack().popDouble();
            double result = value1 + value2;
            frame.getOperandStack().pushDouble(result);
        }
    }

    public class LADD extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            long value1 = frame.getOperandStack().popLong();
            long value2 = frame.getOperandStack().popLong();
            long result = value1 + value2;
            frame.getOperandStack().pushLong(result);
        }
    }

    public class FADD extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            float value1 = frame.getOperandStack().popFloat();
            float value2 = frame.getOperandStack().popFloat();
            float result = value1 + value2;
            frame.getOperandStack().pushFloat(result);
        }
    }

    public class IADD extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            int value1 = frame.getOperandStack().popInt();
            int value2 = frame.getOperandStack().popInt();
            int result = value1 + value2;
            frame.getOperandStack().pushInt(result);
        }
    }

}
