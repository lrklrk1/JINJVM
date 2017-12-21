package rtda.heap;

public class CpMemberRef extends CpSymref implements Constant{

    String name;
    String descriptor;

    public void copyMemberRefInfo(classfile.ConstantMemberrefInfo cmi) {
        this.className = cmi.getClassName();
        this.name = cmi.getName();
        this.descriptor = cmi.getType();
    }

}
