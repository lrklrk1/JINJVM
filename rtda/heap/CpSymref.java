package rtda.heap;

public class CpSymref {

    ConstantPool cp;
    String className;
    Class thisClass;

    public Class resolvedClass() {
        if (null == thisClass) {
            resolvedClassRef();
        }
        return thisClass;
    }

    private void resolvedClassRef() {
        Class d = cp.getThisclass();
        Class c = d.getLoader().loadClass(className);
        if (!c.isAccessibleTo(d)) {
            System.out.println("Java.lang.IllegalAccessError");
            System.exit(0);
        }
        thisClass = c;
    }




}
