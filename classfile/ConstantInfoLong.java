package classfile;

public class ConstantInfoLong extends ConstantInfo implements Info {

    private byte[] low;
    private byte[] high;
    private long value;

    ConstantInfoLong() {
        this.tag = TAG.CONSTANT_Long;
    }

    public long getValue() {
        return value;
    }

    @Override
    public void readInfo(ClassReader reader) {
        this.low = reader.parseU4().getU4();
        this.high = reader.parseU4().getU4();
        long s = 0;
        long s0 = low[0] & 0xff;
        long s1 = low[1] & 0xff;
        long s2 = low[2] & 0xff;
        long s3 = low[3] & 0xff;
        long s4 = high[0] & 0xff;
        long s5 = high[1] & 0xff;
        long s6 = high[2] & 0xff;
        long s7 = high[3] & 0xff;

        s1 <<= 8;
        s2 <<= 16;
        s3 <<= 24;
        s4 <<= 8 * 4;
        s5 <<= 8 * 5;
        s6 <<= 8 * 6;
        s7 <<= 8 * 7;
        s = s0 | s1 | s2 | s3 | s4 | s5 | s6 | s7;
        this.value = s;
//        System.out.println(tag + " " + value);
    }
}
