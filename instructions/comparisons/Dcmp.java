package instructions.comparisons;

import instructions.base.NoOperandInstruction;
import rtda.Frame;

public class Dcmp {

    private void dcmp(Frame frame, boolean gFlag) {
        double value1 = frame.getOperandStack().popFloat();
        double value2 = frame.getOperandStack().popFloat();
        boolean isNaN = Double.isNaN(value1) || Double.isNaN(value2);
        if (isNaN && gFlag) {
            frame.getOperandStack().pushInt(1);
        } else if (isNaN && !gFlag) {
            frame.getOperandStack().pushInt(-1);
        } else {
            frame.getOperandStack().pushInt(Double.compare(value1, value2));
        }
    }

    public class DCMPG extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            dcmp(frame, true);
        }
    }

    public class DCMPL extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            dcmp(frame, false);
        }
    }

}
