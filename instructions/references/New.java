package instructions.references;

import instructions.base.Index16Instruction;
import rtda.Frame;
import rtda.heap.Class;
import rtda.heap.ConstantPool;
import rtda.heap.CpClassRef;
import rtda.heap.object;


public class New {

    public class NEW extends Index16Instruction {
        @Override
        public void execute(Frame frame) {
            ConstantPool cp = frame.getMethod().getClassMember().getThisclass().getConstantPool();
            CpClassRef crf = (CpClassRef) cp.getConstant(getIndex());
            Class thisClass = crf.resolvedClass();

            if (thisClass.isInterface() || thisClass.isAbstract()) {
                System.out.println("java.lang.InstantiationError");
                System.exit(0);
            }

            object ref = thisClass.newObject();
            frame.getOperandStack().pushRef(ref);
        }
    }
}
