package classfile;

public class ConstantInfoString extends ConstantInfo implements Info {

    private ConstantPool cp;
    private JVMU2 stringIndex;

    public ConstantInfoString(ConstantPool cp) {
        this.cp = cp;
        this.tag = TAG.CONSTANT_String;
    }

    @Override
    public void readInfo(ClassReader reader) {
        this.stringIndex = reader.parseU2();
        System.out.println(tag + " " + stringIndex);
    }

    public String string() {
        return cp.getUtf(stringIndex);
    }
}
