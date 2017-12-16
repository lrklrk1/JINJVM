package instructions.math;

import instructions.base.NoOperandInstruction;
import rtda.Frame;

public class Sh {

    public class ISHL extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            int value2 = frame.getOperandStack().popInt();
            int value1 = frame.getOperandStack().popInt();
            int s = value2 & 0x1f;
            int result = value1 << s;
            frame.getOperandStack().pushInt(result);
        }
    }

    public class ISHR extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            int value2 = frame.getOperandStack().popInt();
            int value1 = frame.getOperandStack().popInt();
            int s = value2 & 0x1f;
            int result = value1 >> s;
            frame.getOperandStack().pushInt(result);
        }
    }

    public class IUSHR extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            int value2 = frame.getOperandStack().popInt();
            int value1 = frame.getOperandStack().popInt();
            int s = value2 & 0x1f;
            int result = value1 >>> s;
            frame.getOperandStack().pushInt(result);
        }
    }

    public class LSHL extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            int value2 = frame.getOperandStack().popInt();
            long value1 = frame.getOperandStack().popLong();
            int s = value2 & 0x1f;
            long result = value1 << s;
            frame.getOperandStack().pushLong(result);
        }
    }

    public class LSHR extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            int value2 = frame.getOperandStack().popInt();
            long value1 = frame.getOperandStack().popLong();
            int s = value2 & 0x1f;
            long result = value1 >> s;
            frame.getOperandStack().pushLong(result);
        }
    }

    public class LUSHR extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            int value2 = frame.getOperandStack().popInt();
            long value1 = frame.getOperandStack().popLong();
            int s = value2 & 0x1f;
            long result = value1 >>> s;
            frame.getOperandStack().pushLong(result);
        }
    }


}
