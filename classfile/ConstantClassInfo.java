package classfile;

public class ConstantClassInfo extends ConstantInfo implements Info {

    private ConstantPool cp;
    private JVMU2 nameIndex;

    public ConstantClassInfo(ConstantPool cp) {
        this.cp = cp;
        this.tag = TAG.CONSTANT_Class;
    }

    @Override
    public void readInfo(ClassReader reader) {
        this.nameIndex = reader.parseU2();
        System.out.println(tag + " " + nameIndex);
    }

    public String getName() {
        return cp.getUtf(nameIndex);
    }
}
