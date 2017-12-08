package classpath;

import java.io.*;

public class DirEntry implements Entry {

    String absPath;

    @Override
    public byte[] readClass(String className) {
        byte[] data = null;
        File file = new File(absPath, className);
        ByteArrayOutputStream baos = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            baos = new ByteArrayOutputStream();
            byte[] temp = new byte[1024];
            while(fis.read(temp) != -1) {
                baos.write(temp);
            }
            data = baos.toByteArray();
        } catch (Exception e) {
            System.out.println("something wrong with reading [DirEntry]");
        }

        return data;
    }

    @Override
    public String string() {
        return this.absPath;
    }

    public DirEntry(String path) {
        try {
            File file = new File(path);
            if (!file.isDirectory() || !file.isAbsolute()) {
                System.out.println("this is not a absolute or dictionary");
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
