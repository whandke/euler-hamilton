import java.util.Random;

/**
 * Created by Wojciech Handke on 24.04.2017.
 */
public class List extends Stack {

    public void shuffle(){
        Random generator = new Random();
        int number, tmp;

        for(int i = 0; i < size; i++){
            number = generator.nextInt(size-1);
            tmp = index(number);
            delIndex(number);
            append(tmp);
        }
    }

    public boolean delIndex(int index){

        int prvSize = this.size;
        this.size--;

        if(index + 1 > prvSize){
            return false;
        }

        Node prvNode = null;
        Node node = head;

        if(index == 0){
            if(size == 1) {
                head = null;
                return true;
            }

            head = head.getNext();
            return true;
        }

        for(int i = 0; i < index; i++){
            prvNode = node;
            node = node.getNext();
        }

        if(index == prvSize-1){
            prvNode.setNext(null);
            return true;
        }
        prvNode.setNext(node.getNext());
        return true;

    }

    public boolean del(int key){

        this.size--;

        Node node = head;

        if(node.getKey() == key){
            if(node.getNext() == null){
                head = null;
            }
            else
                head = node.getNext();
            return true;
        }

        if(node.getNext() == null)
            return false;

        while(node.getNext().getKey() != key){
            if(node.getNext().getNext() == null){
                return false;
            }
            else
                node = node.getNext();
        }

        if(node.getNext().getNext() == null){
            node.setNext(null);
            return true;
        }
        node.setNext(node.getNext().getNext());
        return true;
    }

    public boolean find(int key){

        Node node = head;

        while(node.getKey() != key){
            if(node.getNext() == null)
                return false;
            else
                node = node.getNext();
        }
        return true;
    }

    private void append(Node node, int n){
        if(node.getNext() == null)
            node.setNext(new Node(n));
        else append(node.getNext(), n);
    }

    public void append(int n){

        if(head == null)
            head = new Node(n);
        else append(head, n);
        size++;
    }

    private int index(int index, Node node){
        if(index == 0)
            return node.getKey();
        else  return index(--index, node.getNext());
    }

    public int index3(int index){
        return index(index, head);
    }

    public int index(int index){

        int result;
        Node node = head;

        for(int i = 0; i < index; i++){
            node = node.getNext();
        }

        result = node.getKey();

        return result;
    }


}
