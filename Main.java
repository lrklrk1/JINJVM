import classfile.Attribute;
import classfile.AttributeInfo;
import classfile.ClassFile;
import classfile.MemberInfo;
import classpath.Classpath;
import rtda.Frame;
import rtda.LocalVars;
import rtda.OperandStack;

import java.io.File;
import java.util.*;

public class Main {

    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        String cmd = sc.nextLine();
//        sc.close();
        String cmd = "java -cp " + "C:" + File.separator + "Users" + File.separator + "lrk" + File.separator +
                "Desktop" + File.separator + "a" + File.separator + " GaussTest";
        String[] cmds = cmd.split(" ");

        Cmd c = Cmd.parseCmd(cmds);

        startJVM(c);
    }

    private static void startJVM(Cmd cmd) {
        Classpath cp = Classpath.parse(cmd.Jrepath, cmd.Classpath);
        ClassFile cf = loadClass(cmd.Class, cp);
        MemberInfo mainMethod = getMainMethod(cf);
        if (mainMethod != null) {
            Interpreter.interpreter(mainMethod);
        }
//        byte[] data = cp.readClass(cmd.Class);
//        ClassFile cf = ClassFile.parse(data);
//        Frame frame = new Frame(100, 100);
//        testLocalVars(frame.getLocalVars());
//        testOperandStack(frame.getOperandStack());
    }

    private static ClassFile loadClass(String className, Classpath cp) {
        byte[] data = cp.readClass(className);
        ClassFile cf = ClassFile.parse(data);
        return cf;
    }

    private static MemberInfo getMainMethod(ClassFile cf) {
        for (MemberInfo m : cf.getMethods()) {
            if (m.getName() == "main" && m.getDescriptor() == "([Ljava/lang/String;)V") {
                return m;
            }
        }
        System.exit(0);
        return null;
    }

    static void testLocalVars(LocalVars vars) {
        Long l1 = Long.parseLong("2997924580");
        Long l2 = Long.parseLong("-2997924580");
        Float f1 = Float.parseFloat("3.1415926");
        Double d1 = Double.parseDouble("2.71828182845");
        vars.setInt(0, 100);
        vars.setInt(1, -100);
        vars.setLong(2, l1);
        vars.setLong(4, l2);
        vars.setFloat(6, f1);
        vars.setDouble(7, d1);
        vars.setRef(9, null);
        System.out.println(vars.getInt(0));
        System.out.println(vars.getInt(1));
        System.out.println(vars.getLong(2));
        System.out.println(vars.getLong(4));
        System.out.println(vars.getFloat(6));
        System.out.println(vars.getDouble(7));
        System.out.println(vars.getRef(9));
    }

    static void testOperandStack(OperandStack ops) {
        Long l1 = Long.parseLong("2997924580");
        Long l2 = Long.parseLong("-2997924580");
        Float f1 = Float.parseFloat("3.1415926");
        Double d1 = Double.parseDouble("2.71828182845");
        ops.pushInt(100);
        ops.pushInt(-100);
        ops.pushLong(l1);
        ops.pushLong(l2);
        ops.pushFloat(f1);
        ops.pushDouble(2.71828182845);
        ops.pushRef(null);
        System.out.println(ops.popRef());
        System.out.println(ops.popDouble());
        System.out.println(ops.popFloat());
        System.out.println(ops.popLong());
        System.out.println(ops.popLong());
        System.out.println(ops.popInt());
        System.out.println(ops.popInt());
    }
}
