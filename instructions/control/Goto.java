package instructions.control;

import instructions.base.BranchInstruction;
import instructions.base.BranchLogic;
import rtda.Frame;

public class Goto {

    public class GOTO extends BranchInstruction {
        @Override
        public void execute(Frame frame) {
            BranchLogic.branch(frame, getOffset());
        }
    }
}
