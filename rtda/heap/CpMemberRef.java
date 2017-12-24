package rtda.heap;

public class CpMemberRef extends CpSymref implements Constant{

    String name;
    String descriptor;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
    }

    public void copyMemberRefInfo(classfile.ConstantMemberrefInfo cmi) {
        this.className = cmi.getClassName();
        this.name = cmi.getName();
        this.descriptor = cmi.getType();
    }

}
