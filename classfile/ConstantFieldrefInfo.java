package classfile;

public class ConstantFieldrefInfo extends ConstantMemberrefInfo{

    ConstantFieldrefInfo(ConstantPool cp) {
        super(cp);
        this.tag = TAG.CONSTANT_Fieldref;
    }

}
