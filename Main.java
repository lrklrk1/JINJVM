import classpath.Classpath;

import java.util.*;

public class Main {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        String cmd = sc.nextLine();
        sc.close();
        String[] cmds = cmd.split(" ");

        Cmd c = Cmd.parseCmd(cmds);

        startJVM(c);

    }

    private static void startJVM(Cmd cmd) {
        Classpath cp = Classpath.parse(cmd.Jrepath, cmd.Classpath);
        byte[] data = cp.readClass(cmd.Class);
        for (byte b : data) {
            System.out.print(b + " ");
        }
    }

}
