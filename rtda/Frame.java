package rtda;

import rtda.heap.Method;

public class Frame {

    int nextPC;
    Frame lower;
    LocalVars localVars;
    OperandStack operandStack;
    Thread thread;
    Method method;

    public Thread getThread() {
        return thread;
    }

    public int getNextPC() {
        return nextPC;
    }

    public Method getMethod() {
        return method;
    }


    public Frame(Thread thread, Method method) {
        this.thread = thread;
        this.method = method;
        this.localVars = new LocalVars(method.getMaxLocals());
        this.operandStack = new OperandStack(method.getMaxStack());
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