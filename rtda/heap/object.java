package rtda.heap;

import rtda.LocalVars;

public class object {

    Class thisClas;
    LocalVars fields;

    public object(Class thisClass) {
        this.thisClas = thisClass;
        this.fields = new LocalVars(thisClass.getInstancesSlotCount());
    }

}
