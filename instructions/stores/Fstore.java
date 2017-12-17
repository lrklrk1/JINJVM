package instructions.stores;

import instructions.base.Index8Instruction;
import instructions.base.NoOperandInstruction;
import rtda.Frame;

public class Fstore {

    private void fStore(Frame frame, int index) {
        float value = frame.getOperandStack().popFloat();
        frame.getLocalVars().setFloat(index, value);
    }

    public class FSTORE extends Index8Instruction {
        @Override
        public void execute(Frame frame) {
            fStore(frame, getIndex());
        }
    }

    public class FSTORE_0 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            fStore(frame, 0);
        }
    }

    public class FSTORE_1 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            fStore(frame, 1);
        }
    }

    public class FSTORE_2 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            fStore(frame, 2);
        }
    }

    public class FSTORE_3 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            fStore(frame, 3);
        }
    }


}
