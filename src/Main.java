
public class Main {

    public static void main (String args[]){

        int vertices = 5000;

        Graph graph = new Graph(vertices);

        graph.generate(0.6);

        List[] list = graph.copyList();

        System.out.println("Obliczanie cyklu Eulera...");

        Timer timer = new Timer();


        timer.start();
        Algorithms.euler(list);
        timer.stop();
        System.out.print("Czas obliczen: ");
        timer.print();

        timer.start();
        boolean abc = Algorithms.hamiltonSingle(graph.copyList());
        timer.stop();
        System.out.print("\nWystapienie cyklu Hamiltona: ");
        System.out.print(abc);
        System.out.print("\nCzas obliczen: ");
        timer.print();

        /*

        timer.start();
        int result = Algorithms.hamiltonAll(graph.copyList());
        timer.stop();
        System.out.print("\nIlosc cykli Hamiltona: ");
        System.out.print(result);
        System.out.print("\nCzas obliczen: ");
        timer.print();

        */



    }


}
