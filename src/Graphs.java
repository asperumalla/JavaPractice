import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Graphs {

    public static void main(String[] args) {
        int components;

/*        List<Integer>[] edges = new List[]{
                Arrays.asList( 1,4),
                Arrays.asList( 1,5),
                Arrays.asList( 5,6),
                Arrays.asList( 2,3)
        };*/
        int[][] edges = {
                {1,4},
                {1,5},
                {5,6},
                {2,3},
                {6,3}
        };
        size = 6;
        components = findConnectedComponents(size,edges );
    }

    private static int size;
    private static int[] visited ;
    private static List<Integer>[] adjList;

    private static int findConnectedComponents(int size ,int[][] edges) {
        visited = new int[size+1];
        Arrays.fill(visited,-1);

        adjList =  buildGraph(size,edges);

        //run outer loop
        int components = 0;
        for(int v= 1; v<=size; v++){
            if(visited[v] == -1){
                components++;
                dfs(v);
            }
        }


        System.out.println("Number of connected componets:"+components);

        IntStream.range(0,size+1).forEach( i ->  System.out.println(i +"-->"+adjList[i]));
        return 0;
    }

    private static boolean bfs(){
        return false;
    }

    private static boolean dfs(int src){
        visited[src] = 1;

        for(  int neighbour : adjList[src]){
            if(visited[neighbour] == -1){
                dfs(neighbour);
            }
        }

        return true;
    }

    private static List<Integer>[] buildGraph(int size,int[][] edges) {

        List<Integer>[] adlist =  new List[size+1];
        for(int i=0; i <= size; i++){
            adlist[i] = new ArrayList<>();
        }

        for(  int[] v: edges ){
            adlist[ v[0]].add(v[1]);
            adlist[ v[1]].add(v[0]);
        }

        return adlist;
    }
}
