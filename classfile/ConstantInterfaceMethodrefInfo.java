package classfile;

public class ConstantInterfaceMethodrefInfo extends ConstantMemberrefInfo{

    ConstantInterfaceMethodrefInfo(ConstantPool cp) {
        super(cp);
        this.tag = TAG.CONSTANT_InterfaceMethodref;
    }

}
