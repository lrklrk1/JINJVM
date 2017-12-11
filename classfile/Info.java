package classfile;

public interface Info {

    void readInfo(ClassReader reader);

    static Info newConstantInfo(ConstantInfo.TAG tag, ConstantPool cp) {
        switch (tag) {
            case CONSTANT_Integer:
                return new ConstantInfoInteger();
            case CONSTANT_Float:
                return new ConstantInfoFloat();
            case CONSTANT_Long:
                return new ConstantInfoLong();
            case CONSTANT_Double:
                return new ConstantInfoDouble();
            case CONSTANT_Utf8:
                return new ConstantUtf8Info();
            case CONSTANT_String:
                return new ConstantInfoString(cp);
            case CONSTANT_Class:
                return new ConstantClassInfo(cp);
            case CONSTANT_Fieldref:
                return (ConstantFieldrefInfo) new ConstantMemberrefInfo(cp);
            case CONSTANT_Methodref:
                return (ConstantMethodrefInfo) new ConstantMemberrefInfo(cp);
            case CONSTANT_InterfaceMethodref:
                return (ConstantInterfaceMethodrefInfo) new ConstantMemberrefInfo(cp);
            case CONSTANT_MethodType:
                return new ConstantMethodTypeInfo();
            case CONSTANT_NameAndType:
                return new ConstantNameAndTypeInfo();
            case CONSTANT_MethodHandle:
                return new ConstantMethodHandleInfo();
            case CONSTANT_InvokeDynamic:
                return new ConstantInvokeDynamicInfo();
            default:
                System.out.println("java.lang.ClassFormatError: constant pool tag!" + tag);
                System.exit(1);
        }
        return null;
    }
}
