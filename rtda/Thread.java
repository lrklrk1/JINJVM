package rtda;

import rtda.heap.Method;

public class Thread {

    int pc;
    Stack stack;

    public Thread() {
        stack = new Stack(1024);
    }

    public Frame newFrame(Method method) {
        return new Frame(this, method);
    }

    public int getPC() {
        return pc;
    }

    public void setPC(int pc) {
        this.pc = pc;
    }

    public void pushFrame(Frame frame) {
        stack.push(frame);
    }

    public Frame popFrame() {
        return stack.pop();
    }

    public Frame currentFrame() {
        return stack.top();
    }

    public Frame topFrame() {
        return stack.top;
    }

    public boolean isStackEmpty() {
        return null == stack.top;
    }

}
