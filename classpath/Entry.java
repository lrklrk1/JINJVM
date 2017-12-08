package classpath;

import java.io.File;

public interface Entry {

    byte[] readClass(String className);

    String string();

    static Entry newEntry(String path) {

        if(path.contains(File.separator)) {
            return new ComposoteEntry(path);
        }

        if(path.endsWith("*")) {
            return new WildcardEntrty(path);
        }

        if(path.endsWith(".jar") || path.endsWith(".JAR") ||
                path.endsWith(".zip") || path.endsWith(".ZIP")) {
            return new ZipEntry(path);
        }

        return new DirEntry(path);

    }

}
