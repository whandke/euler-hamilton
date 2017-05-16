import java.util.Random;

public class Graph {

    public int vertices;
    public int edges;
    public boolean[][] matrix;
    public List[] list;

    public Graph(int vertices) {
        edges = 0;
        this.vertices = vertices;
        matrix = new boolean[vertices][vertices];
        list = new List[vertices];
        for(int i = 0; i < vertices; i++){
            list[i] = new List();
            for(int j = 0; j < vertices; j++){
                matrix[i][j] = false;
            }
        }
    }

    public void addEdge(int a, int b){
        matrix[a][b] = true;
        matrix[b][a] = true;
        list[a].append(b);
        list[b].append(a);
        edges++;
    }

    public void displayList(){
        System.out.print("\n");
        for(int i = 0; i < vertices; i++){
            System.out.print(i);
            System.out.print(": ");
            list[i].print();
            System.out.print("\n");
        }
    }

    public double density(){
        double max = 0.5 * vertices * (vertices - 1);
        return edges/max;
    }

    public void generate(double density){
        int first, second = 0, third = 0;
        Random generator = new Random();
        List list = new List();

        //----- Generowanie cyklu

        for(int i = 0; i < vertices; i++){
            list.append(i);
        }

        list.shuffle();

        addEdge(list.index(0), list.index(list.size-1));
        for(int i = 0; i < vertices - 1; i++){
            addEdge(list.index(i), list.index(i+1));
        }

        //----- Dodawanie gęstości

        int counter = 1000;

        while(density() < density && counter > 0){



            first = generator.nextInt(vertices);
            counter++;
            do {
                if(counter == 0) break;
                second = generator.nextInt(vertices);
                counter--;
            } while(this.list[first].find(second) || this.list[second].find(first) || first == second);
            counter++;
            do {
                if(counter == 0) break;
                third = generator.nextInt(vertices);
                counter--;
            } while(this.list[second].find(third) || this.list[third].find(first) || this.list[third].find(second) || this.list[first].find(third) || second == third || first == third);
            if(counter > 0){
                addEdge(first, second);
                addEdge(second, third);
                addEdge(third, first);
            }
        }
    }

    public List[] copyList(){

        List[] resultList = new List[vertices];
        for(int i = 0; i < vertices; i++) {
            resultList[i] = new List();
            for(int j = 0; j < list[i].size; j++){
                int x = list[i].index(j);
                resultList[i].append(x);
            }
        }
        return resultList;
    }

}
