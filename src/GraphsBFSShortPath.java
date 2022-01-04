import java.util.*;
import java.util.stream.IntStream;

/* Base Graph approach in BFS
*
* APPROACH :
* First count the parent length at every step
* Add 1 to each vertex
* When you find the target vertex --> You  have reached the final ans
*
*
* */
public class GraphsBFSShortPath {
    public static void main(String[] args) {
        int[][] edges = {
                {1,2},
                //{1,3},
                {2,3},
                {3,4},
                //{2,4}
        };
        System.out.println(shortestpath(4,edges));
    }

    private static int[] visited;
    private static List<Integer>[] adjList;
    private static int[] parentLength;

    private static int shortestpath(int vertices, int[][] edges) {
        visited = new int[vertices+1]; //increment the size to 1 for convinience
        parentLength = new int[vertices+1]; //increment the size to 1 for convinience
        Arrays.fill(visited,-1);
        Arrays.fill(parentLength,-1);

        adjList = buildGraph(vertices,edges);
        for(int v=1; v<=vertices; v++){ //increment the size to 1 for convinience
            if(visited[v] == -1){
                bfs(v);
            }
        }

        System.out.println("Lenght of each node:\n");
        IntStream.range(1,vertices+1).forEach(i -> System.out.println(i + " --> " + parentLength[i]));

        return 0;
    }

    private static void bfs(int src) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(src);
        visited[src] = 1;
        parentLength[src] = 0;

        while( !queue.isEmpty()){
            System.out.println(queue);
            int node = queue.poll();
            for( int neighbor: adjList[node]){
                if( visited[neighbor] == -1){
                    visited[neighbor] = 1;
                    parentLength[neighbor] = 1+ parentLength[node];
                    queue.add(neighbor);
                }
            }
        }

    }


    private static List<Integer>[] buildGraph(int vertices, int[][] edges) {
        List<Integer>[] adjList = new List[vertices+1]; // increment the size to 1 for convinience

        for (int i=0; i<= vertices; i++){ //increment the size to 1 for convinience
            adjList[i] = new ArrayList<>();
        }

        for (int[] v: edges){
            adjList[v[0]].add( v[1]  );
            adjList[v[1]].add( v[0]  );
        }
        return adjList;
    }
}
