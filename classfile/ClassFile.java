package classfile;

public class ClassFile {

    private JVMU4           magic;
    private JVMU2           minorVersion;
    private JVMU2           majorVersion;
    private ConstantPool    constantPool;
    private JVMU2           accessFlag;
    private JVMU2           thisClass;
    private JVMU2           superClass;
    private JVMU2[]         interfaces;
    private MemberInfo[]    fields;
    private MemberInfo[]    methods;
    private AttributeInfo[] attributes;

    public static ClassFile parse(byte[] data) {
        ClassFile cf = new ClassFile();
        try {
            ClassReader reader = new ClassReader(data);
            cf.reader(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cf;
    }

    private void reader(ClassReader reader) {
        this.readAndCheckMagic(reader);
        this.readAndCheckVersion(reader);
        this.constantPool = this.readConstantPool(reader);
        this.accessFlag = reader.parseU2();
        this.thisClass = reader.parseU2();
        this.superClass = reader.parseU2();
        this.interfaces = reader.parseU2s();
        this.fields = this.readMembers(reader);
        this.methods = this.readMembers(reader);
        this.attributes = Attribute.readAttributes(reader, this.constantPool);
    }




    private void readAndCheckMagic(ClassReader reader) {
        this.magic = reader.parseU4();
        if (!String.format("%02x", magic.u4[0]).equals("ca") ||
                !String.format("%02x", magic.u4[1]).equals("fe") ||
                !String.format("%02x", magic.u4[2]).equals("ba") ||
                !String.format("%02x", magic.u4[3]).equals("be")) {
        } else {
            System.out.print(String.format("%02x", magic.u4[0]));
            System.out.print(String.format("%02x", magic.u4[1]));
            System.out.print(String.format("%02x", magic.u4[2]));
            System.out.println(String.format("%02x", magic.u4[3]));
        }
    }

    private void readAndCheckVersion(ClassReader reader) {
        this.minorVersion = reader.parseU2();
        this.majorVersion = reader.parseU2();
        switch (majorVersion.u2[1]) {
            case 45:
//                System.out.println(majorVersion.u2[1] + " " + minorVersion.u2[1]);
                return;
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
//                if(minorVersion.u2[0] == 0) {
//                    System.out.println(majorVersion.u2[1] + minorVersion.u2[1]);
//                    return;
//                }
                return;
            default:
                System.out.println("wrong version number");
                System.out.println(majorVersion.u2[1] + " " + minorVersion.u2[1]);
                System.exit(1);
        }
    }

    private ConstantPool readConstantPool(ClassReader reader) {
        ConstantPool cp = ConstantPool.readConstantPool(reader);
//        for(ConstantInfo con : cp.constantInfos) {
//            System.out.println(con);
//        }
        return cp;
    }

    private MemberInfo[] readMembers(ClassReader reader) {
        JVMU2 memberCount = reader.parseU2();
        MemberInfo[] members = new MemberInfo[memberCount.getInt()];
        for (int i=0; i < members.length; i++) {
            members[i] = readMember(reader);
        }
        return members;
    }

    private MemberInfo readMember(ClassReader reader) {
        MemberInfo memberInfo = new MemberInfo(this.constantPool,
                                                reader.parseU2(),
                                                reader.parseU2(),
                                                reader.parseU2(),
                                                Attribute.readAttributes(reader, this.constantPool));
        return memberInfo;
    }

    public JVMU2 getMinorVersion() {
        return this.minorVersion;
    }

    public JVMU2 getMajorVersion() {
        return this.majorVersion;
    }

    public ConstantPool getConstantPool() {
        return this.constantPool;
    }

    public String getAccessFlag() {
        return this.accessFlag.toString();
    }

    public MemberInfo[] getFields() {
        return this.fields;
    }

    public MemberInfo[] getMethods() {
        return this.methods;
    }

    public String getThisClassName() {
        return this.constantPool.getClassName(this.thisClass);
    }

    public String getSuperClassName() {
        return this.constantPool.getClassName(this.superClass);
    }

    public String[] getInterface() {
        String[] interfaces = new String[this.interfaces.length];
        for (int i=0; i < interfaces.length; i++) {
            interfaces[i] = this.constantPool.getClassName(this.interfaces[i]);
        }
        return interfaces;
    }

    public String getInterfaceCount() {
        return this.interfaces.length + "";
    }

    public AttributeInfo[] getAttributes() {
        return this.attributes;
    }
}
