package rtda.heap;

public class CpFieldRef extends CpMemberRef {

    Field field;

    public CpFieldRef(ConstantPool cp, classfile.ConstantFieldrefInfo cfi) {
        this.cp = cp;
        classfile.ConstantMemberrefInfo cmi = (classfile.ConstantMemberrefInfo) cfi;
        copyMemberRefInfo(cmi);
    }

}
