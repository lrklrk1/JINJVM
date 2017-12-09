package classpath;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class DirEntry implements Entry {

    private String absPath;
    private File file;

    @Override
    public byte[] readClass(String className) {
        File classFile = new File(file, className);
        if (!classFile.isFile()) {
//            System.out.println("wrong className");
            return null;
        }
        byte[] data = null;
        ByteArrayOutputStream baos = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(classFile);
            baos = new ByteArrayOutputStream();
            byte[] temp = new byte[1024];
            while(fis.read(temp) != -1) {
                baos.write(temp);
            }
            data = baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return data;
    }

    @Override
    public String string() {
        return this.absPath;
    }

    DirEntry(String path) {
        try {
            file = new File(path);
            if (!file.isDirectory()) {
                System.out.println("this is not a absolute or dictionary");
                throw new Exception();
            }
            this.absPath = path;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
