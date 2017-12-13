package classfile;

public class ConstantPool {

    ConstantInfo[] constantInfos;
    int constantPoolCount;

    static ConstantPool readConstantPool(ClassReader reader) {
        ConstantPool cp = new ConstantPool();
        cp.constantPoolCount = reader.parseU2().getInt();
        cp.constantInfos = new ConstantInfo[cp.constantPoolCount - 1];
        for (int i = 0; i < cp.constantPoolCount - 1; i++) {
            cp.constantInfos[i] = cp.readConstantInfo(reader, cp);
            if(cp.constantInfos[i].tag.equals(ConstantInfo.TAG.CONSTANT_Double) ||
                    cp.constantInfos[i].equals(ConstantInfo.TAG.CONSTANT_Float)) {
                i++;
            }
        }
        return cp;
    }

    private ConstantInfo readConstantInfo(ClassReader reader, ConstantPool cp) {
        ConstantInfo.TAG tag = ConstantInfo.TAG.get(reader.parseU1().getInt());
        Info info = Info.newConstantInfo(tag, cp);
        info.readInfo(reader);
        return (ConstantInfo) info;
    }

    ConstantInfo getConstantInfo(JVMU2 index) {
        if (this.constantInfos[index.getInt()] != null) {
            return this.constantInfos[index.getInt()];
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
        ConstantNameAndTypeInfo cati = (ConstantNameAndTypeInfo) this.getConstantInfo(index);
        return this.getUtf(cati.getName());
    }

    String getType(JVMU2 index) {
        ConstantNameAndTypeInfo cati = (ConstantNameAndTypeInfo) this.getConstantInfo(index);
        return this.getUtf(cati.getDescriptorIndex());
    }

    String getClassName(JVMU2 index) {
        ConstantClassInfo cci = (ConstantClassInfo) this.getConstantInfo(index);
        return cci.getName();
    }

    String getUtf(JVMU2 index) {
        ConstantUtf8Info cui = (ConstantUtf8Info)this.getConstantInfo(index);
        return cui.getString();
    }

    String getUtf(int index) {
        ConstantUtf8Info cui = (ConstantUtf8Info)this.getConstantInfo(index);
        return cui.getString();
    }

}
