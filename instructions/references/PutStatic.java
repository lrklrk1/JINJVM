package instructions.references;

import instructions.base.Index16Instruction;
import rtda.Frame;
import rtda.LocalVars;
import rtda.OperandStack;
import rtda.heap.*;
import rtda.heap.Class;

public class PutStatic {

    public class PUTSTATIC extends Index16Instruction{
        @Override
        public void execute(Frame frame) {
            Method currentMethod = frame.getMethod();
            Class currentClass = currentMethod.getClassMember().getThisclass();
            ConstantPool cp = currentClass.getConstantPool();
            CpFieldRef fieldRef = (CpFieldRef) cp.getConstant(getIndex());
            Field field = fieldRef.resolvedField();
            Class thisClass = field.getClassMember().getThisclass();

            if (!field.getClassMember().isStatic()) {
                System.out.println("java.lang.IncompatibleClassChangeError");
                System.exit(0);
            }
            if (field.getClassMember().isFinal()) {
                if (currentClass != thisClass || currentMethod.getClassMember().getName() != "<clinit>") {
                    System.out.println("java.lang.IllegalAccessError");
                }
            }

            String descriptor = field.getClassMember().getDescriptor();
            int slotId = field.getSlotId();
            LocalVars slots = thisClass.getStaticVars();
            OperandStack stack = frame.getOperandStack();

            switch (descriptor.charAt(0)) {
                case 'Z':
                case 'B':
                case 'C':
                case 'S':
                case 'I':
                    slots.setInt(slotId, stack.popInt());
                    break;
                case 'F':
                    slots.setFloat(slotId, stack.popFloat());
                    break;
                case 'J':
                    slots.setLong(slotId, stack.popLong());
                    break;
                case 'D':
                    slots.setDouble(slotId, stack.popDouble());
                    break;
                case 'L':
                case '[':
                    slots.setRef(slotId, stack.popRef());
                    break;
            }
        }

    }

    public class GETSTATIC extends Index16Instruction {
        @Override
        public void execute(Frame frame) {
            ConstantPool cp = frame.getMethod().getClassMember().getThisclass().getConstantPool();
            CpFieldRef fieldRef = (CpFieldRef) cp.getConstant(getIndex());
            Field field = fieldRef.resolvedField();
            Class thisClass = field.getClassMember().getThisclass();

            if (!field.getClassMember().isStatic()) {
                System.out.println("java.lang.IncompatibleClassChangeError");
            }

            String descriptor = field.getClassMember().getDescriptor();
            int slotId = field.getSlotId();
            LocalVars slots = thisClass.getStaticVars();
            OperandStack stack = frame.getOperandStack();

            switch (descriptor.charAt(0)) {
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
                    break;
            }
        }
    }

}
