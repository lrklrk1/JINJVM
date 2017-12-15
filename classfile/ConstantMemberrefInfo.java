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
        System.out.println(tag + " " + classIndex + " " + nameAndTypeIndex);
    }

    String getClassName() {
        return cp.getClassName(classIndex);
    }

    String getName() {
        return cp.getName(nameAndTypeIndex);
    }

    String getType() {
        return cp.getType(nameAndTypeIndex);
    }
}
