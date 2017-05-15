public class Node {
    int key;
    Node next;

    public Node(int key) {
        this.key = key;
        this.next = null;
    }

    public Node getNext() {
        return next;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
