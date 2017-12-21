package classfile;

public class ConstantInfoFloat extends ConstantInfo implements Info {

    float value;

    ConstantInfoFloat() {
        this.tag = TAG.CONSTANT_Float;
    }

    public float getValue() {
        return value;
    }

    @Override
    public void readInfo(ClassReader reader) {
        this.value = (float)reader.parseU4().getInt();
        System.out.println(tag + " " + value);
    }
}
