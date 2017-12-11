package classfile;

public class ConstantPool {

    ConstantInfo[] constantInfos;
    int constantPoolCount;

    static ConstantPool readConstantPool(ClassReader reader) {
        ConstantPool cp = new ConstantPool();
        cp.constantPoolCount = reader.parseU2().getInt();
        cp.constantInfos = new ConstantInfo[cp.constantPoolCount];
        for (int i = 0; i < cp.constantPoolCount; i++) {
            cp.constantInfos[i] = cp.readConstantInfo(reader, cp);
            if(cp.constantInfos[i].tag.equals(ConstantInfo.TAG.CONSTANT_Double) ||
                    cp.constantInfos[i].equals(ConstantInfo.TAG.CONSTANT_Float)) {
                i++;
            }
        }
        return cp;
    }

    private ConstantInfo readConstantInfo(ClassReader reader, ConstantPool cp) {
        ConstantInfo.TAG tag = ConstantInfo.TAG.get(reader.parseU2().getInt());
        Info info = Info.newConstantInfo(tag, cp);
        info.readInfo(reader);
        return (ConstantInfo) info;
    }

    ConstantInfo getConstantInfo(JVMU2 index) {
        if (this.constantInfos[index.getInt()] != null) {
            return this.constantInfos[index.getInt()];
        }
        System.out.println("Invalid constant pool index");
        return null;
    }

    String getName(JVMU2 index) {

        return null;
    }

    String getType(JVMU2 index) {
        return null;
    }

    String getClassName(JVMU2 index) {
        return null;
    }

    String getUtf(JVMU2 index) {
        return null;
    }

}
