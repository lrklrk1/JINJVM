package instructions.references;

import instructions.base.Index16Instruction;
import rtda.Frame;
import rtda.OperandStack;
import rtda.heap.Class;
import rtda.heap.ConstantPool;
import rtda.heap.CpClassRef;
import rtda.heap.object;

public class InstanceOf {

    public class INSTANCEOF extends Index16Instruction {
        @Override
        public void execute(Frame frame) {
            OperandStack stack = frame.getOperandStack();
            object ref = stack.popRef();
            if (null == ref) {
                stack.pushInt(0);
                return;
            }

            ConstantPool cp = frame.getMethod().getClassMember().getThisclass().getConstantPool();
            CpClassRef cpClassRef = (CpClassRef) cp.getConstant(getIndex());
            Class thisClass = cpClassRef.resolvedClass();

            if (ref.isInstanceOf(thisClass)) {
                stack.pushInt(1);
            } else {
                stack.pushInt(0);
            }

        }
    }

}
