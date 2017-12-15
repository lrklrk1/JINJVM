package rtda;

public class Stack {

    int maxSize;
    int size;
    Frame top;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
    }

    void push(Frame frame) {
        if (size >= maxSize) {
            System.out.println("java.lang.StackOverflowError");
        }
        if (top != null) {
            frame.lower = top;
        }
        top = frame;
        size++;
    }

    Frame pop() {
        if (top == null) {
            System.out.println("jvm stack is empty");
        }
        Frame temp = top;
        top = top.lower;
        temp.lower = null;
        size--;
        return temp;
    }

    Frame top() {
        if (top == null) {
            System.out.println("jvm stack is empty");
        }
        return top;
    }

}
