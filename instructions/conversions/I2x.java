package instructions.conversions;

import instructions.base.NoOperandInstruction;
import rtda.Frame;

public class I2x {

    public class I2L extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            int value = frame.getOperandStack().popInt();
            frame.getOperandStack().pushLong((long)value);
        }
    }

    public class I2F extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            int value = frame.getOperandStack().popInt();
            frame.getOperandStack().pushFloat((float)value);
        }
    }

    public class I2D extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            int value = frame.getOperandStack().popInt();
            frame.getOperandStack().pushDouble((double)value);
        }
    }

    public class I2B extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            int value = frame.getOperandStack().popInt();
            byte b = (byte)value;
            frame.getOperandStack().pushInt(b);
        }
    }

    public class I2C extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            int value = frame.getOperandStack().popInt();
            char c = (char)value;
            frame.getOperandStack().pushInt(c);
        }
    }

    public class I2S extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            int value = frame.getOperandStack().popInt();
            short s = (short)value;
            frame.getOperandStack().pushInt(s);
        }
    }

}
