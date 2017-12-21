package rtda.heap;


import classfile.*;

public class ConstantPool {

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

    public ConstantPool newConstantPool(Class thisclass, classfile.ConstantPool cfcp) {
        int cpCount = cfcp.getConstantPoolCount();
        ConstantPool cp = new ConstantPool(thisclass, cpCount);
        ConstantInfo[] ci = cfcp.getConstantInfos();
        for (int i = 0; i < cpCount; i++) {
            ConstantInfo cpinfo = ci[i];
            ConstantInfo.TAG tag = cpinfo.getTag();
            switch (tag) {
                case CONSTANT_Integer:
                    ConstantInfoInteger cii = (ConstantInfoInteger)cpinfo;
                    constants[i] = new CpInteger(cii.getValue());
                    break;
                case CONSTANT_Long:
                    ConstantInfoLong cil = (ConstantInfoLong)cpinfo;
                    constants[i] = new CpLong(cil.getValue());
                    i++;
                    break;
                case CONSTANT_Float:
                    ConstantInfoFloat cif = (ConstantInfoFloat)cpinfo;
                    constants[i] = new CpFloat(cif.getValue());
                    break;
                case CONSTANT_Double:
                    ConstantInfoDouble cid = (ConstantInfoDouble)cpinfo;
                    constants[i] = new CpDouble(cid.getValue());
                    i++;
                    break;
                case CONSTANT_Class:
                    ConstantClassInfo cci = (ConstantClassInfo)cpinfo;
                    constants[i] = new CpClassRef(this, cci);

            }
        }

        return cp;
    }

}
