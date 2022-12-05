package dataStructuresAndAlgorithms.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

// Algorithm to find strongly connected components in a graph
public class KosarajuAlgorithm {
    static class Edge {
        int src;
        int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int vertices = Integer.parseInt(br.readLine());

        ArrayList<Edge>[] graph = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] edge = br.readLine().split(" ");
            int u = Integer.parseInt(edge[0]);
            int v = Integer.parseInt(edge[1]);

            graph[u].add(new Edge(u, v));
        }

        int source = Integer.parseInt(br.readLine());
        /*
        5
        5
        1 0
        0 2
        2 1
        0 3
        3 4
         */

        // Write your code here
        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();

        // For disconnected graph
        for (int i = 0; i < vertices; i++) {
            if (!visited[i])
                topologicalSortUsingDFS(i, graph, visited, stack);
        }

        // create a transpose graph
        ArrayList<Edge>[] transposeGraph = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            transposeGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < vertices; i++) {
            visited[i] = false;
            for (Edge e : graph[i]) {
                transposeGraph[e.dest].add(new Edge(e.dest, e.src));
            }
        }

        // dfs call using above ordering
        int count = 0;
        while (!stack.empty()) {
            int top = stack.pop();
            if (!visited[top]) {
                count++;
                revDFS(top, visited, transposeGraph);
            }
            System.out.println();
        }

        System.out.println("Total number of strongly connected components: " + count);
    }

    private static void revDFS(int node, boolean[] visited, ArrayList<Edge>[] transposeGraph) {
        visited[node] = true;
        System.out.print(node + " ");

        for (Edge e : transposeGraph[node]) {
            if (!visited[e.dest]) {
                revDFS(e.dest, visited, transposeGraph);
            }
        }
    }

    public static void topologicalSortUsingDFS(int node, ArrayList<Edge>[] graph, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;

        for (Edge e : graph[node]) {
            if (!visited[e.dest]) {
                topologicalSortUsingDFS(e.dest, graph, visited, stack);
            }
        }
        stack.add(node);
    }
}
