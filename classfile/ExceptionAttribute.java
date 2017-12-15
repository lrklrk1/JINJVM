package classfile;

public class ExceptionAttribute implements AttributeInfo {

    JVMU2[] exceptionIndexTable;

    @Override
    public void readInfo(ClassReader reader) {
        exceptionIndexTable = reader.parseU2s();
    }

    public JVMU2[] getExceptionIndexTable() {
        return exceptionIndexTable;
    }
}
