package instructions.base;

import rtda.Frame;
import rtda.Slot;
import rtda.Thread;
import rtda.heap.Method;

public class MethodInvokeLogic {

    public static void invokeMethod(Frame invokeFrame, Method method) {
        Thread thread = invokeFrame.getThread();
        Frame newFrame = thread.newFrame(method);
        thread.pushFrame(newFrame);

        int argsSlotCount = method.getArgsSlotCount() - 1;
        if (argsSlotCount > 0) {
            for (int i = argsSlotCount - 1; i >= 0; i--) {
                Slot slot = invokeFrame.getOperandStack().popSlot();
                newFrame.getLocalVars().setSlot(i, slot);
            }
        }
    }

}
