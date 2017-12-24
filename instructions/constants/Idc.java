package instructions.constants;

import instructions.base.Index8Instruction;
import rtda.Frame;
import rtda.OperandStack;
import rtda.heap.*;

public class Idc {


    private void ldc(Frame frame, int index) {
        OperandStack stack = frame.getOperandStack();
        ConstantPool cp = frame.getMethod().getClassMember().getThisclass().getConstantPool();
        Constant constant = cp.getConstant(index);

        if (constant instanceof CpInteger) {
            CpInteger temp = (CpInteger)constant;
            stack.pushInt(temp.getValue());
            System.out.println(temp.getValue());
        } else if (constant instanceof CpFloat) {
            CpFloat temp = (CpFloat)constant;
            stack.pushFloat(temp.getValue());
            System.out.println(temp.getValue());
        }
//        TODO
//        TODO
    }

    public class LDC extends Index8Instruction {
        @Override
        public void execute(Frame frame) {
            System.out.println("ldc: " + getIndex());
            ldc(frame, getIndex());
        }
    }

    public class LDCW extends Index8Instruction {
        @Override
        public void execute(Frame frame) {
            System.out.println("ldc: " + getIndex());
            ldc(frame, getIndex());
        }
    }

    public class LDC2W extends Index8Instruction {
        @Override
        public void execute(Frame frame) {
            System.out.println("ldc: " + getIndex());
            OperandStack stack = frame.getOperandStack();
            ConstantPool cp = frame.getMethod().getClassMember().getThisclass().getConstantPool();
            Constant c = cp.getConstant(getIndex());

            if (c instanceof CpLong) {
                CpLong temp = (CpLong)c;
                stack.pushLong(temp.getValue());
            } else if (c instanceof CpDouble) {
                CpDouble temp = (CpDouble)c;
                stack.pushDouble(temp.getValue());
            }
//            TODO
//            TODO
        }
    }

}
