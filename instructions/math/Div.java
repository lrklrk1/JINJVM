package instructions.math;

import instructions.base.NoOperandInstruction;
import rtda.Frame;

public class Div {

    public class DDIV extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            double value2 = frame.getOperandStack().popDouble();
            double value1 = frame.getOperandStack().popDouble();
            double result = value1 / value2;
            frame.getOperandStack().pushDouble(result);
        }
    }

    public class FDIV extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            float value2 = frame.getOperandStack().popFloat();
            float value1 = frame.getOperandStack().popFloat();
            float result = value1 / value2;
            frame.getOperandStack().pushFloat(result);
        }
    }

    public class LDIV extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            long value2 = frame.getOperandStack().popLong();
            long value1 = frame.getOperandStack().popLong();
            if (value2 == 0) {
                System.out.println("java.lang.ArithmeticException: / by zero");
                System.exit(0);
            }
            long result = value1 / value2;
            frame.getOperandStack().pushLong(result);
        }
    }

    public class IDIV extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            int value2 = frame.getOperandStack().popInt();
            int value1 = frame.getOperandStack().popInt();
            if (value2 == 0) {
                System.out.println("java.lang.ArithmeticException: / by zero");
            }
            int result = value1 / value2;
            frame.getOperandStack().pushInt(result);
        }
    }

}
