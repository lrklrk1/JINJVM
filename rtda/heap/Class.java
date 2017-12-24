package rtda.heap;

import classfile.ClassFile;
import rtda.LocalVars;


public class Class {

    private int accessFlag = 0;
    private String thisClassName;
    private String superClassName;
    private String[] interfaceNames;
    private ConstantPool constantPool;
    private Field[] fields;
    private Method[] methods;
    private ClassLoader loader;
    private Class superClass;
    private Class[] interfaces;
    private int instancesSlotCount;
    private int staticSlotCount;
    private static LocalVars staticVars;

    public int getAccessFlag() {
        return accessFlag;
    }

    public void setAccessFlag(int accessFlag) {
        this.accessFlag = accessFlag;
    }

    public String getThisClassName() {
        return thisClassName;
    }

    public void setThisClassName(String thisClassName) {
        this.thisClassName = thisClassName;
    }

    public String getSuperClassName() {
        return superClassName;
    }

    public void setSuperClassName(String superClassName) {
        this.superClassName = superClassName;
    }

    public String[] getInterfaceNames() {
        return interfaceNames;
    }

    public void setInterfaceNames(String[] interfaceNames) {
        this.interfaceNames = interfaceNames;
    }

    public ConstantPool getConstantPool() {
        return constantPool;
    }

    public void setConstantPool(ConstantPool constantPool) {
        this.constantPool = constantPool;
    }

    public Field[] getFields() {
        return fields;
    }

    public void setFields(Field[] fields) {
        this.fields = fields;
    }

    public Method[] getMethods() {
        return methods;
    }

    public void setMethods(Method[] methods) {
        this.methods = methods;
    }

    public ClassLoader getLoader() {
        return loader;
    }

    public void setLoader(ClassLoader loader) {
        this.loader = loader;
    }

    public Class getSuperClass() {
        return superClass;
    }

    public void setSuperClass(Class superClass) {
        this.superClass = superClass;
    }

    public Class[] getInterfaces() {
        return interfaces;
    }

    public void setInterfaces(Class[] interfaces) {
        this.interfaces = interfaces;
    }

    public int getInstancesSlotCount() {
        return instancesSlotCount;
    }

    public void setInstancesSlotCount(int instancesSlotCount) {
        this.instancesSlotCount = instancesSlotCount;
    }

    public int getStaticSlotCount() {
        return staticSlotCount;
    }

    public void setStaticSlotCount(int staticSlotCount) {
        this.staticSlotCount = staticSlotCount;
    }

    public LocalVars getStaticVars() {
        return staticVars;
    }

    public void setStaticVars(LocalVars staticVars) {
        this.staticVars = staticVars;
    }

    public Class(ClassFile classFile) {
        this.accessFlag = classFile.getAccessFlag();
        this.thisClassName = classFile.getThisClassName();
        this.superClassName = classFile.getSuperClassName();
        this.interfaceNames = classFile.getInterface();
        this.constantPool = ConstantPool.newConstantPool(this, classFile.getConstantPool());
        this.fields = Field.newFields(this, classFile.getFields());
        this.methods = Method.newMethods(this, classFile.getMethods());
    }

    public boolean isPublic() {
        return 0 != (accessFlag & AccessFlag.ACC_PUBLIC.num);
    }

    public boolean isFinal() {
        return 0 != (accessFlag & AccessFlag.ACC_FINAL.num);
    }

    public boolean isSuper() {
        return 0 != (accessFlag & AccessFlag.ACC_SUPER.num);
    }

    public boolean isInterface() {
        return 0 != (accessFlag & AccessFlag.ACC_INTERFACE.num);
    }

    public boolean isAbstract() {
        return 0 != (accessFlag & AccessFlag.ACC_ABSTRACT.num);
    }

    public boolean isSynthetic() {
        return 0 != (accessFlag & AccessFlag.ACC_SYNTHETIC.num);
    }

    public boolean isAnnotation() {
        return 0 != (accessFlag & AccessFlag.ACC_ANNOTATION.num);
    }

    public boolean isEnum() {
        return 0 != (accessFlag & AccessFlag.ACC_ENUM.num);
    }

    public boolean isAccessibleTo(Class other) {
        return isPublic() || getPackageName() == other.getPackageName();
    }

    public String getPackageName() {
        int lastLash = thisClassName.lastIndexOf("/");
        if (lastLash >= 0) {
            return thisClassName.substring(0, lastLash);
        }
        return "";
    }

    public boolean isSubClassof(Class c) {
        for (Class cc = this.getSuperClass(); cc != null; cc = cc.getSuperClass()) {
            if (cc == c) {
                return true;
            }
        }
        return false;
    }

    public boolean isImplements(Class iface) {
        for (Class c = this.getSuperClass(); c != null; c = c.getSuperClass()) {
            for (Class i : c.getInterfaces()) {
                if (i == iface || i.isSubInterfaceOf(iface)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isSubInterfaceOf(Class iface) {
        for (Class suprtInterface : this.getInterfaces()) {
            if (suprtInterface == iface || suprtInterface.isSubClassof(iface)) {
                return true;
            }
        }
        return false;
    }

    public object newObject() {
        return new object(this);
    }

    public boolean isAssignableFrom(Class other) {
        if (other == this) {
            return true;
        }
        if (!this.isInterface()) {
            return other.isSubClassof(this);
        } else {
            return other.isImplements(this);
        }
    }

    public Method getMainMethod() {
        return getStaticMethod("main", "([Ljava/lang/String;)V");
    }

    public Method getStaticMethod(String name, String descpritor) {
        for (Method method : getMethods()) {
            if (method.getClassMember().isStatic() &&
                    method.getClassMember().getName().equals(name) &&
                    method.getClassMember().getDescriptor().equals(descpritor)) {
                return method;
            }
        }
        return null;
    }

}
