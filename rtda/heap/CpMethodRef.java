package rtda.heap;

public class CpMethodRef extends CpMemberRef {

    Method method;

    public CpMethodRef(ConstantPool cp, classfile.ConstantMethodrefInfo cmei) {
        this.cp = cp;
        classfile.ConstantMemberrefInfo cmi = (classfile.ConstantMemberrefInfo) cmei;
        copyMemberRefInfo(cmi);
    }

}
