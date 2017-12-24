package instructions.references;

import instructions.base.Index16Instruction;
import rtda.Frame;
import rtda.OperandStack;
import rtda.heap.ConstantPool;
import rtda.heap.CpMethodRef;
import rtda.heap.Method;

public class InvokeVirtual {

    public class INVOKEVIRTUAL extends Index16Instruction {
        @Override
        public void execute(Frame frame) {
            ConstantPool cp = frame.getMethod().getClassMember().getThisclass().getConstantPool();
            CpMethodRef methodRef = (CpMethodRef) cp.getConstant(getIndex());
            if (methodRef.getName().equals("println")) {
                OperandStack stack = frame.getOperandStack();
                switch (methodRef.getDescriptor()) {
                    case "(Z)V":
                        System.out.println(stack.popInt() != 0);
                        break;
                    case "(C)V":
                        System.out.println(stack.popInt());
                        break;
                    case "(B)V":
                        System.out.println(stack.popInt());
                        break;
                    case "(S)V":
                        System.out.println(stack.popInt());
                        break;
                    case "(I)V":
                        System.out.println(stack.popInt());
                        break;
                    case "(J)":
                        System.out.println(stack.popLong());
                        break;
                    case "(F)V":
                        System.out.println(stack.popFloat());
                        break;
                    case "(D)V":
                        System.out.println(stack.popDouble());
                    default:
                        System.out.println("println: " + methodRef.getMethod().getClassMember().getDescriptor());
                }
                stack.popRef();
            }
        }
    }

}
