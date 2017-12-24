package instructions.references;

import instructions.base.BytecodeReader;
import instructions.base.Instruction;
import rtda.Frame;
import rtda.heap.ConstantPool;
import rtda.heap.CpMethodRef;
import rtda.heap.Method;
import rtda.heap.object;

import static instructions.base.MethodInvokeLogic.invokeMethod;
import static rtda.heap.MethodLookup.lookupMethodInClass;

public class InvokeInterface {

    public class INVOKEINTERFACE implements Instruction {

        int index;

        @Override
        public void fetchOperands(BytecodeReader reader) {
            index = reader.parse2U();
            reader.parse1U();
            reader.parse1U();
        }

        @Override
        public void execute(Frame frame) {
            ConstantPool cp = frame.getMethod().getClassMember().getThisclass().getConstantPool();
            CpMethodRef methodRef = (CpMethodRef) cp.getConstant(index);
            Method resolvedMethod = methodRef.resolveMethod();
            if (resolvedMethod.getClassMember().isStatic() || resolvedMethod.getClassMember().isProtected()) {
                System.out.println("java.lang.IncompatibleClassChangeError");
                System.exit(0);
            }
            object ref = frame.getOperandStack().getRefFromTop(resolvedMethod.getArgsSlotCount() - 1);
            if (null == ref) {
                System.out.println("java.lang.NullPointerException");
                System.exit(0);
            }
            if (!ref.getThisClas().isImplements(methodRef.resolvedClass())) {
                System.out.println("java.lang.IncompatibleClassChangeError");
            }

            Method methodToBeInvoked = lookupMethodInClass(ref.getThisClas(),
                                                            methodRef.getName(),
                                                            methodRef.getDescriptor());
            if (null == methodToBeInvoked || methodToBeInvoked.isAbstract()) {
                System.out.println("java.lang.AbstractMethodError");
                System.exit(0);
            }
            if (!methodToBeInvoked.getClassMember().isPublic()) {
                System.out.println("java.lang.IllegalAccessError");
                System.exit(0);
            }
            invokeMethod(frame, methodToBeInvoked);
        }
    }

}
