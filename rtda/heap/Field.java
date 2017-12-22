package rtda.heap;

import classfile.ConstantValueAttribute;
import classfile.MemberInfo;

public class Field {

    ClassMember classMember;
    int constValueIndex;
    int slotId;

    public int getConstValueIndex() {
        return constValueIndex;
    }

    public void setConstValueIndex(int constValueIndex) {
        this.constValueIndex = constValueIndex;
    }

    public static Field[] newFields(Class thisclass, MemberInfo[] cfFields) {
        Field[] fields = new Field[cfFields.length];
        for (int i = 0; i < cfFields.length; i++) {
            fields[i] = new Field();
            fields[i].setClassMember(new ClassMember());
            fields[i].getClassMember().setThisclass(thisclass);
            fields[i].getClassMember().copyMember(cfFields[i]);
            fields[i].copyAttributes(cfFields[i]);
        }
        return fields;
    }

    private void copyAttributes(MemberInfo cfFidle) {
        ConstantValueAttribute cva = cfFidle.getConstantValueAttribute();
        if (null != cva) {
            this.constValueIndex = cva.getConstantValueIndex();
        }
    }

    public void setClassMember(ClassMember classMember) {
        this.classMember = classMember;
    }

    public ClassMember getClassMember() {
        return classMember;
    }


    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public boolean isLongOrDouble() {
        String descriptor = getClassMember().getDescriptor();
        return descriptor == "J" || descriptor == "D";
    }
}
