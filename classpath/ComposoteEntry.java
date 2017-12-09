package classpath;

import java.io.File;

public class ComposoteEntry implements Entry {

    private Entry[] entries = new Entry[0];

    @Override
    public byte[] readClass(String className) {
        byte[] data = null;
        for (Entry entry : entries) {
            if (entry != null) {
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

    ComposoteEntry(String path) {
        String[] paths = path.split(File.pathSeparator);
        entries = new Entry[paths.length];
        for(int i = 0; i < paths.length; i++) {
            entries[i] = Entry.newEntry(paths[i]);
        }
    }

}
