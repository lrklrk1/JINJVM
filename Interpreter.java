import classfile.CodeAttribute;
import classfile.MemberInfo;
import instructions.Factory;
import instructions.base.BytecodeReader;
import instructions.base.Instruction;
import rtda.Frame;
import rtda.LocalVars;
import rtda.Slot;
import rtda.Thread;
import rtda.heap.Method;

public class Interpreter {

    public static void interpreter(Method method) {
        byte[] bytecode = method.getCode();

        Thread thread = new Thread();
        Frame frame = thread.newFrame(method);
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

            System.out.println("pc :" + pc + " opcode: " + opcode);
//            Slot[] slots = frame.getOperandStack().getSlots();
//            for (Slot s : slots) {
//                if (s != null) {
//                    System.out.println(s.getNum() + " " + s.getRef());
//                }
//            }
            inst.execute(frame);


        }
    }

}
