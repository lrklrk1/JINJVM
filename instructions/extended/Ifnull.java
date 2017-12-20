package instructions.extended;

import instructions.base.BranchInstruction;
import instructions.base.BranchLogic;
import rtda.Frame;
import rtda.heap.object;

public class Ifnull {

    public class IFNULL extends BranchInstruction {
        @Override
        public void execute(Frame frame) {
            object ref = frame.getOperandStack().popRef();
            if (ref == null) {
                BranchLogic.branch(frame, getOffset());
            }
        }
    }

    public class IFNONNULL extends BranchInstruction {
        @Override
        public void execute(Frame frame) {
            object ref = frame.getOperandStack().popRef();
            if (ref != null) {
                BranchLogic.branch(frame, getOffset());
            }
        }
    }

}
