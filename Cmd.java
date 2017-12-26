import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Cmd {

    static final String Version = "0.0.1";
    String Classpath;
    String Class;
    String[] Args;
    String Jrepath;
    boolean verboseClassFlag;
    boolean verboseInstFlag;

    static Cmd parseCmd(String[] cmds) {
        List<String> als = new ArrayList<>();
        Collections.addAll(als, cmds);
        Cmd cmd = new Cmd();
        if(!als.get(0).equals("java")) {
            System.out.println("must start with java");
            return null;
        } else if(cmds.length <= 1) {
            System.out.println("miss class name");
            return null;
        }

        int index = 1;

        for(int i = 0; i < cmds.length; i++) {
            if(cmds[i].equals("-version")) {
                System.out.println("version " + Cmd.Version);
                return null;
            } else if(cmds[i].equals("-help")) {
                System.out.println("java [-option] class [args...]");
                return null;
            }
            if(cmds[i].equals("-cp") || cmds[i].equals("-classpath")) {
                try {
                    cmd.Classpath = cmds[++i];
                    index++;index++;
                } catch(Exception e) {
                    System.exit(1);
                    System.out.println("miss argument");
                }
            }
            if(cmds[i].equals("-jre")) {
                try{
                    cmd.Jrepath = cmds[++i];
                    index++;index++;
                } catch(Exception e) {
                    System.out.println("miss argument");
                    System.exit(1);
                }
            }
        }
        try {
            cmd.Class = cmds[index++];
            cmd.Args = Arrays.copyOfRange(cmds, index, cmds.length );
        } catch (Exception e) {
            System.out.println("miss argument");
            System.exit(1);
        }
//F:\Java jre
        String jre = "F:" + File.separator + "java jre";
        cmd.Jrepath = jre;
        cmd.verboseClassFlag = true;
        cmd.verboseInstFlag = false;
        System.out.println("java "
                + "-jre " + cmd.Jrepath
                + " -classpath " + cmd.Classpath
                + " class " + cmd.Class
                + " args ");
//        for(String s : cmd.Args) {
//            System.out.print(s + " ");
//        }
        return cmd;
    }

}
