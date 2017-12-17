package instructions.comparisons;

import instructions.base.BranchInstruction;
import instructions.base.BranchLogic;
import rtda.Frame;

public class IfIcmp {

    public class IFICMPEQ extends BranchInstruction {
        @Override
        public void execute(Frame frame) {
            int value2 = frame.getOperandStack().popInt();
            int value1 = frame.getOperandStack().popInt();
            if (value1 == value2) {
                BranchLogic.branch(frame, getOffset());
            }
        }
    }

    public class IFICMPNE extends BranchInstruction {
        @Override
        public void execute(Frame frame) {
            int value2 = frame.getOperandStack().popInt();
            int value1 = frame.getOperandStack().popInt();
            if (value1 != value2) {
                BranchLogic.branch(frame, getOffset());
            }
        }
    }

    public class IFICMPLT extends BranchInstruction {
        @Override
        public void execute(Frame frame) {
            int value2 = frame.getOperandStack().popInt();
            int value1 = frame.getOperandStack().popInt();
            if (value1 < value2) {
                BranchLogic.branch(frame, getOffset());
            }
        }
    }

    public class IFICMPLE extends BranchInstruction {
        @Override
        public void execute(Frame frame) {
            int value2 = frame.getOperandStack().popInt();
            int value1 = frame.getOperandStack().popInt();
            if (value1 <= value2) {
                BranchLogic.branch(frame, getOffset());
            }
        }
    }

    public class IFICMPGT extends BranchInstruction {
        @Override
        public void execute(Frame frame) {
            int value2 = frame.getOperandStack().popInt();
            int value1 = frame.getOperandStack().popInt();
            if (value1 > value2) {
                BranchLogic.branch(frame, getOffset());
            }
        }
    }

    public class IFICMPGE extends BranchInstruction {
        @Override
        public void execute(Frame frame) {
            int value2 = frame.getOperandStack().popInt();
            int value1 = frame.getOperandStack().popInt();
            if (value1 >= value2) {
                BranchLogic.branch(frame, getOffset());
            }
        }
    }
}