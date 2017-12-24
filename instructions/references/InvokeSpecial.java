package instructions.references;

import instructions.base.Index16Instruction;
import rtda.Frame;

public class InvokeSpecial {

    public class INVOKESPECIAL extends Index16Instruction {
        @Override
        public void execute(Frame frame) {
            frame.getOperandStack().popRef();
        }
    }

}
