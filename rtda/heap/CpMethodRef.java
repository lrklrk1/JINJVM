package rtda.heap;

import static rtda.heap.MethodLookup.lookupMethodInClass;
import static rtda.heap.MethodLookup.lookupMethodInInterfaces;

public class CpMethodRef extends CpMemberRef {

    Method method;

    public CpMethodRef(ConstantPool cp, classfile.ConstantMethodrefInfo cmei) {
        this.cp = cp;
        classfile.ConstantMemberrefInfo cmi = (classfile.ConstantMemberrefInfo) cmei;
        copyMemberRefInfo(cmi);
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Method resolveMethod() {
        if (null == this.method) {
            return resolveMethodRef();
        }
        return this.method;
    }

    private Method resolveMethodRef() {
        Class d = getCp().getThisclass();
        Class c = resolvedClass();
        if (c.isInterface()) {
            System.out.println("java.lang.IncompatibleChangeError");
        }

        Method method = lookUpMethod(c, name, descriptor);
        if (null == method) {
            System.out.println("java.lang.NoSuchMethodError");
        }
        if (!method.getClassMember().isAccessibleTo(d)) {
            System.out.println("java.lang.IllegaAcesssError");
        }
        this.method = method;
        return this.method;
    }

    private Method lookUpMethod(Class c, String name, String descriptor) {
        Method method = lookupMethodInClass(c, name, descriptor);
        if (null == method) {
            method = lookupMethodInInterfaces(c.getInterfaces(), name, descriptor);
        }
        return method;
    }


}
