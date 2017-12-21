package rtda.heap;

public class CpClassRef extends CpSymref implements Constant {

    public CpClassRef(ConstantPool cp, classfile.ConstantClassInfo cci) {
        this.cp = cp;
        this.className = cci.getName();
    }

}
