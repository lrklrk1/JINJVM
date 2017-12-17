package instructions.stores;

import instructions.base.Index8Instruction;
import instructions.base.NoOperandInstruction;
import rtda.Frame;

public class Dstore {

    private void dStore(Frame frame, int index) {
        double value = frame.getOperandStack().popDouble();
        frame.getLocalVars().setDouble(index, value);
    }

    public class DSTORE extends Index8Instruction {
        @Override
        public void execute(Frame frame) {
            dStore(frame, getIndex());
        }
    }

    public class DSTORE_0 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            dStore(frame, 0);
        }
    }

    public class DSTORE_1 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            dStore(frame, 1);
        }
    }

    public class DSTORE_2 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            dStore(frame, 2);
        }
    }

    public class DSTORE_3 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            dStore(frame, 3);
        }
    }



}
