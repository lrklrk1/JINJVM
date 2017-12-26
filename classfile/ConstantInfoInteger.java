package classfile;

public class ConstantInfoInteger extends ConstantInfo implements Info {

    private int value;

    ConstantInfoInteger() {
        this.tag = TAG.CONSTANT_Integer;
    }

    public int getValue() {
        return value;
    }

    @Override
    public void readInfo(ClassReader reader) {
        this.value = reader.parseU4().getInt();
//        System.out.println(tag + " " + value);
    }
}
