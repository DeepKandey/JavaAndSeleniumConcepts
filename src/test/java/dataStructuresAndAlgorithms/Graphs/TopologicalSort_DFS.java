package dataStructuresAndAlgorithms.Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort_DFS {
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
        6
        6
        5 2
        4 0
        5 0
        4 1
        2 3
        3 1
        0
        4
         */

        // write your code here
        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();

        // For disconnected graph
        for (int i = 0; i < vertices; i++) {
            if (!visited[i])
                topologicalSortUsingDFS(i, graph, visited, stack);
        }

        System.out.println(stack);
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
