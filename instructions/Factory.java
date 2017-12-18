package instructions;

import instructions.base.Instruction;
import instructions.constants.Const;
import instructions.constants.Ipush;
import instructions.constants.Nop;
import instructions.loads.*;
import instructions.stack.Dup;
import instructions.stack.Pop;
import instructions.stack.Swap;
import instructions.stores.*;

public class Factory {

    public static Instruction newInstruction(int opcode) {
        switch(opcode) {
            case 0x00: return new Nop().new NOP();
            case 0x01:
                return new Const().new ACONST_NULL();
            case 0x02:
                return new Const().new ICONST_M1();
            case 0x03:
                return new Const().new ICONST_0();
            case 0x04:
                return new Const().new ICONST_1();
            case 0x05:
                return new Const().new ICONST_2();
            case 0x06:
                return new Const().new ICONST_3();
            case 0x07:
                return new Const().new ICONST_4();
            case 0x08:
                return new Const().new ICONST_5();
            case 0x09:
                return new Const().new LCONST_0();
            case 0x0a:
                return new Const().new LCONST_1();
            case 0x0b:
                return new Const().new FCONST_0();
            case 0x0c:
                return new Const().new FCONST_1();
            case 0x0d:
                return new Const().new FCONST_2();
            case 0x0e:
                return new Const().new DCONST_0();
            case 0x0f:
                return new Const().new DCONST_1();
            case 0x10:
                return new Ipush().new BIPUSH();
            case 0x11:
                return new Ipush().new SIPUSH();
            // case 0x12:
            // 	return &LDC{}
            // case 0x13:
            // 	return &LDC_W{}
            // case 0x14:
            // 	return &LDC2_W{}
            case 0x15:
                return new Iload().new ILOAD();
            case 0x16:
                return new Lload().new LLOAD();
            case 0x17:
                return new Fload().new FLOAD();
            case 0x18:
                return new Dload().new DLOAD();
            case 0x19:
                return new Aload().new ALOAD();
            case 0x1a:
                return new Iload().new ILOAD_0();
            case 0x1b:
                return new Iload().new ILOAD_1();
            case 0x1c:
                return new Iload().new ILOAD_2();
            case 0x1d:
                return new Iload().new ILOAD_3();
            case 0x1e:
                return new Lload().new LLOAD_0();
            case 0x1f:
                return new Lload().new LLOAD_1();
            case 0x20:
                return new Lload().new LLOAD_2();
            case 0x21:
                return new Lload().new LLOAD_3();
            case 0x22:
                return new Fload().new FLOAD_0();
            case 0x23:
                return new Fload().new FLOAD_1();
            case 0x24:
                return new Fload().new FLOAD_2();
            case 0x25:
                return new Fload().new FLOAD_3();
            case 0x26:
                return new Dload().new DLOAD_0();
            case 0x27:
                return new Dload().new DLOAD_1();
            case 0x28:
                return new Dload().new DLOAD_2();
            case 0x29:
                return new Dload().new DLOAD_3();
            case 0x2a:
                return new Aload().new ALOAD_0();
            case 0x2b:
                return new Aload().new ALOAD_1();
            case 0x2c:
                return new Aload().new ALOAD_2();
            case 0x2d:
                return new Aload().new ALOAD_3();
            // case 0x2e:
            // 	return iaload
            // case 0x2f:
            // 	return laload
            // case 0x30:
            // 	return faload
            // case 0x31:
            // 	return daload
            // case 0x32:
            // 	return aaload
            // case 0x33:
            // 	return baload
            // case 0x34:
            // 	return caload
            // case 0x35:
            // 	return saload
            case 0x36:
                return new Istore().new ISTORE();
            case 0x37:
                return new Lstore().new LSTORE();
            case 0x38:
                return new Fstore().new FSTORE();
            case 0x39:
                return new Dstore().new DSTORE();
            case 0x3a:
                return new Astore().new ASTORE();
            case 0x3b:
                return new Istore().new ISTORE_0();
            case 0x3c:
                return new Istore().new ISTORE_1();
            case 0x3d:
                return new Istore().new ISTORE_2();
            case 0x3e:
                return new Istore().new ISTORE_3();
            case 0x3f:
                return new Lstore().new LSTORE_0();
            case 0x40:
                return new Lstore().new LSTORE_1();
            case 0x41:
                return new Lstore().new LSTORE_2();
            case 0x42:
                return new Lstore().new LSTORE_3();
            case 0x43:
                return new Fstore().new FSTORE_0();
            case 0x44:
                return new Fstore().new FSTORE_1();
            case 0x45:
                return new Fstore().new FSTORE_2();
            case 0x46:
                return new Fstore().new FSTORE_3();
            case 0x47:
                return new Dstore().new DSTORE_0();
            case 0x48:
                return new Dstore().new DSTORE_1();
            case 0x49:
                return new Dstore().new DSTORE_2();
            case 0x4a:
                return new Dstore().new DSTORE_3();
            case 0x4b:
                return new Astore().new ASTORE_0();
            case 0x4c:
                return new Astore().new ASTORE_1();
            case 0x4d:
                return new Astore().new ASTORE_2();
            case 0x4e:
                return new Astore().new ASTORE_3();
            // case 0x4f:
            // 	return iastore
            // case 0x50:
            // 	return lastore
            // case 0x51:
            // 	return fastore
            // case 0x52:
            // 	return dastore
            // case 0x53:
            // 	return aastore
            // case 0x54:
            // 	return bastore
            // case 0x55:
            // 	return castore
            // case 0x56:
            // 	return sastore
            case 0x57:
                return new Pop().new POP();
            case 0x58:
                return new Pop().new POP2();
            case 0x59:
                return new Dup().new DUP();
            case 0x5a:
                return new Dup().new DUP_X1();
            case 0x5b:
                return new Dup().new DUP_X2();
            case 0x5c:
                return new Dup().new DUP2();
            case 0x5d:
                return new Dup().new DUP2_X1();
            case 0x5e:
                return new Dup().new DUP2_X2();
            case 0x5f:
                return new Swap().new SWAP();
            case 0x60:
                return new
            case 0x61:
                return ladd
            case 0x62:
                return fadd
            case 0x63:
                return dadd
            case 0x64:
                return isub
            case 0x65:
                return lsub
            case 0x66:
                return fsub
            case 0x67:
                return dsub
            case 0x68:
                return imul
            case 0x69:
                return lmul
            case 0x6a:
                return fmul
            case 0x6b:
                return dmul
            case 0x6c:
                return idiv
            case 0x6d:
                return ldiv
            case 0x6e:
                return fdiv
            case 0x6f:
                return ddiv
            case 0x70:
                return irem
            case 0x71:
                return lrem
            case 0x72:
                return frem
            case 0x73:
                return drem
            case 0x74:
                return ineg
            case 0x75:
                return lneg
            case 0x76:
                return fneg
            case 0x77:
                return dneg
            case 0x78:
                return ishl
            case 0x79:
                return lshl
            case 0x7a:
                return ishr
            case 0x7b:
                return lshr
            case 0x7c:
                return iushr
            case 0x7d:
                return lushr
            case 0x7e:
                return iand
            case 0x7f:
                return land
            case 0x80:
                return ior
            case 0x81:
                return lor
            case 0x82:
                return ixor
            case 0x83:
                return lxor
            case 0x84:
                return &IINC{}
            case 0x85:
                return i2l
            case 0x86:
                return i2f
            case 0x87:
                return i2d
            case 0x88:
                return l2i
            case 0x89:
                return l2f
            case 0x8a:
                return l2d
            case 0x8b:
                return f2i
            case 0x8c:
                return f2l
            case 0x8d:
                return f2d
            case 0x8e:
                return d2i
            case 0x8f:
                return d2l
            case 0x90:
                return d2f
            case 0x91:
                return i2b
            case 0x92:
                return i2c
            case 0x93:
                return i2s
            case 0x94:
                return lcmp
            case 0x95:
                return fcmpl
            case 0x96:
                return fcmpg
            case 0x97:
                return dcmpl
            case 0x98:
                return dcmpg
            case 0x99:
                return &IFEQ{}
            case 0x9a:
                return &IFNE{}
            case 0x9b:
                return &IFLT{}
            case 0x9c:
                return &IFGE{}
            case 0x9d:
                return &IFGT{}
            case 0x9e:
                return &IFLE{}
            case 0x9f:
                return &IF_ICMPEQ{}
            case 0xa0:
                return &IF_ICMPNE{}
            case 0xa1:
                return &IF_ICMPLT{}
            case 0xa2:
                return &IF_ICMPGE{}
            case 0xa3:
                return &IF_ICMPGT{}
            case 0xa4:
                return &IF_ICMPLE{}
            case 0xa5:
                return &IF_ACMPEQ{}
            case 0xa6:
                return &IF_ACMPNE{}
            case 0xa7:
                return &GOTO{}
            // case 0xa8:
            // 	return &JSR{}
            // case 0xa9:
            // 	return &RET{}
            case 0xaa:
                return &TABLE_SWITCH{}
            case 0xab:
                return &LOOKUP_SWITCH{}
            // case 0xac:
            // 	return ireturn
            // case 0xad:
            // 	return lreturn
            // case 0xae:
            // 	return freturn
            // case 0xaf:
            // 	return dreturn
            // case 0xb0:
            // 	return areturn
            // case 0xb1:
            // 	return _return
            //	case 0xb2:
            //		return &GET_STATIC{}
            // case 0xb3:
            // 	return &PUT_STATIC{}
            // case 0xb4:
            // 	return &GET_FIELD{}
            // case 0xb5:
            // 	return &PUT_FIELD{}
            //	case 0xb6:
            //		return &INVOKE_VIRTUAL{}
            // case 0xb7:
            // 	return &INVOKE_SPECIAL{}
            // case 0xb8:
            // 	return &INVOKE_STATIC{}
            // case 0xb9:
            // 	return &INVOKE_INTERFACE{}
            // case 0xba:
            // 	return &INVOKE_DYNAMIC{}
            // case 0xbb:
            // 	return &NEW{}
            // case 0xbc:
            // 	return &NEW_ARRAY{}
            // case 0xbd:
            // 	return &ANEW_ARRAY{}
            // case 0xbe:
            // 	return arraylength
            // case 0xbf:
            // 	return athrow
            // case 0xc0:
            // 	return &CHECK_CAST{}
            // case 0xc1:
            // 	return &INSTANCE_OF{}
            // case 0xc2:
            // 	return monitorenter
            // case 0xc3:
            // 	return monitorexit
            case 0xc4:
                return &WIDE{}
            // case 0xc5:
            // 	return &MULTI_ANEW_ARRAY{}
            case 0xc6:
                return &IFNULL{}
            case 0xc7:
                return &IFNONNULL{}
            case 0xc8:
                return &GOTO_W{}
            // case 0xc9:
            // 	return &JSR_W{}
            // case 0xca: breakpoint
            // case 0xfe: impdep1
            // case 0xff: impdep2
            default:
                panic(fmt.Errorf("Unsupported opcode: 0x%x!", opcode))
        }
        }
        System.exit(0);
        return null;
    }

}
