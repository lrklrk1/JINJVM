package instructions.base;

import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;

public class BytecodeReader {

    byte[] code;
    int pc;
    private DataInput di = null;

    public int getPc() {
        return pc;
    }

    public void reSet(byte[] code, int pc) {
        this.code = code;
        this.pc = pc;
        ByteArrayInputStream bais = new ByteArrayInputStream(code);
        di = new DataInputStream(bais);
    }

    public int parse1U() {
        pc++;
        try {
            return di.readUnsignedByte();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.exit(0);
        return 0;
    }

    public byte parse1() {
        pc++;
        try {
            return di.readByte();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.exit(0);
        return 0;
    }

    public int parse2U() {
        pc += 2;
        try {
            return di.readUnsignedShort();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.exit(0);
        return 1;
    }

    public int parse2() {
        pc += 2;
        try {
            return di.readShort();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.exit(0);
        return 1;
    }

    public int parse4() {
        pc += 4;
        try {
            return di.readInt();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.exit(0);
        return 0;
    }

    public byte[] parse4s(int n) {
        pc += n;
        byte[] bytes = new byte[n];
        try {
            for (int i = 0; i < n; i++) {
                bytes[i] = di.readByte();
            }
            return bytes;
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.exit(0);
        return null;
    }

    public void skipPadding() {
        while (pc % 2 != 0) {
            parse1U();
        }
    }

}
