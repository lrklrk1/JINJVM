package instructions.stores;

import instructions.base.Index8Instruction;
import instructions.base.NoOperandInstruction;
import rtda.Frame;

public class Istore {

    private void iStore(Frame frame, int index) {
        int value = frame.getOperandStack().popInt();
        frame.getLocalVars().setInt(index, value);
    }

    public class ISTORE extends Index8Instruction {
        @Override
        public void execute(Frame frame) {
            iStore(frame, getIndex());
        }
    }

    public class ISTORE_0 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            iStore(frame, 0);
        }
    }

    public class ISTORE_1 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            iStore(frame, 1);
        }
    }

    public class ISTORE_2 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            iStore(frame, 2);
        }
    }

    public class ISTORE_3 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            iStore(frame, 3);
        }
    }

}
