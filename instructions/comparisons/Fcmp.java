package instructions.comparisons;

import instructions.base.NoOperandInstruction;
import rtda.Frame;

public class Fcmp {

    private void fcmp(Frame frame, boolean gFlag) {
        float value2 = frame.getOperandStack().popFloat();
        float value1 = frame.getOperandStack().popFloat();
        boolean isNaN = Float.isNaN(value1) || Float.isNaN(value2);
        if (isNaN && gFlag) {
            frame.getOperandStack().pushInt(1);
        } else if (isNaN && gFlag) {
            frame.getOperandStack().pushInt(-1);
        } else {
            frame.getOperandStack().pushInt(Float.compare(value1, value2));
        }
    }

    public class FCMPG extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            fcmp(frame, true);
        }
    }

    public class FCMPL extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            fcmp(frame, false);
        }
    }
}
