public class Stack {
    public Node head;
    public int size;

    public void Stack(){
        this.size = 0;
        this. head = null;
    }

    public int first(){
        return head.getKey();
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
        while(true){
            System.out.print(node.getKey());
            System.out.print(" ");
            if(node.getNext() == null)
                return;
            node = node.getNext();
        }
    }

    public void print(){
        if(head != null)
            print(head);
    }
}
