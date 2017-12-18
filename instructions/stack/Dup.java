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

    public class DUP_X1 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            Slot slot1 = frame.getOperandStack().popSlot();
            Slot slot2 = frame.getOperandStack().popSlot();
            frame.getOperandStack().pushSlot(slot1);
            frame.getOperandStack().pushSlot(slot2);
            frame.getOperandStack().pushSlot(slot1);
        }
    }

    public class DUP_X2 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            Slot slot1 = frame.getOperandStack().popSlot();
            Slot slot2 = frame.getOperandStack().popSlot();
            Slot slot3 = frame.getOperandStack().popSlot();
            frame.getOperandStack().pushSlot(slot1);
            frame.getOperandStack().pushSlot(slot3);
            frame.getOperandStack().pushSlot(slot2);
            frame.getOperandStack().pushSlot(slot1);
        }
    }

    public class DUP2 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            Slot slot1 = frame.getOperandStack().popSlot();
            Slot slot2 = frame.getOperandStack().popSlot();
            frame.getOperandStack().pushSlot(slot2);
            frame.getOperandStack().pushSlot(slot1);
            frame.getOperandStack().pushSlot(slot2);
            frame.getOperandStack().pushSlot(slot1);
        }
    }

    public class DUP2_X1 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            Slot slot1 = frame.getOperandStack().popSlot();
            Slot slot2 = frame.getOperandStack().popSlot();
            Slot slot3 = frame.getOperandStack().popSlot();
            frame.getOperandStack().pushSlot(slot2);
            frame.getOperandStack().pushSlot(slot1);
            frame.getOperandStack().pushSlot(slot3);
            frame.getOperandStack().pushSlot(slot2);
            frame.getOperandStack().pushSlot(slot1);
        }
    }

    public class DUP2_X2 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            Slot slot1 = frame.getOperandStack().popSlot();
            Slot slot2 = frame.getOperandStack().popSlot();
            Slot slot3 = frame.getOperandStack().popSlot();
            Slot slot4 = frame.getOperandStack().popSlot();
            frame.getOperandStack().pushSlot(slot2);
            frame.getOperandStack().pushSlot(slot1);
            frame.getOperandStack().pushSlot(slot4);
            frame.getOperandStack().pushSlot(slot3);
            frame.getOperandStack().pushSlot(slot2);
            frame.getOperandStack().pushSlot(slot1);
        }
    }

}
