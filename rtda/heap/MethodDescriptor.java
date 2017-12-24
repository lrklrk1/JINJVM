package rtda.heap;

import java.util.Arrays;

public class MethodDescriptor {

    String[] paramterTypes;
    String returnType;

    public void addParameterType(String t) {
        int plen = this.paramterTypes.length;
        String[] temp = new String[plen + 1];
        temp = Arrays.copyOfRange(temp, 0, plen);
        temp[plen + 1] = t;
    }

}
