import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class test {

    public static void main(String args[]) {
        String s = "C:" + File.separator + "Users" + File.separator + "lrk" + File.separator +
                "Desktop" + File.separator + "a" + File.separator + "JsonArray.class";
        File file = new File(s);
        byte[] data = null;
        ByteArrayOutputStream baos = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            baos = new ByteArrayOutputStream();
            byte[] temp = new byte[1024];
            while(fis.read(temp) != -1) {
                baos.write(temp);
            }
            data = baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
//        for(byte b : data) {
//            System.out.print(b + " ");
//        }
        char[] out = encodeHex(data, DIGITS_LOWER);
        for(char a : out) {
            System.out.print(a + " ");
        }
    }

    protected static char[] encodeHex(byte[] data, char[] toDigits) {
        int l = data.length;
        char[] out = new char[l << 1];
        for (int i = 0, j = 0; i < l; i++) {
            out[j++] = toDigits[(0xF0 & data[i]) >>> 4];
            out[j++] = toDigits[0x0F & data[i]];
        }
        return out;
    }

    private static final char[] DIGITS_LOWER = { '0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

}
