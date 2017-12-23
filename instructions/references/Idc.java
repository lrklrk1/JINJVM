package instructions.references;

import instructions.base.Index16Instruction;
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
        } else if (constant instanceof CpFloat) {
            CpFloat temp = (CpFloat)constant;
            stack.pushFloat(temp.getValue());
        }
//        TODO
//        TODO
    }

    public class LDC extends Index16Instruction {
        @Override
        public void execute(Frame frame) {
            ldc(frame, getIndex());
        }
    }

    public class LDCW extends Index16Instruction {
        @Override
        public void execute(Frame frame) {
            ldc(frame, getIndex());
        }
    }

    public class LDC2W extends Index16Instruction {
        @Override
        public void execute(Frame frame) {
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
