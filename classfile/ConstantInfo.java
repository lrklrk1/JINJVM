package classfile;

import java.util.HashMap;

public class ConstantInfo {

//    JVMU1[] info;
    TAG   tag;


    public enum TAG {
        CONSTANT_Class(7),
        CONSTANT_Fieldref(9),
        CONSTANT_Methodref(10),
        CONSTANT_InterfaceMethodref(11),
        CONSTANT_String(8),
        CONSTANT_Integer(3),
        CONSTANT_Float(4),
        CONSTANT_Long(5),
        CONSTANT_Double(6),
        CONSTANT_NameAndType(12),
        CONSTANT_Utf8(1),
        CONSTANT_MethodHandle(15),
        CONSTANT_MethodType(16),
        CONSTANT_InvokeDynamic(18);

        static HashMap<Integer, TAG> tags = new HashMap<Integer, TAG>();

        static {
            for (TAG tag : values()) {
                tags.put(tag.type, tag);
            }
        }

        int type;

        TAG(int t) {
            this.type = t;
        }

        public static TAG get(int index) {
            return tags.get(index);
        }

    }

}
