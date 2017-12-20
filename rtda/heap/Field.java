package rtda.heap;

import classfile.MemberInfo;

public class Field {

    ClassMember classMember;

    public Field[] newFields(Class thisclass, MemberInfo[] cfFields) {
        Field[] fields = new Field[cfFields.length];
        for (int i = 0; i < cfFields.length; i++) {
            fields[i] = new Field();
            fields[i].setClassMember(new ClassMember());
            fields[i].getClassMember().setThisclass(thisclass);
            fields[i].getClassMember().copyMember(cfFields[i]);
        }
        return fields;
    }

    public void setClassMember(ClassMember classMember) {
        this.classMember = classMember;
    }

    public ClassMember getClassMember() {
        return classMember;
    }
}
