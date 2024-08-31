import java.util.*;


public class graphCycleDirected {
    static class Edge {
        int src;
        int dest;
        
        public Edge(int s, int d){
            this.src= s;
            this.dest= d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length;i++){
            graph[i]= new ArrayList<>();
        }

        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 2));

    }

    public static boolean isCycleDirected(ArrayList<Edge> graph[], boolean vis[], int curr, boolean rec[]){
        vis[curr]= true;
        rec[curr]= true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e= graph[curr].get(i);
            if (rec[e.dest]) {//cycle
                return true;
            }else if(!vis[e.dest]){
                if(isCycleDirected(graph, vis, e.dest, rec)){
                    return true;
                }
            }
        }
        rec[curr]= false;
        return false;
    }
    public static void main(String[] args) {
        int V= 7;
        
        ArrayList<Edge> grapgh[]= new ArrayList[V];
        createGraph(grapgh);

        boolean vis[]= new boolean[V];
        boolean rec[]= new boolean[V];
        for(int i=0; i<V; i++){
            if(!vis[i]){
                boolean isCycle= isCycleDirected(grapgh, vis, 0,  rec);
                if (isCycle) {
                    System.out.println(isCycle);
                    break;
                }
            }
        }
        
    }
}
/*
 * Topological Sorting
Directed Acyclic Graph(DAG is a directed graph with no cycles.
Topological sorting is used only for DAGS (not for non-DAGs)
It is a linear order of vertices such that every directed edge u -> v,
the vertex u comes before v in the order.

*/
