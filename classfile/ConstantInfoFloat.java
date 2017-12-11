package classfile;

public class ConstantInfoFloat extends ConstantInfo implements Info {

    float value;

    @Override
    public void readInfo(ClassReader reader) {
        this.value = (float)reader.parseU4().getInt();
    }
}
