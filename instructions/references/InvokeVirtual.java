package instructions.references;

import instructions.base.Index16Instruction;
import rtda.Frame;
import rtda.OperandStack;
import rtda.heap.*;
import rtda.heap.Class;

import static instructions.base.MethodInvokeLogic.invokeMethod;
import static rtda.heap.MethodLookup.lookupMethodInClass;

public class InvokeVirtual {

    public class INVOKEVIRTUAL extends Index16Instruction {
        @Override
        public void execute(Frame frame) {
            Class currentClass = frame.getMethod().getClassMember().getThisclass();
            ConstantPool cp = currentClass.getConstantPool();
            CpMethodRef methodRef = (CpMethodRef) cp.getConstant(getIndex());
            Method resolvedMethod = methodRef.resolveMethod();
            if (resolvedMethod.getClassMember().isStatic()) {
                System.out.println("java.lang.IncompatibleClassException");
                System.exit(0);
            }
            object ref = frame.getOperandStack().getRefFromTop(resolvedMethod.getArgsSlotCount() - 1);
            if (null == ref) {
                System.out.println("java.lang.NullPointerException");
//                System.exit(0);
            }
            if (methodRef.getName().equals("println")) {
                System.out.println("hack println");
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
                        break;
                    default:
                        System.out.println("println: " + methodRef.resolveMethod().getClassMember().getDescriptor());
                }
                stack.popRef();
            }
            Method methodToBeInvoked = lookupMethodInClass(ref.getThisClas(),
                                                            methodRef.getName(),
                                                            methodRef.getDescriptor());

            if (null == methodToBeInvoked || methodToBeInvoked.isAbstract()) {
                System.out.println("java.lang.AbstractMethodError");
            }
            invokeMethod(frame, methodToBeInvoked);
        }
    }

}
