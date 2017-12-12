package classfile;

public class JVMU2 {

    byte[] u2 = new byte[2];

    JVMU2(byte[] u2) {
        if(u2 == null || !u2.getClass().isArray() || u2.length != 2) {
            return;
        }
        this.u2[0] = u2[0];
        this.u2[1] = u2[1];
    }

    public byte[] getU2() {
        return this.u2;
    }

    int getInt() {
        int high = u2[0] & 0xff;
        int low = u2[1] & 0xff;
        return ( high << 8 | low );
    }

}
