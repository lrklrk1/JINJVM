package classfile;

public class ConstantUtf8Info extends ConstantInfo implements Info {

    private String value;
    private int length;
    private byte[] bytes;

    ConstantUtf8Info() {
        this.tag = TAG.CONSTANT_Utf8;
    }

    String getString() {
        return this.value;
    }

    @Override
    public void readInfo(ClassReader reader) {
        this.length = reader.parseU2().getInt();
        this.bytes = reader.parseBytes(length);
        try {
            this.convertMUTF8(bytes);
            this.value = new String(bytes, "UTF-8");
            System.out.println(this.tag + " " + this.value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void convertMUTF8(byte[] bytes) {
        byte[] originalBytes = bytes;
        int nullCount = 0;
        for (int i = 0; i < originalBytes.length; i++) {
            if (originalBytes[i] == 0) {
                nullCount++;
            }
        }
        byte[] convertedBytes = new byte[originalBytes.length + nullCount];
        for (int i = 0, j = 0; i < originalBytes.length; i++, j++) {
            convertedBytes[j] = originalBytes[i];
            if (originalBytes[i] == 0) {
                convertedBytes[j] = (byte) 0xC0;
                ++j;
                convertedBytes[j] = (byte) 0x80;
            }
        }
    }
}
