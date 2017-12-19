package rtda;

public class Thread {

    int pc;
    Stack stack;

    public Thread() {
        stack = new Stack(124);
    }

    public Frame newFrame(int maxLocals, int maxStack) {
        return new Frame(this, maxLocals, maxStack);
    }

    public int getPC() {
        return pc;
    }

    public void setPC(int pc) {
        pc = pc;
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
