import instructions.Factory;
import instructions.base.BytecodeReader;
import instructions.base.Instruction;
import rtda.Frame;
import rtda.Thread;
import rtda.heap.Method;

public class Interpreter {

    public static void interpreter(Method method, boolean logInst) {
        Thread thread = new Thread();
        Frame frame = thread.newFrame(method);
        thread.pushFrame(frame);

        try {
            loop(thread, logInst);
        } catch (Exception e) {
            logFrames(thread);
            e.printStackTrace();
        }
    }

    private static void logFrames(Thread thread) {
        if (!thread.isStackEmpty()) {
            Frame frame = thread.popFrame();
            Method method = frame.getMethod();
            String className = method.getClassMember().getThisclass().getThisClassName();
            System.out.println("pc : " + thread.getPC() +
                    " className : " + className +
                    " methodName : " + method.getClassMember().getName() +
                    " descriptor : " + method.getClassMember().getDescriptor());
        }
    }

    private static void logInstruction(Frame frame, Instruction inst) {
        Method method = frame.getMethod();
        String className = method.getClassMember().getThisclass().getThisClassName();
        String methodName = method.getClassMember().getName();
        int pc = frame.getThread().getPC();
        System.out.println("pc : " + pc +
                " className : " + className +
                " methodName : " + methodName +
                " descriptor : " + method.getClassMember().getDescriptor());
    }

    private static void loop(Thread thread, boolean logInst) {

        BytecodeReader reader = new BytecodeReader();
        while (true) {
            Frame frame = thread.currentFrame();
            int pc = frame.getNextPC();
            thread.setPC(pc);

            //  decode
            reader.reSet(frame.getMethod().getCode(), pc);
            int opcode = reader.parse1U();
            Instruction inst = Factory.newInstruction(opcode);
            inst.fetchOperands(reader);
            frame.setNextPC(reader.getPc());

            if (logInst) {
                logInstruction(frame, inst);
            }

//            System.out.println("pc :" + pc + " opcode: " + opcode);
            inst.execute(frame);
            if (thread.isStackEmpty()) {
                break;
            }


        }
    }

}
