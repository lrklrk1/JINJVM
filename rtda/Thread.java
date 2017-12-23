package rtda;

import rtda.heap.Method;

public class Thread {

    int pc;
    Stack stack;

    public Thread() {
        stack = new Stack(124);
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

}
