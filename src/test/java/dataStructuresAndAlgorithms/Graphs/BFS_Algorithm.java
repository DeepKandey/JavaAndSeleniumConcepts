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
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);

        for (int i = 0; i < vertices; i++) {
            // To check if already visited
            if (!visited[i]) {
                queue.add(i);

                // BFS starting from ith node
                while (queue.size() > 0) {
                    int node = queue.remove();

                    if (visited[node]) {
                        continue;
                    } else {
                        visited[node] = true;
                        System.out.print(node + " ");
                    }

                    for (Edge e : graph[node]) {
                        if (!visited[e.dest]) {
                            queue.add(e.dest);
                        }
                    }
                }
                System.out.println();
            }
        }
    }
}