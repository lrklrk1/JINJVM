package rtda.heap;

import classfile.ConstantMemberrefInfo;
import classfile.ConstantMethodrefInfo;

public class CpInterfaceMethodRef extends CpMemberRef implements Constant {

    Method method;

    public CpInterfaceMethodRef(ConstantPool cp, classfile.ConstantInterfaceMethodrefInfo cimi) {
        this.cp = cp;
        ConstantMemberrefInfo cmi = (ConstantMemberrefInfo) cimi;
        copyMemberRefInfo(cmi);
    }

}
