package instructions.control;

import instructions.base.NoOperandInstruction;
import rtda.Frame;
import rtda.Thread;
import rtda.heap.object;

public class Return {

    public class RETURN extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            frame.getThread().popFrame();
        }
    }

    public  class ARETURN extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            Thread thread = frame.getThread();
            Frame currentFrame = thread.popFrame();
            Frame invokerFrame = thread.topFrame();
            object retVal = currentFrame.getOperandStack().popRef();
            invokerFrame.getOperandStack().pushRef(retVal);
        }
    }

    public class IRETURN extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            Thread thread = frame.getThread();
            Frame currentFrame = thread.popFrame();
            Frame invokerFrame = thread.topFrame();
            int retVal = currentFrame.getOperandStack().popInt();
            invokerFrame.getOperandStack().pushInt(retVal);
        }
    }

    public class LRETURN extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            Thread thread = frame.getThread();
            Frame currentFrame = thread.popFrame();
            Frame invokerFrame = thread.topFrame();
            long retVal = currentFrame.getOperandStack().popLong();
            invokerFrame.getOperandStack().pushLong(retVal);
        }
    }

    public class FRETURN extends NoOperandInstruction {
        @Override
        public void execute(Frame frame) {
            Thread thread = frame.getThread();
            Frame currentFrame = thread.popFrame();
            Frame invokerFrame = thread.topFrame();
            float retVal = currentFrame.getOperandStack().popFloat();
            invokerFrame.getOperandStack().pushFloat(retVal);
        }
    }

    public class DRETURN extends NoOperandInstruction{
        @Override
        public void execute(Frame frame) {
            Thread thread = frame.getThread();
            Frame currentFrame = thread.popFrame();
            Frame invokerFrame = thread.topFrame();
            double retVal = currentFrame.getOperandStack().popDouble();
            invokerFrame.getOperandStack().pushDouble(retVal);
        }
    }

}
