package instructions.comparisons;

import instructions.base.BranchInstruction;
import instructions.base.BranchLogic;
import rtda.Frame;

public class Ifcond {

    public class IFEQ extends BranchInstruction {
        @Override
        public void execute(Frame frame) {
            int value = frame.getOperandStack().popInt();
            if (value == 0) {
                BranchLogic.branch(frame, getOffset());
            }
        }
    }

    public class IFNE extends BranchInstruction {
        @Override
        public void execute(Frame frame) {
            int value = frame.getOperandStack().popInt();
            if (value != 0) {
                BranchLogic.branch(frame, getOffset());
            }
        }
    }

    public class IFLT extends BranchInstruction {
        @Override
        public void execute(Frame frame) {
            int value = frame.getOperandStack().popInt();
            if (value < 0) {
                BranchLogic.branch(frame, getOffset());
            }
        }
    }

    public class IFLE extends BranchInstruction {
        @Override
        public void execute(Frame frame) {
            int value = frame.getOperandStack().popInt();
            if (value <= 0) {
                BranchLogic.branch(frame, getOffset());
            }
        }
    }

    public class IFGT extends BranchInstruction {
        @Override
        public void execute(Frame frame) {
            int value = frame.getOperandStack().popInt();
            if (value > 0) {
                BranchLogic.branch(frame, getOffset());
            }
        }
    }

    public class IFGE extends BranchInstruction {
        @Override
        public void execute(Frame frame) {
            int value = frame.getOperandStack().popInt();
            if (value >= 0) {
                BranchLogic.branch(frame, getOffset());
            }
        }
    }

}
