package instructions.references;

import instructions.base.Index16Instruction;
import rtda.Frame;
import rtda.LocalVars;
import rtda.OperandStack;
import rtda.heap.*;
import rtda.heap.Class;

public class PutField {

    public class PUTFIELD extends Index16Instruction {
        @Override
        public void execute(Frame frame) {
            Method method = frame.getMethod();
            Class currentClass = method.getClassMember().getThisclass();
            ConstantPool cp = method.getClassMember().getThisclass().getConstantPool();
            CpFieldRef fieldRef = (CpFieldRef) cp.getConstant(getIndex());
            Field field = fieldRef.resolvedField();

            if (field.getClassMember().isStatic()) {
                System.out.println("java.lang.IncompatibleClassChangeError");
                System.exit(0);
            }
            if (field.getClassMember().isFinal()) {
                if (currentClass != field.getClassMember().getThisclass() ||
                        method.getClassMember().getName() != "<init>") {
                    System.out.println("java.lang.IllegaAccessError");
                    System.exit(0);
                }
            }

            String descriptor = field.getClassMember().getDescriptor();
            int slotId = field.getSlotId();
            OperandStack stack = frame.getOperandStack();

            switch (descriptor.indexOf(0)) {
                case 'Z':
                case 'B':
                case 'C':
                case 'S':
                case 'I':
                    int vi = stack.popInt();
                    object ri = stack.popRef();
                    if (null == ri) {
                        System.out.println("java.lang.NullPointerException");
                        System.exit(0);
                    }
                    ri.getFields().setInt(slotId, vi);
                    break;
                case 'F':
                    float vf = stack.popFloat();
                    object rf = stack.popRef();
                    if (null == rf) {
                        System.out.println("java.lang.NullPointerException");
                        System.exit(0);
                    }
                    rf.getFields().setFloat(slotId, vf);
                    break;
                case 'J':
                    long vj = stack.popLong();
                    object fj = stack.popRef();
                    if (null == fj) {
                        System.out.println("java.lang.NullPointerException");
                        System.exit(0);
                    }
                    fj.getFields().setLong(slotId, vj);
                    break;
                case 'D':
                    double vd = stack.popDouble();
                    object rd = stack.popRef();
                    if (null == rd) {
                        System.out.println("java.lang.NullPointerException");
                        System.exit(0);
                    }
                    rd.getFields().setDouble(slotId, vd);
                    break;
                case 'L':
                case ']':
                    object vl = stack.popRef();
                    object rl = stack.popRef();
                    if (null == rl) {
                        System.out.println("java.lang.NullPointerException");
                        System.exit(0);
                    }
                    rl.getFields().setRef(slotId, vl);
                    break;
            }

        }
    }

    public class GETFIELD extends Index16Instruction {
        @Override
        public void execute(Frame frame) {
            ConstantPool cp = frame.getMethod().getClassMember().getThisclass().getConstantPool();
            CpFieldRef fieldRef = (CpFieldRef) cp.getConstant(getIndex());
            Field field = fieldRef.resolvedField();

            if (field.getClassMember().isStatic()) {
                System.out.println("java.lang.IncompatibleClassChangeError");
                System.exit(0);
            }

            OperandStack stack = frame.getOperandStack();
            object ref = stack.popRef();
            if (null == ref) {
                System.out.println("java.lang.NullPointerException");
                System.exit(0);
            }

            String descriptor = field.getClassMember().getDescriptor();
            int slotId = field.getSlotId();
            LocalVars slots = ref.getFields();

            switch (descriptor.indexOf(0)) {
                case 'Z':
                case 'B':
                case 'C':
                case 'S':
                case 'I':
                    stack.pushInt(slots.getInt(slotId));
                    break;
                case 'F':
                    stack.pushFloat(slots.getFloat(slotId));
                    break;
                case 'J':
                    stack.pushLong(slots.getLong(slotId));
                    break;
                case 'D':
                    stack.pushDouble(slots.getDouble(slotId));
                    break;
                case 'L':
                case '[':
                    stack.pushRef(slots.getRef(slotId));
            }

        }
    }

}
