package instructions.base;

import rtda.Frame;
import rtda.Thread;
import rtda.heap.Method;

public class MethodInvokeLogic {

    public void invokeMethod(Frame invokeFrame, Method method) {
        Thread thread = invokeFrame.getThread();
        Frame frame = thread.newFrame(method);
        thread.pushFrame(frame);

//        int argsSlotSlot = method.getArgSlotCount();
    }

}
