package classfile;

public class ConstantInfoInteger extends ConstantInfo implements Info {

    int value;

    @Override
    public void readInfo(ClassReader reader) {
        byte[] temp = reader.parseU4().getU4();
        int s = 0;
        int s0 = temp[0] & 0xff;
        int s1 = temp[1] & 0xff;
        int s2 = temp[2] & 0xff;
        int s3 = temp[3] & 0xff;
        s3 <<= 24;
        s2 <<= 16;
        s1 <<= 8;
        s = s0 | s1 | s2 | s3;
        this.value = s;
    }
}
