import java.util.*;

public class graphTopologicalSort {

    // Edge class representing a directed edge from src to dest
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
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    // Utility function for topological sorting
    public static void topSortUtility(ArrayList<Edge>[] graph, int curr, boolean[] vis, Stack<Integer> stack) {
        vis[curr] = true;

        // Recursively visit all the vertices adjacent to this vertex
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                topSortUtility(graph, e.dest, vis, stack);
            }
        }
        // Push the current vertex to the stack after visiting its adjacent vertices
        stack.push(curr);
    }

    // Main method to perform topological sort
    public static void topSort(ArrayList<Edge>[] graph, int V) {
        boolean[] vis = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        // Call the recursive helper function to store Topological Sort starting from all vertices one by one
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                topSortUtility(graph, i, vis, stack);
            }
        }

        // Print the elements of the stack to get the topological order
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    // Main method
    public static void main(String[] args) {
        int V = 6;  // Number of vertices

        // Create the graph as an array of ArrayLists
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        // Perform topological sort and print the result
        topSort(graph, V);
    }
}
