package instructions.comparisons;

import instructions.base.BranchInstruction;
import instructions.base.BranchLogic;
import rtda.Frame;
import rtda.object;

public class IfAcmp {

    public class IFACMPEQ extends BranchInstruction {
        @Override
        public void execute(Frame frame) {
            object ref2 = frame.getOperandStack().popRef();
            object ref1 = frame.getOperandStack().popRef();
            if (ref1 == ref2) {
                BranchLogic.branch(frame, getOffset());
            }
        }
    }

    public class IFACMPNE extends BranchInstruction {
        @Override
        public void execute(Frame frame) {
            object ref2 = frame.getOperandStack().popRef();
            object ref1 = frame.getOperandStack().popRef();
            if (ref1 != ref2) {
                BranchLogic.branch(frame, getOffset());
            }
        }
    }

}
