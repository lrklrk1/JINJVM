package classfile;

public class ConstantInfoInteger extends ConstantInfo implements Info {

    private int value;

    ConstantInfoInteger() {
        this.tag = TAG.CONSTANT_Integer;
    }

    @Override
    public void readInfo(ClassReader reader) {
        this.value = reader.parseU4().getInt();
        System.out.println(this.tag + " " + this.value);
    }
}
