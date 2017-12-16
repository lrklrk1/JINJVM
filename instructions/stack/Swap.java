package instructions.stack;

import instructions.base.NoOperandInstruction;
import rtda.Frame;
import rtda.Slot;

public class Swap {

    public class SWAP extends NoOperandInstruction{

        @Override
        public void execute(Frame frame) {
            Slot slot1 = frame.getOperandStack().popSlot();
            Slot slot2 = frame.getOperandStack().popSlot();
            frame.getOperandStack().pushSlot(slot1);
            frame.getOperandStack().pushSlot(slot2);
        }
    }

}
