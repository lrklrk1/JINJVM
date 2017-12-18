package instructions.loads;

import instructions.base.Index8Instruction;
import instructions.base.NoOperandInstruction;
import rtda.Frame;

public class Fload {

    private void fLoad(Frame frame, int index) {
        float value = frame.getLocalVars().getFloat(index);
        frame.getOperandStack().pushFloat(value);
    }

    public class FLOAD extends Index8Instruction {
        @Override
        public void execute(Frame frame) {
            fLoad(frame, getIndex());
        }
    }

    public class FLOAD_0 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            fLoad(frame, 0);
        }
    }

    public class FLOAD_1 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            fLoad(frame, 1);
        }
    }

    public class FLOAD_2 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            fLoad(frame, 2);
        }
    }

    public class FLOAD_3 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            fLoad(frame, 3);
        }
    }


}
