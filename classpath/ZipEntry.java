package classpath;

import java.io.*;
import java.util.zip.ZipFile;

public class ZipEntry implements Entry {

    private String absPath;
    private ZipFile zipFile;

    ZipEntry(String path) {
        try {
            File file = new File(path);
            if(!file.isFile()) {
                System.out.println(".jar/.zip don not exist!");
            }
            try {
                zipFile = new ZipFile(absPath);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (zipFile == null) {
                System.out.println("this is not a zip");
                throw new Exception();
            }
            this.absPath = path;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public byte[] readClass(String className) {
        java.util.zip.ZipEntry zipClassFile = zipFile.getEntry(className);
        if (zipClassFile == null) {
//            System.out.println("wrong class name");
            return null;
        }
        byte[] data = null;
        try (InputStream is = zipFile.getInputStream(zipClassFile);
             BufferedInputStream bis = new BufferedInputStream(is);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            byte[] temp = new byte[1024];
            while(bis.read(temp) != -1) {
                baos.write(temp);
            }
            data = baos.toByteArray();
        } catch (Exception e) {
            System.out.println("wrong .zip/.jar");
        }
        return data;
    }

    @Override
    public String string() {
        return absPath;
    }
}
