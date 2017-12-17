package instructions.extended;

import instructions.base.BranchLogic;
import instructions.base.BytecodeReader;
import instructions.base.Instruction;
import rtda.Frame;

public class GotoW {

    public class GOTOW implements Instruction {

        int offset;

        @Override
        public void fetchOperands(BytecodeReader reader) {
            this.offset = reader.parse4();
        }

        @Override
        public void execute(Frame frame) {
            BranchLogic.branch(frame, offset);
        }
    }

}
