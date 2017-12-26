package rtda.heap;

import java.util.Arrays;

public class MethodDescriptor {

    String[] parameterTypes;
    String returnType;

    public void addParameterType(String t) {
        if (parameterTypes == null) {

            return;
        }
        int plen = this.parameterTypes.length;
        String[] temp = new String[plen + 1];
        temp = Arrays.copyOfRange(temp, 0, plen);
        temp[plen + 1] = t;
    }

    public String[] getParameterTypes() {
        return parameterTypes;
    }

    public void setParamterTypes(String[] paramterTypes) {
        this.parameterTypes = paramterTypes;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }
}
