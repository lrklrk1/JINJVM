package instructions.references;

import instructions.base.Index16Instruction;
import instructions.base.MethodInvokeLogic;
import rtda.Frame;
import rtda.heap.ConstantPool;
import rtda.heap.CpMethodRef;
import rtda.heap.Method;

public class InvokeStatic {

    public class INVOKESTATIC extends Index16Instruction {
        @Override
        public void execute(Frame frame) {
            ConstantPool cp = frame.getMethod().getClassMember().getThisclass().getConstantPool();
            CpMethodRef methodRef = (CpMethodRef) cp.getConstant(getIndex());
            Method resolvedMethod = methodRef.resolveMethod();

            if (!resolvedMethod.getClassMember().isStatic()) {
                System.out.println("java.lang.IncompatibleClassChangeError");
            }
            MethodInvokeLogic.invokeMethod(frame, resolvedMethod);
        }
    }

}
