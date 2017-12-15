package instructions.stack;

import instructions.base.NoOperandInstruction;
import rtda.Frame;
import rtda.Slot;

public class Dup {

    public class DUP extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            Slot temp = frame.getOperandStack().popSlot();
            frame.getOperandStack().pushSlot(temp);
            frame.getOperandStack().pushSlot(temp);
        }
    }

    public class BUP_X1 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {

        }
    }

    public class BUP_X2 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {

        }
    }

    public class DUP2 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {

        }
    }

    public class DUP_X1 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {

        }
    }

    public class DUP_X2 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {

        }
    }

}
