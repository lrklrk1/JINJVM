package rtda.heap;

public class CpMethodRef extends CpMemberRef {

    Method method;

    public CpMethodRef(ConstantPool cp, classfile.ConstantMethodrefInfo cmei) {
        this.cp = cp;
        classfile.ConstantMemberrefInfo cmi = (classfile.ConstantMemberrefInfo) cmei;
        copyMemberRefInfo(cmi);
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }
}
