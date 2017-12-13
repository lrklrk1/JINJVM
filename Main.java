import classfile.Attribute;
import classfile.AttributeInfo;
import classfile.ClassFile;
import classfile.MemberInfo;
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
        System.out.println();
        System.out.println(cf.getAccessFlag());
        System.out.println(cf.getThisClassName() + "  class");
        System.out.println(cf.getSuperClassName() + "   superClass");
        System.out.println(cf.getInterfaceCount());
        System.out.println(cf.getInterface());
        for (MemberInfo mi : cf.getFields()) {
            System.out.println(mi.getName() + "  field " + mi.getDescriptor());
            System.out.println(mi.getAttributeCount());
        }
        for (MemberInfo mi : cf.getMethods()) {
            System.out.println(mi.getName() + "  method " + mi.getDescriptor());
            System.out.println(mi.getAttributeCount());
        }

        for (AttributeInfo a : cf.getAttributes()) {
            System.out.println(a.toString());
        }

    }

}
