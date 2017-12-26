package rtda.heap;

import classfile.LocalVariableTableAttribute;
import rtda.LocalVars;

import java.util.HashMap;
import java.util.Map;

public class ClassLoader {

    classpath.Classpath classpath;
    Map<String, Class> classMap;
    boolean verboseFlag;

    public ClassLoader(classpath.Classpath classpath, boolean verboseFlag) {
        this.classpath = classpath;
        this.verboseFlag = verboseFlag;
        this.classMap = new HashMap<String, Class>();
    }

    public Class loadClass(String name) {
        if (classMap.containsKey(name)) {
            return classMap.get(name);
        }
        return loadNoArrayClass(name);
    }

    private Class loadNoArrayClass(String name) {
        byte[] data = readClass(name);
        Class thisclass = defineClass(data);
        link(thisclass);
        System.out.println("Load class " + name);
        return thisclass;
    }

    private byte[] readClass(String name) {
        byte[] data = classpath.readClass(name);
        if (null == data) {
            System.out.println("java.lang.ClassNotFoundException: " + name);
        }
        return data;
    }

    private Class defineClass(byte[] data) {
        Class thisClass = parseClass(data);
        thisClass.setLoader(this);
        resolveSuperClass(thisClass);
        resolveInterfaces(thisClass);
        classMap.put(thisClass.getThisClassName(), thisClass);
        return thisClass;
    }

    private Class parseClass(byte[] data) {
        classfile.ClassFile cf = classfile.ClassFile.parse(data);
        return new Class(cf);
    }

    private void resolveSuperClass(Class thisClass) {
        if (!thisClass.getThisClassName().equals("java/lang/Object")) {
            String superClassName = thisClass.getSuperClassName();
            ClassLoader cl = thisClass.getLoader();
            thisClass.setSuperClass(cl.loadClass(superClassName));
        }
    }

    private void resolveInterfaces(Class thisClass) {
        String[] InterfaceNames = thisClass.getInterfaceNames();
        int interfaceCount = InterfaceNames.length;
        if (0 == interfaceCount) {
            return;
        }
        thisClass.setInterfaces(new Class[interfaceCount]);
        ClassLoader cl = thisClass.getLoader();
        for (int i = 0; i < interfaceCount; i++) {
            if (InterfaceNames[i] == null || InterfaceNames[i].equals("")) {
                continue;
            }
            thisClass.getInterfaces()[i] = cl.loadClass(InterfaceNames[i]);
        }
    }

    private void link(Class thisClass) {
//        verify(thisClass);
        prepar(thisClass);
    }

    private void prepar(Class thisClass) {
        calcInstanceFieldSlotIds(thisClass);
        calcStaticFieldSlotIds(thisClass);
        allocAndInitStaticVars(thisClass);
    }

    private void calcInstanceFieldSlotIds(Class thisClass) {
        int slotId = 0;
        if (null != thisClass.getSuperClass()) {
            slotId = thisClass.getSuperClass().getInstancesSlotCount();
        }
        for (Field field : thisClass.getFields()) {
            if (!field.getClassMember().isStatic()) {
                field.setSlotId(slotId);
                slotId++;
                if (field.isLongOrDouble()) {
                    slotId++;
                }
            }
        }
        thisClass.setInstancesSlotCount(slotId);
    }

    private void calcStaticFieldSlotIds(Class thisClass) {
        int soltId = 0;
        for (Field field : thisClass.getFields()) {
            if (field.getClassMember().isStatic()) {
                field.setSlotId(soltId);
                soltId++;
                if (field.isLongOrDouble()) {
                    soltId++;
                }
            }
        }
        thisClass.setStaticSlotCount(soltId);
    }

    private void allocAndInitStaticVars(Class thisClass) {
        thisClass.setStaticVars(new LocalVars(thisClass.getStaticSlotCount()));
        for (Field field : thisClass.getFields()) {
            if (field.getClassMember().isStatic() && field.getClassMember().isFinal()) {
                initStaticFinalVar(thisClass, field);
            }
        }
    }

    private void initStaticFinalVar(Class thisClass, Field field) {
        LocalVars vars = thisClass.getStaticVars();
        ConstantPool cp = thisClass.getConstantPool();
        int cpIndex = field.getConstValueIndex();
        int slotId = field.getSlotId();

        if (cpIndex > 0) {
            switch (field.getClassMember().getDescriptor()) {
                case "Z":
                case "B":
                case "C":
                case "S":
                case "I":
                    CpInteger ci = (CpInteger)cp.getConstant(cpIndex);
                    vars.setInt(slotId, ci.getValue());
                    break;
                case "J":
                    CpLong cl = (CpLong)cp.getConstant(cpIndex);
                    vars.setLong(slotId, cl.getValue());
                    break;
                case "F":
                    CpFloat cf = (CpFloat)cp.getConstant(cpIndex);
                    vars.setFloat(slotId, cf.getValue());
                    break;
                case "D":
                    CpDouble cd = (CpDouble)cp.getConstant(cpIndex);
                    vars.setDouble(slotId, cd.getValue());
                    break;
                case "Ljava/lang/String":
//                    TODO
                    break;

            }
        }
    }


}
