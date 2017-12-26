import classfile.Attribute;
import classfile.AttributeInfo;
import classfile.ClassFile;
import classfile.MemberInfo;
import classpath.Classpath;
import rtda.Frame;
import rtda.LocalVars;
import rtda.OperandStack;
import rtda.heap.Class;
import rtda.heap.ClassLoader;
import rtda.heap.Method;

import java.io.File;
import java.util.*;

public class Main {

    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        String cmd = sc.nextLine();
//        sc.close();
        String cmd = "java -cp " + "C:" + File.separator + "Users" + File.separator + "lrk" + File.separator +
                "Desktop" + File.separator + "a" + File.separator + " invokeDemo";
        String[] cmds = cmd.split(" ");

        Cmd c = Cmd.parseCmd(cmds);

        startJVM(c);
    }

    private static void startJVM(Cmd cmd) {
        Classpath cp = Classpath.parse(cmd.Jrepath, cmd.Classpath);
        ClassLoader loader = new rtda.heap.ClassLoader(cp, cmd.verboseClassFlag);

        String className = cmd.Class.replace(".", "/");
        Class mainClass = loader.loadClass(className);
        Method mainMethod = mainClass.getMainMethod();
        if (null != mainMethod) {
            Interpreter.interpreter(mainMethod, cmd.verboseInstFlag);
        } else {
            System.out.println("Main method not found in class " + className);
        }
    }
}
