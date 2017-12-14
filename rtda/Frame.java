package rtda;

public class Frame {

    Frame lower;
    LocalVars localVars;
    OperandStack operandStack;

    public Frame(int maxLocals, int maxStack) {
        this.localVars = new LocalVars(maxLocals);
        this.operandStack = new OperandStack(maxStack);
    }

    public LocalVars getLocalVars() {
        return this.localVars;
    }

    public OperandStack getOperandStack() {
        return this.operandStack;
    }

}
