import classfile.ClassFile;
import classpath.Classpath;

import java.io.File;
import java.util.*;

public class Main {

    public static void main(String args[]) {

//        Scanner sc = new Scanner(System.in);
//        String cmd = sc.nextLine();
//        sc.close();
        String cmd = "java -cp " + "C:" + File.separator + "Users" + File.separator + "lrk" + File.separator +
                "Desktop" + File.separator + "a" + File.separator + " JsonArray";
        String[] cmds = cmd.split(" ");

        Cmd c = Cmd.parseCmd(cmds);

        startJVM(c);

    }

    private static void startJVM(Cmd cmd) {
        Classpath cp = Classpath.parse(cmd.Jrepath, cmd.Classpath);
        byte[] data = cp.readClass(cmd.Class);
        ClassFile cf = ClassFile.parse(data);

    }

}
