package instructions.loads;

import instructions.base.Index8Instruction;
import instructions.base.NoOperandInstruction;
import rtda.Frame;

public class Dload {

    private void dLoad(Frame frame, int index) {
        double value = frame.getLocalVars().getDouble(index);
        frame.getOperandStack().pushDouble(value);
    }

    public class DLOAD extends Index8Instruction {
        @Override
        public void execute(Frame frame) {
            dLoad(frame, getIndex());
        }
    }

    public class DLOAD_0 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            dLoad(frame, 0);
        }
    }

    public class DLOAD_1 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            dLoad(frame, 1);
        }
    }

    public class DLOAD_2 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            dLoad(frame, 2);
        }
    }

    public class DLOAD_3 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            dLoad(frame, 3);
        }
    }

}
