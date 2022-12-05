package dataStructuresAndAlgorithms.graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ShortestPath_DirectedWeighted {
    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vertices = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
        }

        int src = Integer.parseInt(br.readLine());

        /*
        6
        9
        0 1 5
        0 2 3
        1 3 6
        1 2 2
        2 4 4
        2 5 2
        2 3 7
        3 4 -1
        4 5 -2
        1
         */

        // Write your code here
        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();

        // First step - create topological sort
        for (int i = 0; i < vertices; i++) {
            if (!visited[i])
                topologicalSort_DFS(i, graph, visited, stack);
        }

        // 2nd step - create distance array
        int[] distance = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        // Find the shortest distance
        shortestPath(src, graph, stack, distance);

        // Print the distance array
        System.out.println(Arrays.toString(distance));
    }

    public static void topologicalSort_DFS(int node, ArrayList<Edge>[] graph, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;

        for (Edge e : graph[node]) {
            if (!visited[e.nbr]) {
                topologicalSort_DFS(e.nbr, graph, visited, stack);
            }
        }
        stack.add(node);
    }

    public static void shortestPath(int node, ArrayList<Edge>[] graph, Stack<Integer> stack, int[] distance) {
        distance[node] = 0;

        while (!stack.empty()) {
            int vertex = stack.pop();

            if (distance[vertex] != Integer.MAX_VALUE) {
                for (Edge e : graph[vertex]) {
                    if (distance[e.nbr] > (distance[vertex] + e.wt)) {
                        distance[e.nbr] = distance[vertex] + e.wt;
                    }
                }
            }
        }
    }
}
