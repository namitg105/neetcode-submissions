class MinStack {
    Stack s;
    public MinStack() {
        s = new Stack();
    }

    public void push(int val) {
        s.pushValue(val);
    }

    public void pop() {
        s.popValue();
    }

    public int top() {
        int top=s.getTop();
        return top;
    }

    public int getMin() {
    int min=    s.getMinValue();
    return min;
    }
}
class Node {
    int data;
    Node next;
}
class Stack {
    Node top;

    public void pushValue(int data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = top;
        top = newNode;
    }

    public void popValue() {
        Node temp = top;
        top = top.next;
    }

    public int getTop() {
        return top.data;
    }

    public int getMinValue() {
        Node temp = top;
        int min = top.data;
        while (temp.next != null) {
            temp = temp.next;
            if (min > temp.data) {
                min = temp.data;
            }
        }
        return min;
    }
}
