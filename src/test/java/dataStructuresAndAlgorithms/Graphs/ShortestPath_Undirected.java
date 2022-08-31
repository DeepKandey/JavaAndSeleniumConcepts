package dataStructuresAndAlgorithms.Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ShortestPath_Undirected {
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

        LinkedList<Edge>[] graph = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            graph[i] = new LinkedList<>();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] edge = br.readLine().split(" ");
            int u = Integer.parseInt(edge[0]);
            int v = Integer.parseInt(edge[1]);

            graph[u].add(new Edge(u, v));
            graph[v].add(new Edge(v, u));
        }
        int source = Integer.parseInt(br.readLine());
        int destination = Integer.parseInt(br.readLine());

        // Write your code here
        shortestPath_BFS(vertices, source, destination, graph);
    }

    public static void shortestPath_BFS(int vertices, int src, int dest, LinkedList<Edge>[] graph) {
        boolean[] visited = new boolean[vertices];
        int[] parent = new int[vertices];
        visited[src] = true;
        parent[src] = -1;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);

        while (queue.size() > 0) {
            int front = queue.remove();

            for (Edge e : graph[front]) {
                if (!visited[e.dest]) {
                    visited[e.dest] = true;
                    parent[e.dest] = front;
                    queue.add(e.dest);
                }
            }
        }

        ArrayList<Integer> path = new ArrayList<>();
        int currentNode = dest;
        path.add(dest);
        while (!(currentNode == src)) {
            currentNode = parent[currentNode];
            path.add(currentNode);
        }

        Collections.reverse(path);
        System.out.println("Shortest path from " + src + " to " + dest + " is : " + path);
    }
}
