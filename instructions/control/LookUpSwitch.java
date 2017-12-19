package instructions.control;

import instructions.base.BranchLogic;
import instructions.base.BytecodeReader;
import instructions.base.Instruction;
import rtda.Frame;

public class LookUpSwitch {

    public class LOOKUPSWITCH implements Instruction{

        int defaultOffset;
        int nparis;
        byte[] matchOffsets;

        @Override
        public void fetchOperands(BytecodeReader reader) {
            reader.skipPadding();
            defaultOffset = reader.parse4();
            nparis = reader.parse4();
            matchOffsets = reader.parse4s(nparis * 2);
        }

        @Override
        public void execute(Frame frame) {
            int key = frame.getOperandStack().popInt();
            for (int i = 0; i < nparis * 2; i += 2) {
                if (matchOffsets[i] == key) {
                    int offset = matchOffsets[i + 1];
                    BranchLogic.branch(frame, offset);
                    return;
                }
            }
            BranchLogic.branch(frame, defaultOffset);
        }
    }

}
