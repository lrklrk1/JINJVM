package classpath;

import java.io.File;

public class Classpath {

    private Entry bootClasspath;
    private Entry extClasspath;
    private Entry userClasspath;

    public static Classpath parse(String jreOpt, String cpOpt) {
        Classpath cp = new Classpath();
        cp.setBootAndExtClasspath(jreOpt);
        cp.setUserClasspath(cpOpt);
        return cp;
    }

    private void setBootAndExtClasspath(String jreOpt) {
        String jreDir = getJreDir(jreOpt);

        String jreLibpath = jreDir + File.separator + "lib" + File.separator + "*";
        this.bootClasspath = new WildcardEntrty(jreLibpath);

        String jreExtpath = jreDir + File.separator + "lib" + File.separator + "ext" + File.separator + "*";
        this.extClasspath = new WildcardEntrty(jreExtpath);
    }

    private String getJreDir(String jreOpt) {
        if  (jreOpt != null && !jreOpt.equals("")){
            File jre = new File(jreOpt);
            if (jre.exists()) {
                return jreOpt;
            }
        }
        File file = new File(".//jre");
        if(file.exists()) {
            return file.getAbsolutePath();
        }
        file = new File("F:" + File.separator + "Java%20jre");
        if(file.exists()) {
            return file.getAbsolutePath();
        }
        System.out.println("can not find jre");
        return null;
    }

    private void setUserClasspath(String cpOpt) {
        if(cpOpt.equals("")) {
            cpOpt = ".";
        }
        this.userClasspath = Entry.newEntry(cpOpt);
    }

    public byte[] readClass(String className) {
        className += ".class";
        byte[] data = this.bootClasspath.readClass(className);
        if (data != null) {
            return data;
        }
        data = this.extClasspath.readClass(className);
        if (data != null) {
            return data;
        }
        return this.userClasspath.readClass(className);
    }
//
//    public String string() {
//        return this.userClasspath.string();
//    }

}
