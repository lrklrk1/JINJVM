package classpath;

import java.io.File;

public class WildcardEntrty implements Entry {

    private Entry[] entries = new Entry[0];
//    private Entry[]

    WildcardEntrty(String path) {
        File[] subFiles = null;
        String basepath = path.substring(0, path.length() - 2);
        File file = new File(basepath);
        if (file.isDirectory()) {
            subFiles = file.listFiles();
        }
        if (null != subFiles) {
            entries = new Entry[subFiles.length];
        } else {
            return;
        }
        int index = 0;
        for(File f : subFiles) {
            if(f.isDirectory() || f.getName().endsWith(".jar") || f.getName().endsWith(".JAR")) {
                if(f.getName().endsWith(".jar") || f.getName().endsWith(".JAR")) {
                    entries[index++] = new ZipEntry(f.getAbsolutePath());
                } else {
                    entries[index++] = new DirEntry(f.getAbsolutePath());
                }
            }

        }
    }

    @Override
    public byte[] readClass(String className) {
        byte[] data = null;
        for (Entry entry : entries) {
            if (null != entry && null == data) {
                data = entry.readClass(className);
            }
        }
        return data;
    }

    @Override
    public String string() {
        StringBuilder sb = new StringBuilder();
        for(Entry entry : entries) {
            sb.append(entry.string());
        }
        return sb.toString();
    }
}
