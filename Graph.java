import java.util.*;

public class Graph {

    private Map<Integer, List<Integer>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    public void addVertex(int vertex) {
        adjacencyList.put(vertex, new ArrayList<>());
    }


    public void addEdge(int source, int destination) {
        if (!adjacencyList.containsKey(source)) {
            addVertex(source);
        }
        if (!adjacencyList.containsKey(destination)) {
            addVertex(destination);
        }
        adjacencyList.get(source).add(destination);
        //For undirected graph uncomment the below line. For directed graph, keep it commented.
        //adjacencyList.get(destination).add(source); 
    }

    public void DFS(int startVertex) {
        Set<Integer> visited = new HashSet<>();
        dfsRecursive(startVertex, visited);
    }

    private void dfsRecursive(int vertex, Set<Integer> visited) {
        visited.add(vertex);
        System.out.print(vertex + " ");

        for (int neighbor : adjacencyList.getOrDefault(vertex, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfsRecursive(neighbor, visited);
            }
        }
    }

    public void BFS(int startVertex) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(startVertex);
        queue.offer(startVertex);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            for (int neighbor : adjacencyList.getOrDefault(vertex, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
    }


    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);

        System.out.println("DFS traversal starting from vertex 0:");
        graph.DFS(0); // Output should be something like: 0 1 2 3 4 (order may vary slightly for DFS)
        System.out.println("\n");

        System.out.println("BFS traversal starting from vertex 0:");
        graph.BFS(0); //Output should be: 0 1 2 3 4 (order is consistent for BFS)
        System.out.println("\n");


    }
}
