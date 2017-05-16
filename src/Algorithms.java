
public class Algorithms {

    public static void euler(List[] list){
        Stack lifo = new Stack();
        List eulerCycle = new List();

        lifo.add(0);

        euler(list, lifo, eulerCycle, 0);

        eulerCycle.append(0);
    }

    private static void euler(List[] list, Stack lifo, List eulerCycle, int vertex){

        int a, b;

        while(true){
            if(list[vertex].size == 0){
                if(lifo.size == 1)
                    break;
                int current = lifo.pop();
                eulerCycle.append(current);
                vertex = lifo.first();
            }
            else{
                a = vertex;
                b = list[vertex].index(0);
                list[a].del(b);
                list[b].del(a);
                lifo.add(b);
                vertex = b;
            }
        }
    }

    public static int hamiltonAll(List[] list){
        List visited = new List();
        int result = hamiltonAll(list, visited, 0);
        return result;
    }

    private static int hamiltonAll(List[] list, List visited, int vertex){
        int result = 0;
        int counter = 0;
        visited.add(vertex);
        List nonVisited = new List();

        for(int i = 0; i < list[vertex].size; i++){
            if(!visited.find(list[vertex].index(i))){
                nonVisited.append(list[vertex].index(i));
                counter++;
            }
        }

        if(counter == 0){
            if(list[vertex].find(0)){
                visited.del(vertex);
                return 1;
            }
        }
        else {
            for(int i = 0; i < nonVisited.size; i++){
                result += hamiltonAll(list,visited,nonVisited.index(i));
            }
        }
        visited.del(vertex);
        return result;
    }

    public static boolean hamiltonSingle(List[] list){
        List visited = new List();
        return hamiltonSingle(list, visited, 0);
    }

    private static boolean hamiltonSingle(List[] list, List visited, int vertex){
        int counter = 0;
        visited.add(vertex);
        List nonVisited = new List();

        for(int i = 0; i < list[vertex].size; i++){
            if(!visited.find(list[vertex].index(i))){
                nonVisited.append(list[vertex].index(i));
                counter++;
            }
        }

        if(counter == 0){
            if(list[vertex].find(0)){
                visited.del(vertex);
                return true;
            }
        }
        else {
            for(int i = 0; i < nonVisited.size; i++){
                if(hamiltonSingle(list,visited,nonVisited.index(i))) return true;
            }
        }
        visited.del(vertex);
        return false;
    }



}
