package instructions.control;

import instructions.base.NoOperandInstruction;
import rtda.Frame;

public class Return {

    public class RETURN extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            frame.getThread().popFrame();
        }
    }

}
