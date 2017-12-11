package classfile;

public class JVMU4 {

    byte[] u4 = new byte[4];

    JVMU4(byte[] u4) {
        if(u4 == null || !u4.getClass().isArray() || u4.length != 4) {
            return;
        }
        this.u4[0] = u4[0];
        this.u4[1] = u4[1];
        this.u4[2] = u4[2];
        this.u4[3] = u4[3];
    }

    public byte[] getU4() {
        return this.u4;
    }

    public int getInt() {
        int s = 0;
        int s0 = u4[0] & 0xff;
        int s1 = u4[1] & 0xff;
        int s2 = u4[2] & 0xff;
        int s3 = u4[3] & 0xff;
        s3 <<= 24;
        s2 <<= 16;
        s1 <<= 8;
        s = s0 | s1 | s2 | s3;
        return s;
    }

}
