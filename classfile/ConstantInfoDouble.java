package classfile;

public class ConstantInfoDouble extends ConstantInfo implements Info {

    private byte[] low;
    private byte[] high;
    private double value;

    ConstantInfoDouble() {
        this.tag = TAG.CONSTANT_Double;
    }

    @Override
    public void readInfo(ClassReader reader) {
        low = reader.parseU4().getU4();
        high = reader.parseU4().getU4();
        value = Double.longBitsToDouble(byteToLong(low, high));
        System.out.println(tag + " " + value);
    }

    public double getDouble() {
        return this.value;
    }

    private long byteToLong(byte[] low, byte[] high) {
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
        return s;
    }
}
