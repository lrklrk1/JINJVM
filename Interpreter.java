import classfile.CodeAttribute;
import classfile.MemberInfo;
import instructions.Factory;
import instructions.base.BytecodeReader;
import instructions.base.Instruction;
import rtda.Frame;
import rtda.LocalVars;
import rtda.Slot;
import rtda.Thread;

public class Interpreter {

    public static void interpreter(MemberInfo methodInfo) {
        CodeAttribute codeAttr = methodInfo.getCodeArrtibute();
        int maxLocals = codeAttr.getMaxLocals();
        int maxStack = codeAttr.getMaxStack();
        byte[] bytecode = codeAttr.getCode();

        Thread thread = new Thread();
        Frame frame = thread.newFrame(maxLocals, maxStack);
        thread.pushFrame(frame);

        try {
            loop(thread, bytecode);
        } catch (Exception e) {
            System.out.println(frame.getLocalVars());
            System.out.println(frame.getOperandStack());
            e.printStackTrace();
        }
    }

    private static void loop(Thread thread, byte[] bytecode) {
        Frame frame = thread.popFrame();
        BytecodeReader reader = new BytecodeReader();
        while (true) {
            int pc = frame.getNextPC();
            thread.setPC(pc);

            //  decode
            reader.reSet(bytecode, pc);
            int opcode = reader.parse1U();
            Instruction inst = Factory.newInstruction(opcode);
            inst.fetchOperands(reader);
            frame.setNextPC(reader.getPc());

//            Slot[] s1 = frame.getLocalVars().getLocalVars();
//            for (Slot s : s1) {
//                System.out.print(s.getNum() + " ");
//            }
//            System.out.println();
//            s1 = frame.getOperandStack().getSlots();
//            for (Slot s : s1) {
//                System.out.print(s.getNum() + " ");
//            }

            inst.execute(frame);
        }
    }

}
