package rtda.heap;

public class CpSymref {

    public ConstantPool getCp() {
        return cp;
    }

    public void setCp(ConstantPool cp) {
        this.cp = cp;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Class getThisClass() {
        return thisClass;
    }

    public void setThisClass(Class thisClass) {
        this.thisClass = thisClass;
    }

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
