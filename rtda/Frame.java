package rtda;

public class Frame {

    Frame lower;
    LocalVars localVars;
    OperandStack operandStack;
    Thread thread;

    public Thread getThread() {
        return thread;
    }

    public int getNextPC() {
        return nextPC;
    }

    int nextPC;


    public Frame(Thread thread, int maxLocals, int maxStack) {
        this.thread = thread;
        this.localVars = new LocalVars(maxLocals);
        this.operandStack = new OperandStack(maxStack);
    }

    public LocalVars getLocalVars() {
        return localVars;
    }

    public OperandStack getOperandStack() {
        return operandStack;
    }

    public void setNextPC(int nextPC) {
        this.nextPC = nextPC;
    }
}