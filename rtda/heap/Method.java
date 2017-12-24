package rtda.heap;

import classfile.CodeAttribute;
import classfile.MemberInfo;

public class Method {

    ClassMember classMember;
    int maxStack;
    int maxLocals;
    byte[] code;
    int argsSlotCount;

    public int getArgsSlotCount() {
        return argsSlotCount;
    }

    public void setArgsSlotCount(int argsSlotCount) {
        this.argsSlotCount = argsSlotCount;
    }

    public ClassMember getClassMember() {
        return classMember;
    }

    public void setClassMember(ClassMember classMember) {
        this.classMember = classMember;
    }

    public int getMaxStack() {
        return maxStack;
    }

    public void setMaxStack(int maxStack) {
        this.maxStack = maxStack;
    }

    public int getMaxLocals() {
        return maxLocals;
    }

    public void setMaxLocals(int maxLocals) {
        this.maxLocals = maxLocals;
    }

    public byte[] getCode() {
        return code;
    }

    public void setCode(byte[] code) {
        this.code = code;
    }

    public static Method[] newMethods(Class thisClass, MemberInfo[] cfMethods) {
        Method[] methods = new Method[cfMethods.length];
        for (int i = 0; i < cfMethods.length; i++) {
            methods[i] = new Method();
            methods[i].setClassMember(new ClassMember());
            methods[i].getClassMember().setThisclass(thisClass);
            methods[i].getClassMember().copyMember(cfMethods[i]);
            methods[i].copyAttribute(cfMethods[i]);
            methods[i].calcArgSlotCount();
        }
        return methods;
    }

    public void copyAttribute(MemberInfo method) {
        if (method != null && method.getArrtibute().length != 0 && null != method.getArrtibute()[0]) {
            CodeAttribute codeAttribute = method.getArrtibute()[0];
            maxStack = codeAttribute.getMaxStack();
            maxLocals = codeAttribute.getMaxLocals();
            code = codeAttribute.getCode();
        }
    }

    private void calcArgSlotCount() {

    }

}
