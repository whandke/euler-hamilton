
public class Main {

    public static void main (String args[]){

        int vertices = 10000;

        Graph graph = new Graph(vertices);
        Timer timer = new Timer();
        timer.start();
        graph.generate(0.1);
        timer.stop();
        timer.print();
        System.out.print("\n");

        //graph.displayList();

        System.out.println(graph.density());

    }


}
