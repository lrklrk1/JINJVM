package instructions.constants;

import instructions.base.NoOperandInstruction;
import rtda.Frame;

public class Nop {

    public class NOP extends NoOperandInstruction {

        @Override
        public void execute(Frame frame) {
//            do nothing
        }
    }
}
