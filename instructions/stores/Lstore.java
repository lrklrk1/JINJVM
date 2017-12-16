package instructions.stores;

import instructions.base.Index8Instruction;
import instructions.base.NoOperandInstruction;
import rtda.Frame;

public class Lstore {

    private void lStore(Frame frame, int index) {
        long value = frame.getOperandStack().popLong();
        frame.getLocalVars().setLong(index, value);
    }

    public class LSTORE extends Index8Instruction {
        @Override
        public void execute(Frame frame) {
            lStore(frame, getIndex());
        }
    }

    public class LSTORE_0 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            lStore(frame, 0);
        }
    }

    public class LSTORE_1 extends  NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            lStore(frame, 1);
        }
    }

    public class LSTORE_2 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            lStore(frame, 2);
        }
    }
}
