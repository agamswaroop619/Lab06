import java.util.*;

// Graph class
class Graph {
    private int V;
    private List<List<Integer>> adj;
    public Graph(int V) {
        this.V = V;
        adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    // Function to add an edge to the graph
    public void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    // Depth-First Search
    public void DFS(int start) {
        // Visited set to keep track of visited nodes
        Set<Integer> visited = new HashSet<>();

        // Stack for DFS traversal
        Stack<Integer> stack = new Stack<>();

        // Push the start node onto the stack
        stack.push(start);

        // Loop until stack is empty
        while (!stack.empty()) {
            // Get the top element from the stack
            int current = stack.pop();

            // If current node has not been visited
            if (!visited.contains(current)) {
                // Mark current node as visited
                visited.add(current);
                System.out.print(current + " ");

                // Visit all adjacent vertices of current node
                for (int adjacent : adj.get(current)) {
                    // If adjacent vertex is not visited, push it onto the stack
                    if (!visited.contains(adjacent)) {
                        stack.push(adjacent);
                    }
                }
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a graph with 4 vertices
        Graph g = new Graph(4);
        Scanner in= new Scanner(System.in);
        // Add edges
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        System.out.println("Enter Vertex to start DFS Traversal");
        int n= in.nextInt();
        System.out.print("Depth First Traversal: ");
        g.DFS(n); // Start DFS from vertex 2
        System.out.println();
    }
}
