package rtda.heap;

public class MethodLookup {


    public static Method lookupMethodInClass(Class pClass, String name, String descriptor) {
        for (Class c = pClass; null != c; c = c.getSuperClass()) {
            for (Method m : c.getMethods()) {
                if(m.getClassMember().getName().equals(name) &&
                        m.getClassMember().getDescriptor().equals(descriptor)) {
                    return m;
                }
            }
        }
        return null;
    }

    public static Method lookupMethodInInterfaces(Class[] ifaces, String name, String descriptor) {
        for (Class iface : ifaces) {
            for (Method m : iface.getMethods()) {
                if (m.getClassMember().getName().equals(name) &&
                        m.getClassMember().getDescriptor().equals(descriptor)) {
                    return m;
                }
            }
            Method method = lookupMethodInInterfaces(iface.getInterfaces(), name, descriptor);
            if (null != method) {
                return method;
            }
        }
        return null;
    }

}
