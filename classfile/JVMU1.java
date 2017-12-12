package classfile;

public class JVMU1 {

    byte[] u1 = new byte[1];

    JVMU1(byte[] u1) {
        if(u1 == null || !u1.getClass().isArray() || u1.length != 1) {
            return;
        }
        this.u1[0] = u1[0];
    }

    public byte[] getU1() {
        return this.u1;
    }

    public int getInt() {
        return (int)u1[0] & 0xff;
    }

}
