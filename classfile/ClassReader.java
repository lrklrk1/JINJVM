package classfile;

import java.util.Arrays;

public class ClassReader {

    private byte[] data;
    private int index = 0;

    public ClassReader(byte[] data) {
        if (data == null || data.length == 0) {
            System.out.println("empty class");
            return;
        }
        this.data = data;
    }

    JVMU1 parseU1() {
        JVMU1 jvmu1 = null;
        if(index + 1 < data.length) {
            byte[] temp = Arrays.copyOfRange(data, index, index + 1);
            jvmu1 = new JVMU1(temp);
        } else {
            System.out.println("index out of class data");
            return null;
        }
        index++;
        return jvmu1;
    }

    JVMU2 parseU2() {
        JVMU2 jvmu2 = null;
        if(index + 2 < data.length) {
            byte[] temp = Arrays.copyOfRange(data, index, index + 2);
            jvmu2 = new JVMU2(temp);
        } else {
            System.out.println("index out of class data");
            System.out.println(0);
            return null;
        }
        index += 2;
        return jvmu2;
    }

    JVMU2[] parseU2s() {
        JVMU2 jvmu2 = parseU2();
        JVMU2[] jvmu2s = new JVMU2[jvmu2.getInt()];
        for (int i = 0; i < jvmu2s.length; i++) {
            jvmu2s[i] = parseU2();
        }
        return jvmu2s;
    }

    JVMU4 parseU4() {
        JVMU4 jvmu4 = null;
        if(index + 4 < data.length) {
            byte[] temp = Arrays.copyOfRange(data, index, index + 4);
            jvmu4 = new JVMU4(temp);
        } else {
            System.out.println("index out of class data");
            return null;
        }
        index += 4;
        return jvmu4;
    }

    byte[] parseBytes(int length) {
        if (length + index < data.length) {
            byte[] temp = Arrays.copyOfRange(data, index, index + length);
            index += length;
            return temp;
        } else {
            System.out.println("index out of bounds " + index + " " + length);
            System.exit(1);
            return null;
        }
    }

}
