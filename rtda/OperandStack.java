package rtda;

public class OperandStack {

    int size;
    Slot[] slots;

    OperandStack(int maxStack) {
        assert(maxStack > 0);
        slots = new Slot[maxStack];
        for (int i =0; i < maxStack; i++) {
            slots[i] = new Slot();
        }
    }

    public void pushInt(int value) {
        slots[this.size++].num = value;
    }

    public int popInt() {
        return slots[--size].num;
    }

    public void pushFloat(float value) {
        slots[size++].num = Float.floatToIntBits(value);
    }

    public float popFloat() {
        return Float.intBitsToFloat(slots[--size].num);
    }

    public void pushLong(long value) {
        this.slots[size++].num = (int) (0xFFFFFFFFl & value);
        this.slots[size++].num = (int) ((0xFFFFFFFF00000000l & value) >> 32);
    }

    public long popLong() {
        size -= 2;
        return ((long)slots[size].num & 0xFFFFFFFFl | ((long)slots[size + 1].num << 32) & 0xFFFFFFFF00000000l);
    }

    public void pushDouble(double value) {
        long temp = Double.doubleToLongBits(value);
        pushLong(temp);
    }

    public double popDouble() {
        long temp = popLong();
        return Double.longBitsToDouble(temp);
    }

    public void pushRef(object ref) {
        slots[size++].ref = ref;
    }

    public object popRef() {
        object temp = slots[--size].ref;
        slots[size].ref = null;
        return temp;
    }

    public Slot popSlot() {
        Slot temp = slots[--size];
        slots[size] = null;
        return temp;
    }

    public void pushSlot(Slot slot) {
        slots[size++] = slot;
    }

}
