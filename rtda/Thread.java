package rtda;

public class Thread {

    int pc;
    Stack stack;

    public Thread() {
        this.stack = new Stack(124);
    }

    int getPC() {
        return this.pc;
    }

    void setPC(int pc) {
        this.pc = pc;
    }

    void PushFrame(Frame frame) {
        this.stack.push(frame);
    }

    Frame PopFrame() {
        return this.stack.pop();
    }

    Frame CurrentFrame() {
        return this.stack.top();
    }

}
