package classfile;

public class ConstantMethodrefInfo extends ConstantMemberrefInfo {

    ConstantMethodrefInfo(ConstantPool cp) {
        super(cp);
        this.tag = TAG.CONSTANT_Methodref;
    }

}
