package rtda;

import rtda.heap.object;

public class LocalVars {

    Slot[] localVars;

    LocalVars(int maxLocals) {
        assert (maxLocals > 0);
        this.localVars = new Slot[maxLocals];
        for (int i =0; i < maxLocals; i++) {
            localVars[i] = new Slot();
        }
    }

    public void setInt(int index, int value) {
        localVars[index].num = value;
    }

    public int getInt(int index) {
        return localVars[index].num;
    }

    public void setFloat(int index, float value) {
        this.localVars[index].num = Float.floatToIntBits(value);
    }

    public float getFloat(int index) {
        return Float.intBitsToFloat(this.localVars[index].num);
    }

    public void setLong(int index, long value) {
        this.localVars[index].num = (int) (0xFFFFFFFFl & value);
        this.localVars[index + 1].num = (int) ((0xFFFFFFFF00000000l & value) >> 32);
    }

    public long getLong(int index) {
        return ((long)localVars[index].num & 0xFFFFFFFFl | ((long)localVars[index + 1].num << 32) & 0xFFFFFFFF00000000l);
    }

    public void setDouble(int index, double value) {
        long temp = Double.doubleToLongBits(value);
        setLong(index, temp);
    }

    public double getDouble(int index) {
        long temp = getLong(index);
        return Double.longBitsToDouble(temp);
    }

    public void setRef(int index, object ref) {
        localVars[index].ref = ref;
    }

    public object getRef(int index) {
        return localVars[index].ref;
    }

    public Slot[] getLocalVars() {
        return localVars;
    }

}
