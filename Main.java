import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static final String Version = "0.0.1";
    private static String Classpath;
    private static String Class;
    private static String[] Args;

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        String cmd = sc.nextLine();
        sc.close();
        String[] cmds = cmd.split(" ");

        if(!cmds[0].equals("java")) {
            System.out.println("must start with java");
            return;
        } else if(cmds.length <= 1) {
            System.out.println("miss class name");
            return;
        }

        if(cmds[1].equals("-version")) {
            System.out.println("version " + Version);
            return;
        }

        if(cmds[1].equals("-help")) {
            System.out.println("java [-option] class [args...]");
            return;
        }

        if(cmds[1].equals("-cp") || cmds[1].equals("-classpath")) {
            if(cmds.length > 3) {
                Main.Classpath = cmds[2];
                Main.Class = cmds[3];
                if(cmds.length - 3 > 0) {
                    Main.Args = new String[cmds.length - 4];
                    Main.Args = Arrays.copyOfRange(cmds, 4, cmds.length);
                } else {
                    Main.Args = new String[0];
                }
            } else {
                System.out.println("miss the classpath");
            }
        } else {
            Main.Class = cmds[1];
            if(cmds.length - 2 > 0) {
                Main.Args = new String[cmds.length - 2];
               Main.Args = Arrays.copyOfRange(cmds, 2, cmds.length );
            } else {
                Main.Args = new String[0];
            }
        }

        System.out.print("java " + "-classpath " + Main.Classpath + " class " + Main.Class + " args ");
        for(String s : Main.Args) {
            System.out.print(s + " ");
        }

    }

}
