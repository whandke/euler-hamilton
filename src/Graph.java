/**
 * Created by Wojciech Handke on 15.05.2017.
 */
public class Graph {

    public int vertices;
    public boolean[][] matrix;
    public List[] list;

    public Graph(int vertices) {
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







}
