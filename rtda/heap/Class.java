package rtda.heap;

import classfile.ClassFile;
import classfile.ConstantPool;
import classfile.MemberInfo;
import rtda.Slot;

public class Class {

    int accessFlag = 0;
    String thisClassName;
    String superClassName;
    String[] interfaceNames;
    ConstantPool constantPool;
    MemberInfo[] fields;
    MemberInfo[] methods;
    ClassLoader loader;
    Class superClass;
    Class[] interfaces;
    int instancesSlotCount;
    int staticSlotCount;
    Slot[] staticVars;

    public Class(ClassFile classFile) {
        this.accessFlag = classFile.getAccessFlag();
        this.thisClassName = classFile.getThisClassName();
        this.superClassName = classFile.getSuperClassName();
        this.interfaceNames = classFile.getInterface();
//        this.constantPool = classFile.getConstantPool();
//        this.fields = classFile.getFields();
//        this.methods = classFile.getMethods();
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


}
