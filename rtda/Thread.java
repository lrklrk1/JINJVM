package rtda;

public class Thread {

    int pc;
    Stack stack;

    public Thread() {
        stack = new Stack(124);
    }

    int getPC() {
        return pc;
    }

    void setPC(int pc) {
        pc = pc;
    }

    void PushFrame(Frame frame) {
        stack.push(frame);
    }

    Frame PopFrame() {
        return stack.pop();
    }

    Frame CurrentFrame() {
        return stack.top();
    }

}
