package classfile;

public class ConstantMemberrefInfo extends ConstantInfo implements Info{

    private ConstantPool cp;
    private JVMU2 classIndex;
    private JVMU2 nameAndTypeIndex;

    public ConstantMemberrefInfo(ConstantPool cp) {
        this.cp = cp;
    }


    @Override
    public void readInfo(ClassReader reader) {
        this.classIndex = reader.parseU2();
        this.nameAndTypeIndex = reader.parseU2();
        System.out.println(this.tag + " " + this.classIndex + " " + this.nameAndTypeIndex);
    }

    String getClassName() {
        return this.cp.getClassName(this.classIndex);
    }

    String getName() {
        return this.cp.getName(this.nameAndTypeIndex);
    }

    String getType() {
        return this.cp.getType(this.nameAndTypeIndex);
    }
}
