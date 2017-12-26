package classfile;

public class SourceFileAttribute implements AttributeInfo {

    ConstantPool cp;
    int sourceFileIndex;

    @Override
    public void readInfo(ClassReader reader) {
        sourceFileIndex = reader.parseU2().getInt();
    }

    public SourceFileAttribute(ConstantPool cp) {
        this.cp = cp;
    }

    public String getFileName() {
        return cp.getUtf(sourceFileIndex);
    }
}
