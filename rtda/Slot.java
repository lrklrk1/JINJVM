package rtda;

import rtda.heap.object;

public class Slot {

    int num;
    object ref;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public object getRef() {

        return ref;
    }

    public void setRef(object ref) {
        this.ref = ref;
    }
}
