package instructions.extended;

import instructions.base.BytecodeReader;
import instructions.base.Instruction;
import instructions.loads.Dload;
import instructions.loads.Fload;
import instructions.loads.Iload;
import instructions.loads.Lload;
import instructions.math.Iinc;
import instructions.stores.Dstore;
import instructions.stores.Fstore;
import instructions.stores.Istore;
import instructions.stores.Lstore;
import rtda.Frame;

public class Wide {

    public class WIDE implements Instruction {

        Instruction modifiedInstruction;

        @Override
        public void fetchOperands(BytecodeReader reader) {
            int opcode = reader.parse1U();
            switch (opcode) {
                case 0x15:
                    Iload.ILOAD instIL = new Iload().new ILOAD();
                    instIL.setIndex(reader.parse2U());
                    modifiedInstruction = instIL;
                    break;
                case 0x16:
                    Lload.LLOAD instLL = new Lload().new LLOAD();
                    instLL.setIndex(reader.parse2U());
                    modifiedInstruction = instLL;
                    break;
                case 0x17:
                    Fload.FLOAD instFL = new Fload().new FLOAD();
                    instFL.setIndex(reader.parse2U());
                    modifiedInstruction = instFL;
                    break;
                case 0x18:
                    Dload.DLOAD instDL = new Dload().new DLOAD();
                    instDL.setIndex(reader.parse2U());
                    modifiedInstruction = instDL;
                    break;
                case 0x19:
//                    Aload.
                    break;
                case 0x36:
                    Istore.ISTORE instIS = new Istore().new ISTORE();
                    instIS.setIndex(reader.parse2U());
                    modifiedInstruction = instIS;
                    break;
                case 0x37:
                    Lstore.LSTORE instLS = new Lstore().new LSTORE();
                    instLS.setIndex(reader.parse2U());
                    modifiedInstruction = instLS;
                    break;
                case 0x38:
                    Fstore.FSTORE instFS = new Fstore().new FSTORE();
                    instFS.setIndex(reader.parse2U());
                    modifiedInstruction = instFS;
                    break;
                case 0x39:
                    Dstore.DSTORE instDS = new Dstore().new DSTORE();
                    instDS.setIndex(reader.parse2U());
                    modifiedInstruction = instDS;
                    break;
                case 0x3a:
//                    a
                    break;
                case 0x84:
                    Iinc.IINC instII = new Iinc().new IINC();
                    instII.setIndex(reader.parse2U());
                    instII.setCons(reader.parse2());
                    modifiedInstruction = instII;
                    break;
                case 0xa9:
                    System.out.println("unsupported! "  + 0xa9);
                    System.exit(0);
            }
        }

        @Override
        public void execute(Frame frame) {
            modifiedInstruction.execute(frame);
        }
    }
}
