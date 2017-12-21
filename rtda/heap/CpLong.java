package rtda.heap;

public class CpLong implements Constant {

    private long value;

    public CpLong(long value) {
        this.value = value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }

}
