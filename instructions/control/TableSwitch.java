package instructions.control;

import instructions.base.BranchLogic;
import instructions.base.BytecodeReader;
import instructions.base.Instruction;
import rtda.Frame;

public class TableSwitch {

    public class TABLESWITCH implements Instruction {

        int defaultOffset;
        int low;
        int high;
        int[] jumpOffsets;

        @Override
        public void fetchOperands(BytecodeReader reader) {
            reader.skipPadding();
            defaultOffset = reader.parse4();
            low = reader.parse4();
            high = reader.parse4();
            int jumpOffsetCounts = high - low + 1;
            jumpOffsets = reader.parse4s(jumpOffsetCounts);
        }

        @Override
        public void execute(Frame frame) {
            int index = frame.getOperandStack().popInt();
            int offset;
            if (index >= low && index <= high) {
                offset = jumpOffsets[index - low];
            } else {
                offset = defaultOffset;
            }
            BranchLogic.branch(frame, offset);
        }
    }

}
