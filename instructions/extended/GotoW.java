package instructions.extended;

import instructions.base.BranchInstruction;
import instructions.base.BranchLogic;
import instructions.base.BytecodeReader;
import instructions.base.Instruction;
import rtda.Frame;

public class GotoW {

    public class GOTOW extends BranchInstruction {

        @Override
        public void execute(Frame frame) {
            BranchLogic.branch(frame, getOffset());
        }
    }

}
