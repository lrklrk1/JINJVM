package instructions.constants;

import instructions.base.BytecodeReader;
import instructions.base.Instruction;
import rtda.Frame;

public class Ipush {

    public class BIPUSH implements Instruction {

        byte value;

        @Override
        public void fetchOperands(BytecodeReader reader) {
            this.value = reader.parse1();
        }

        @Override
        public void execute(Frame frame) {
            frame.getOperandStack().pushInt(value);
        }
    }

    public class SIPUSH implements Instruction {
        @Override
        public void fetchOperands(BytecodeReader reader) {

        }

        @Override
        public void execute(Frame frame) {

        }
    }

}
