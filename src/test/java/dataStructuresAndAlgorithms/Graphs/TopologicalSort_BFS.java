package dataStructuresAndAlgorithms.Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort_BFS {
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
        topologicalSortUsingBFS(vertices, graph);
    }

    public static void topologicalSortUsingBFS(int vertices, ArrayList<Edge>[] graph) {

        // Find all in degrees
        int[] in_degree = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            for (Edge edge : graph[i]) {
                in_degree[edge.dest]++;
            }
        }

        // Push nodes in queue having in-degree 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < vertices; i++) {
            if (in_degree[i] == 0) {
                queue.add(i);
            }
        }

        // do bfs
        while (queue.size() > 0) {
            int front = queue.remove();

            System.out.print(front + " ");

            // neighbour in-degree update
            for (Edge e : graph[front]) {
                in_degree[e.dest]--;
                if (in_degree[e.dest] == 0) {
                    queue.add(e.dest);
                }
            }
        }
    }
}
