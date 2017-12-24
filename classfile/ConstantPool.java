package classfile;

public class ConstantPool {

    ConstantInfo[] constantInfos;
    int constantPoolCount;

    static ConstantPool readConstantPool(ClassReader reader) {
        ConstantPool cp = new ConstantPool();
        cp.constantPoolCount = reader.parseU2().getInt();
        cp.constantInfos = new ConstantInfo[cp.constantPoolCount];
        for (int i = 1; i < cp.constantPoolCount; i++) {
            cp.constantInfos[i] = cp.readConstantInfo(reader, cp);
            if(cp.constantInfos[i].tag.equals(ConstantInfo.TAG.CONSTANT_Double) ||
                    cp.constantInfos[i].equals(ConstantInfo.TAG.CONSTANT_Float)) {
                i++;
            }
        }
        return cp;
    }

    public int getConstantPoolCount() {
        return constantPoolCount;
    }

    public ConstantInfo[] getConstantInfos() {
        return constantInfos;
    }

    private ConstantInfo readConstantInfo(ClassReader reader, ConstantPool cp) {
        ConstantInfo.TAG tag = ConstantInfo.TAG.get(reader.parseU1().getInt());
        Info info = Info.newConstantInfo(tag, cp);
        info.readInfo(reader);
        return (ConstantInfo) info;
    }

    ConstantInfo getConstantInfo(JVMU2 index) {
        if (constantInfos[index.getInt()] != null) {
            return constantInfos[index.getInt()];
        }
        System.out.println("Invalid constant pool index");
        System.exit(0);
        return null;
    }

    ConstantInfo getConstantInfo(int index) {
        if(this.constantInfos[index] != null) {
            return this.constantInfos[index];
        }
        System.out.println("Invalid constant pool index");
        System.exit(0);
        return null;
    }

    String getName(JVMU2 index) {
        ConstantNameAndTypeInfo cati = (ConstantNameAndTypeInfo) getConstantInfo(index);
        return this.getUtf(cati.getName());
    }

    String getType(JVMU2 index) {
        ConstantNameAndTypeInfo cati = (ConstantNameAndTypeInfo) getConstantInfo(index);
        return this.getUtf(cati.getDescriptorIndex());
    }

    String getClassName(JVMU2 index) {
        if (index.getInt() == 0) {
            return "";
        }
        ConstantClassInfo cci = (ConstantClassInfo) getConstantInfo(index);
        return cci.getName();
    }

    String getUtf(JVMU2 index) {
        if (index.getInt() == 0) {
            return "";
        }
        ConstantUtf8Info cui = (ConstantUtf8Info)getConstantInfo(index);
        return cui.getString();
    }

    String getUtf(int index) {
        ConstantUtf8Info cui = (ConstantUtf8Info)getConstantInfo(index);
        return cui.getString();
    }

}
