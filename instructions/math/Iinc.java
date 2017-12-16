package instructions.math;

import instructions.base.BytecodeReader;
import instructions.base.Instruction;
import rtda.Frame;

public class Iinc {

    public class IINC implements Instruction {

        int index;
        int cons;

        @Override
        public void fetchOperands(BytecodeReader reader) {
            this.index = reader.parse1U();
            this.cons = reader.parse1();
        }

        @Override
        public void execute(Frame frame) {
            int value = frame.getLocalVars().getInt(index);
            value += cons;
            frame.getLocalVars().setInt(index, value);
        }
    }

}
