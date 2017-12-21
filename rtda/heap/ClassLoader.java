package rtda.heap;

import java.util.HashMap;
import java.util.Map;

public class ClassLoader {

    classpath.Classpath classpath;
    Map<String, Class> classMap;

    public ClassLoader(classpath.Classpath classpath) {
        this.classpath = classpath;
        this.classMap = new HashMap<String, Class>();
    }

    public Class loadClass(String name) {
        if (classMap.containsKey(name)) {
            return classMap.get(name);
        }
        return loadNoArrayClass(name);
    }

    private Class loadNoArrayClass(String name) {
        return null;
    }

}
