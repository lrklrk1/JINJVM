package instructions.base;

import rtda.Frame;

public class BranchLogic {

    public static void branch(Frame frame, int offset) {
        int pc = frame.getThread().getPC();
        int nextPC = pc + offset;
        frame.setNextPC(nextPC);
    }

}
