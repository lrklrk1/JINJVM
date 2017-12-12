package classfile;

public class ConstantInfoFloat extends ConstantInfo implements Info {

    float value;

    ConstantInfoFloat() {
        this.tag = TAG.CONSTANT_Float;
    }

    @Override
    public void readInfo(ClassReader reader) {
        this.value = (float)reader.parseU4().getInt();
        System.out.println(this.tag + " " + this.value);
    }
}
