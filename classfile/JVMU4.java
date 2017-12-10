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

}
