package rtda.heap;

public class CpInteger implements Constant {

    private int value;

    public CpInteger(int value) {
        this.value = value;
    }

    public void setValue(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
