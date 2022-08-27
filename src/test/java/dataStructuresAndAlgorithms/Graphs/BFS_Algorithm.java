package dataStructuresAndAlgorithms.Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_Algorithm {
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
            String[] pair = br.readLine().split(" ");
            int u = Integer.parseInt(pair[0]);
            int v = Integer.parseInt(pair[1]);

            graph[u].add(new Edge(u, v));
        }

        int source = Integer.parseInt(br.readLine());
        /*
        4
        7
        0 1
        0 2
        1 2
        2 0
        2 3
        3 3
        4 5
        2
         */

        // write your code here
        boolean[] visited = new boolean[vertices];

/*
        For disconnected graph
        for (int i = 0; i < vertices; i++) {
            // To check if already visited
            if (!visited[i]) {
                bfsForDisconnectedGraph(i, visited, graph);
                System.out.println();
            }
        }
*/

        // For connected graph
        bfs(source, visited, graph);
    }

    public static void bfs(int node, boolean[] visited, LinkedList<Edge>[] graph) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);

        while (queue.size() > 0) {
            int vertex = queue.remove();

            if (visited[vertex]) {
                continue;
            } else {
                visited[vertex] = true;
                System.out.print(vertex + " ");
            }

            for (Edge e : graph[vertex]) {
                if (!visited[e.dest]) {
                    queue.add(e.dest);
                }
            }
        }
    }
}