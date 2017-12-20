package instructions.loads;

import instructions.base.Index8Instruction;
import instructions.base.NoOperandInstruction;
import rtda.heap.object;
import rtda.Frame;


public class Aload {

    private void aLoad(Frame frame, int index) {
        object ref = frame.getLocalVars().getRef(index);
        frame.getOperandStack().pushRef(ref);
    }

    public class ALOAD extends Index8Instruction {
        @Override
        public void execute(Frame frame) {
            aLoad(frame, getIndex());
        }
    }

    public class ALOAD_0 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            aLoad(frame, 0);
        }
    }

    public class ALOAD_1 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            aLoad(frame, 1);
        }
    }

    public class ALOAD_2 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            aLoad(frame, 2);
        }
    }

    public class ALOAD_3 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            aLoad(frame, 3);
        }
    }

}
