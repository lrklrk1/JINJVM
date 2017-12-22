package rtda.heap;


import classfile.*;

public class ConstantPool {

    public Class getThisclass() {
        return thisclass;
    }

    public void setThisclass(Class thisclass) {
        this.thisclass = thisclass;
    }

    Class thisclass;
    Constant[] constants;

    public Constant getConstant(int index) {
        if (index < constants.length && constants[index] != null) {
            System.out.println("No constants at " + index);
            System.exit(0);
        }
        return constants[index];
    }

    public ConstantPool(Class thisclass, int cpCount) {
        this.thisclass = thisclass;
        constants = new Constant[cpCount];
    }

    public static ConstantPool newConstantPool(Class thisclass, classfile.ConstantPool cfcp) {
        int cpCount = cfcp.getConstantPoolCount();
        ConstantPool cp = new ConstantPool(thisclass, cpCount);
        ConstantInfo[] ci = cfcp.getConstantInfos();
        for (int i = 0; i < cpCount; i++) {
            ConstantInfo cpinfo = ci[i];
            ConstantInfo.TAG tag = cpinfo.getTag();
            switch (tag) {
                case CONSTANT_Integer:
                    ConstantInfoInteger cii = (ConstantInfoInteger)cpinfo;
                    cp.constants[i] = new CpInteger(cii.getValue());
                    break;
                case CONSTANT_Long:
                    ConstantInfoLong cil = (ConstantInfoLong)cpinfo;
                    cp.constants[i] = new CpLong(cil.getValue());
                    i++;
                    break;
                case CONSTANT_Float:
                    ConstantInfoFloat cif = (ConstantInfoFloat)cpinfo;
                    cp.constants[i] = new CpFloat(cif.getValue());
                    break;
                case CONSTANT_Double:
                    ConstantInfoDouble cid = (ConstantInfoDouble)cpinfo;
                    cp.constants[i] = new CpDouble(cid.getValue());
                    i++;
                    break;
                case CONSTANT_Class:
                    ConstantClassInfo cci = (ConstantClassInfo)cpinfo;
                    cp.constants[i] = new CpClassRef(cp, cci);
                case CONSTANT_Fieldref:
                    ConstantFieldrefInfo cfi = (ConstantFieldrefInfo)cpinfo;
                    cp.constants[i] = new CpFieldRef(cp, cfi);
                case CONSTANT_Methodref:
                    ConstantMethodrefInfo cmi = (ConstantMethodrefInfo)cpinfo;
                    cp.constants[i] = new CpMethodRef(cp, cmi);
                case CONSTANT_InterfaceMethodref:
                    ConstantInterfaceMethodrefInfo cimi = (ConstantInterfaceMethodrefInfo)cpinfo;
                    cp.constants[i] = new CpInterfaceMethodRef(cp, cimi);
            }
        }

        return cp;
    }

}
