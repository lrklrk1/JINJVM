package rtda.heap;

public class CpFieldRef extends CpMemberRef {

    Field field;

    public CpFieldRef(ConstantPool cp, classfile.ConstantFieldrefInfo cfi) {
        this.cp = cp;
        classfile.ConstantMemberrefInfo cmi = (classfile.ConstantMemberrefInfo) cfi;
        copyMemberRefInfo(cmi);
    }

    public Field resolvedField() {
        if (null == field) {
            resolvedFieldRef();
        }
        return field;
    }

    private void resolvedFieldRef() {
        Class d = this.cp.getThisclass();
        Class c = resolvedClass();
        Field field = lookUpField(c, this.name, this.descriptor);

        if (null == field) {
            System.out.println("java.lang.NoSuchFieldError");
            System.exit(0);
        }
        if (!field.getClassMember().isAccessibleTo(d)) {
            System.out.println("java.lang.IllegalAccessError");
            System.exit(0);
        }
        this.field = field;
    }

    private Field lookUpField(Class c, String name, String descriptor) {
        for (Field field : c.getFields()) {
            if (name.equals(field.getClassMember().getName())
                    && descriptor.equals(field.getClassMember().getDescriptor())) {
                return field;
            }
        }
        for (Class iface : c.getInterfaces()) {
            Field field = lookUpField(iface, name, descriptor);
            if (null != field) {
                return field;
            }
        }
        if (null != c.getSuperClass()) {
            return lookUpField(c.getSuperClass(), name, descriptor);
        }
        return null;
    }

}
