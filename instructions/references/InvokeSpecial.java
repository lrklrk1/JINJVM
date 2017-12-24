package instructions.references;

import instructions.base.Index16Instruction;
import rtda.Frame;
import rtda.heap.*;
import rtda.heap.Class;

import static instructions.base.MethodInvokeLogic.invokeMethod;
import static rtda.heap.MethodLookup.lookupMethodInClass;

public class InvokeSpecial {

    public class INVOKESPECIAL extends Index16Instruction {
        @Override
        public void execute(Frame frame) {
            Class currentClass = frame.getMethod().getClassMember().getThisclass();
            ConstantPool cp = currentClass.getConstantPool();
            CpMethodRef methodRef = (CpMethodRef) cp.getConstant(getIndex());
            Class resolvedClass = methodRef.resolvedClass();
            Method resolvedMethod = methodRef.resolveMethod();

            if (resolvedMethod.getClassMember().getName().equals("<init>") &&
                    resolvedMethod.getClassMember().getThisclass() != resolvedClass) {
                System.out.println("java.lang.NoSuchMethodError");
            }

            if (resolvedMethod.getClassMember().isStatic()) {
                System.out.println("java.lang.IncompatibleClassChangeError");
            }

            object ref = frame.getOperandStack().getRefFromTop(resolvedMethod.getArgsSlotCount());
            if (null == ref) {
                System.out.println("java.lang.NullPointerException");
            }

            if (resolvedMethod.getClassMember().isProtected() &&
                    resolvedMethod.getClassMember().getThisclass().isSuperClassOf(currentClass) &&
                    !resolvedMethod.getClassMember().getThisclass()
                            .getPackageName().equals(currentClass.getPackageName()) &&
                    ref.getThisClas() != currentClass &&
                    !ref.getThisClas().isSubInterfaceOf(currentClass)) {
                System.out.println("java.lang.IllegalAccessError");
            }

            Method methodToBeInvoked = resolvedMethod;
            if (currentClass.isSuper() &&
                    resolvedClass.isSuperClassOf(currentClass) &&
                    !resolvedMethod.getClassMember().getName().equals("<init>")) {
                methodToBeInvoked = lookupMethodInClass(currentClass.getSuperClass(),
                                                        methodRef.getName(),
                                                        methodRef.getDescriptor());
            }

            if (null == methodToBeInvoked || methodToBeInvoked.isAbstract()) {
                System.out.println("java.lang.AbstractMethodError");
            }
            invokeMethod(frame, methodToBeInvoked);
        }
    }

}
