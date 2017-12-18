package instructions.stores;

import instructions.base.Index8Instruction;
import instructions.base.NoOperandInstruction;
import rtda.Frame;
import rtda.object;

public class Astore {

    private void aStore(Frame frame, int index) {
        object ref = frame.getOperandStack().popRef();
        frame.getLocalVars().setRef(index, ref);
    }

    public class ASTORE extends Index8Instruction {
        @Override
        public void execute(Frame frame) {
            aStore(frame, getIndex());
        }
    }

    public class ASTORE_0 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            aStore(frame, 0);
        }
    }

    public class ASTORE_1 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            aStore(frame, 1);
        }
    }

    public class ASTORE_2 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            aStore(frame, 2);
        }
    }

    public class ASTORE_3 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            aStore(frame, 3);
        }
    }

}
