package dataStructuresAndAlgorithms.Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CycleInDirected {

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
        7
        6
        0 1
        1 2
        2 3
        4 5
        5 6
        6 4
        0
         */
        // Write your code here
        boolean[] visited = new boolean[vertices];
        boolean[] dfsVisited = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                boolean ans = isCyclicDFS(i, graph, visited, dfsVisited);
                if (ans) {
                    System.out.println("Yes");
                }
            }
        }
    }

    public static boolean isCyclicDFS(int node, ArrayList<Edge>[] graph, boolean[] visited, boolean[] dfsVisited) {
        visited[node] = true;
        dfsVisited[node] = true;

        for (Edge e : graph[node]) {
            if (!visited[e.dest]) {
                boolean ans = isCyclicDFS(e.dest, graph, visited, dfsVisited);
                if (ans) {
                    return true;
                }
            } else if (dfsVisited[e.dest]) {
                return true;
            }
        }
        dfsVisited[node] = true;
        return false;
    }
}
