package classfile;

public class ExceptionAttribute implements Attribute {

    JVMU2[] exceptionIndexTable;

    @Override
    public void readInfo(ClassReader reader) {
        this.exceptionIndexTable = reader.parseU2s();
    }

    public JVMU2[] getExceptionIndexTable() {
        return exceptionIndexTable;
    }
}
