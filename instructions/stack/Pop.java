package instructions.stack;

import instructions.base.NoOperandInstruction;
import rtda.Frame;

public class Pop {

    public class POP extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            frame.getOperandStack().popSlot();
        }
    }

    public class POP2 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            frame.getOperandStack().popSlot();
            frame.getOperandStack().popSlot();
        }
    }

}
