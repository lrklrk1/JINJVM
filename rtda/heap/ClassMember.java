package rtda.heap;

import classfile.MemberInfo;

public class ClassMember {

    int accessFlag;
    String name;
    String descriptor;
    Class thisclass;

    public int getAccessFlag() {
        return accessFlag;
    }

    public void setAccessFlag(int accessFlag) {
        this.accessFlag = accessFlag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
    }

    public Class getThisclass() {
        return thisclass;
    }

    public void setThisclass(Class thisclass) {
        this.thisclass = thisclass;
    }

    public void copyMember(MemberInfo memberInfo) {
        this.accessFlag = memberInfo.getAccessFlag();
        this.name = memberInfo.getName();
        this.descriptor = memberInfo.getDescriptor();
    }

}
