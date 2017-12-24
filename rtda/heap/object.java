package rtda.heap;

import rtda.LocalVars;
import rtda.Slot;

public class object {

    Class thisClas;
    LocalVars fields;

    public object(Class thisClass) {
        this.thisClas = thisClass;
        this.fields = new LocalVars(thisClass.getInstancesSlotCount());
        for (Slot slot : fields.getLocalVars()) {
            slot = new Slot();
        }
    }

    public Class getThisClas() {
        return thisClas;
    }

    public void setThisClas(Class thisClas) {
        this.thisClas = thisClas;
    }

    public LocalVars getFields() {
        return fields;
    }

    public void setFields(LocalVars fields) {
        this.fields = fields;
    }

    public boolean isInstanceOf(Class thisClass) {
        return thisClass.isAssignableFrom(this.getThisClas());
    }
}
