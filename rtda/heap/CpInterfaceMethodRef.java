package rtda.heap;

import classfile.ConstantMemberrefInfo;

import static rtda.heap.MethodLookup.lookupMethodInInterfaces;

public class CpInterfaceMethodRef extends CpMemberRef implements Constant {

    Method method;

    public CpInterfaceMethodRef(ConstantPool cp, classfile.ConstantInterfaceMethodrefInfo cimi) {
        this.cp = cp;
        ConstantMemberrefInfo cmi = (ConstantMemberrefInfo) cimi;
        copyMemberRefInfo(cmi);
    }

    public Method resolvedInterfaceMethod() {
        if (null == method) {
            return resolvedInterfaceMethodRef();
        }
        return method;
    }

    private Method resolvedInterfaceMethodRef() {
        Class d = getCp().getThisclass();
        Class c = resolvedClass();
        if (!c.isInterface()) {
            System.out.println("java.lang.IncompatibleClassChangeError");
        }

        Method method = lookupInterfaceMethod(c, this.name, this.descriptor);
        if (null == null) {
            System.out.println("java.lang.NoSuchMethodError");
        }
        if (!method.getClassMember().isAccessibleTo(d)) {
            System.out.println("java.lang.IllegaAccessError");
        }
        this.method = method;
        return this.method;
    }

    private Method lookupInterfaceMethod(Class iface, String name, String descriptor) {
        for (Method method : iface.getMethods()) {
            if (method.getClassMember().getName().equals(name) &&
                    method.getClassMember().getDescriptor().equals(descriptor)) {
                return method;
            }
        }
        return lookupMethodInInterfaces(iface.getInterfaces(), name, descriptor);
    }

}
