import java.util.*;

public class Main {

    private static final String Version = "0.0.1";
    private static String Classpath;
    private static String Class;
    private static String[] Args;
    private static String jrepath;

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        String cmd = sc.nextLine();
        sc.close();
        String[] cmds = cmd.split(" ");

        List<String> als = new ArrayList<String>();
        Collections.addAll(als, cmds);

        if(!als.get(0).equals("java")) {
            System.out.println("must start with java");
            return;
        } else if(cmds.length <= 1) {
            System.out.println("miss class name");
            return;
        }

        int index = 1;

        for(int i = 0; i < cmds.length; i++) {
            if(cmds[i].equals("-version")) {
                System.out.println("version " + Version);
                return;
            } else if(cmds[i].equals("-help")) {
                System.out.println("java [-option] class [args...]");
                return;
            }
            if(cmds[i].equals("-cp") || cmds[i].equals("-classpath")) {
                try {
                    Main.Classpath = cmds[++i];
                    index++;index++;
                } catch(Exception e) {
                    System.out.println("miss argument");
                }
            }
            if(cmds[i].equals("-jre")) {
                try{
                    Main.jrepath = cmds[++i];
                    index++;index++;
                } catch(Exception e) {
                    System.out.println("miss argument");
                }
            }
        }
        try {
            Main.Class = cmds[index++];
            Main.Args = Arrays.copyOfRange(cmds, index, cmds.length );
        } catch (Exception e) {
            System.out.println("miss argument");
        }

        System.out.print("java " + "-jre " + Main.jrepath + " -classpath " + Main.Classpath + " class " + Main.Class + " args ");
        for(String s : Main.Args) {
            System.out.print(s + " ");
        }

    }

}
