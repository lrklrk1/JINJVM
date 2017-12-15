package instructions.base;

import classfile.JVMU1;
import classfile.JVMU2;

import java.math.BigInteger;

public class BytecodeReader {

    byte[] code;
    int pc;

    public void reSet(byte[] code, int pc) {
        this.code = code;
        this.pc = pc;
    }

    int parse1U() {
        return code[pc++]&0xff;
    }

    int parse1() {
        return code[pc++];
    }

    int parse2U() {
        return Byte.compareUnsigned(code[pc++], code[pc++]);
    }

    int parse2() {
        byte high = code[pc++];
        byte low = code[pc++];
        return (short)(((high & 0x00FF) << 8) | (0x00FF & low));
    }

    int parse4() {
        int temp = 0;
        int t0 = code[pc + 3] & 0xff;
        int t1 = code[pc + 2] & 0xff;
        int t2 = code[pc + 1] & 0xff;
        int t3 = code[pc] & 0xff;
        t3 <<= 24;
        t2 <<= 16;
        t1 <<= 8;
        temp = t0 | t1 | t2 | t3;
        pc += 4;
        return temp;
    }
}
