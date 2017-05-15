public class Stack {
    public Node head;
    public int size;

    public void Stack(){
        this.size = 0;
        this. head = null;
    }

    public int size(){
        return size;
    }

    public void add(int n){
        if(head == null)
            head = new Node(n);
        else {
            Node newHead = new Node(n);
            newHead.setNext(head);
            head = newHead;
        }
        size++;
    }

    public int pop(){
        int value = head.getKey();

        head = head.getNext();
        size--;
        return value;
    }


    private void print(Node node){
        System.out.print(node.getKey());
        System.out.print(" ");
        if(node.getNext() != null)
            print(node.getNext());
    }

    public void print(){
        if(head != null)
            print(head);
    }
}
