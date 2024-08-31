import java.util.*;


public class graphUnDirectCycleDetect {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    // Method to create the graph using adjacency list representation
    public static void createGraph(ArrayList<Edge>[] graph) {
        // Initialize each element of the graph array
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Adding edges to the graph
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 4));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 4));

        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 2));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 4));
    }

    public static boolean isCycleDirected(ArrayList<Edge> graph[], boolean vis[], int curr, int par){//par= parent
        vis[curr]= true;

        for(int i=0; i<graph[curr].size();i++){
            Edge e= graph[curr].get(i);
            if (!vis[e.dest] && e.dest!=par) {
                return true;
            }else if(!vis[e.dest]){
                if (isCycleDirected(graph, vis, e.dest, curr)) {
                    return true; 
                }
            }
        }
        return false;
    }

    // Main method
    public static void main(String[] args) {
        int V = 6;  // Number of vertices

        // Create the graph as an array of ArrayLists
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        System.out.println(isCycleDirected(graph, new boolean[V], 0, -1));
        
    }
}
