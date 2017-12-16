package instructions.loads;

import instructions.base.Index8Instruction;
import instructions.base.NoOperandInstruction;
import rtda.Frame;

public class Iload {

    private void iLoad(Frame frame, int index) {
        int value = frame.getLocalVars().getInt(index);
        frame.getOperandStack().pushInt(value);
    }

    public class ILOAD extends Index8Instruction {
        @Override
        public void execute(Frame frame) {
            iLoad(frame, getIndex());
        }
    }

    public class ILOAD_0 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            iLoad(frame, 0);
        }
    }

    public class ILOAD_1 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            iLoad(frame, 1);
        }
    }

    public class ILOAD_2 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            iLoad(frame, 2);
        }
    }

    public class ILOAD_3 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            iLoad(frame, 3);
        }
    }






}
