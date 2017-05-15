
public class Main {

    public static void main (String args[]){


        List list = new List();
        for(int i = 0; i < 10; i++){
            list.append(i);
        }

        list.shuffle();

        Graph graph = new Graph(10);
        list.print();
        graph.addEdge(list.index(0), list.index(list.size-1));
        for(int i = 0; i < 9; i++){
            graph.addEdge(list.index(i), list.index(i+1));
        }

        graph.displayList();

    }


}
