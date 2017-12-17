package instructions.loads;

import instructions.base.Index8Instruction;
import instructions.base.NoOperandInstruction;
import rtda.Frame;

public class Lload {

    private void lLoad(Frame frame, int index) {
        long value = frame.getLocalVars().getLong(index);
        frame.getOperandStack().pushLong(value);
    }

    public class LLOAD extends Index8Instruction {
        @Override
        public void execute(Frame frame) {
            lLoad(frame, getIndex());
        }
    }

    public class LLOAD_0 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            lLoad(frame, 0);
        }
    }

    public class LLOAD_1 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            lLoad(frame, 1);
        }
    }

    public class LLOAD_2 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            lLoad(frame, 2);
        }
    }

    public class LLOAD_3 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            lLoad(frame, 3);
        }
    }

}
