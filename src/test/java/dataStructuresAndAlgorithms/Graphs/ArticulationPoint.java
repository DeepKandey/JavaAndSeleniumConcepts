package dataStructuresAndAlgorithms.Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ArticulationPoint {
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
            graph[v].add(new Edge(v, u));
        }
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
        int timer = 0;
        int[] disc = new int[vertices];
        int[] low = new int[vertices];
        int parent = -1;
        boolean[] visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            disc[i] = -1;
            low[i] = -1;
        }

        // dfs
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                dfs(i, parent, timer, disc, low, graph, visited);
            }
        }
    }

    static void dfs(int node, int parent, int timer, int[] disc, int[] low, ArrayList<Edge>[] graph, boolean[] visited) {
        int children = 0;
        visited[node] = true;

        disc[node] = low[node] = timer++;

        for (Edge edge : graph[node]) {
            if (edge.dest == parent) {
                continue;
            } else if (!visited[edge.dest]) {
                children++;
                dfs(edge.dest, node, timer, disc, low, graph, visited);
                low[node] = Math.min(low[node], low[edge.dest]);
                // check edge is bridge
                if (low[edge.dest] >= disc[node] && parent != -1) {
                    System.out.print(node + " ");
                }
            } else {
                // back edge
                low[node] = Math.min(low[node], disc[edge.dest]);
            }
        }
        if (parent == -1 && children > 1) {
            System.out.print(node + " ");
        }
    }
}
