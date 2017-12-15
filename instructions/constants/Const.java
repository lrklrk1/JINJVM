package instructions.constants;

import instructions.base.NoOperandInstruction;
import rtda.Frame;

public class Const {

    public class ACONST_NULL extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            frame.getOperandStack().pushRef(null);
        }
    }

    public class DCONST_0 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            frame.getOperandStack().pushDouble(0.0);
        }
    }

    public class DCONST_1 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            frame.getOperandStack().pushDouble(1.0);
        }
    }

    public class FCONST_0 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            frame.getOperandStack().pushFloat(0F);
        }
    }

    public class FCONST_1 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            frame.getOperandStack().pushFloat(1F);
        }
    }

    public class FCONST_2 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            frame.getOperandStack().pushFloat(2F);
        }
    }

    public class ICONST_M1 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            frame.getOperandStack().pushInt(-1);
        }
    }

    public class ICONST_0 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            frame.getOperandStack().pushInt(0);
        }
    }

    public class ICONST_1 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            frame.getOperandStack().pushInt(1);
        }
    }

    public class ICONST_2 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            frame.getOperandStack().pushInt(2);
        }
    }

    public class ICONST_3 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            frame.getOperandStack().pushInt(3);
        }
    }

    public class ICONST_4 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            frame.getOperandStack().pushInt(4);
        }
    }

    public class ICONST_5 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            frame.getOperandStack().pushInt(5);
        }
    }

    public class LCONST_0 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            frame.getOperandStack().pushLong(0L);
        }
    }

    public class LCONST_1 extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            frame.getOperandStack().pushLong(1L);
        }
    }
}
