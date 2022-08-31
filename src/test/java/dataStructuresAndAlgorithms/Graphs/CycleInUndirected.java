package dataStructuresAndAlgorithms.Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class CycleInUndirected {
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

/*
        3
        3
        0 1
        1 2
        0 2
        0
*/
        // Write your code here
        boolean[] visited = new boolean[vertices];
        int[] parent = new int[vertices];

        // for disconnected graph
/*        for (int j = 0; j < vertices; j++) {
            if (!visited[j]) {
                boolean ans = isCyclicBFS(j, graph, visited, parent);
                if (ans == true) {
                    System.out.println("Yes");
                    break;
                }
            }else System.out.println("No");
        }*/

        // for connected graph
//        isCyclicBFS(source,graph,visited,parent);

        for (int j = 0; j < vertices; j++) {
            if (!visited[j]) {
                boolean ans = isCyclicDFS(j, -1, graph, visited);
                if (ans == true) {
                    System.out.println("Yes");
                    break;
                } else System.out.println("No");
            }
        }
    }

    public static boolean isCyclicBFS(int node, LinkedList<Edge>[] graph, boolean[] visited, int[] parent) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        parent[node] = -1;

        while (queue.size() > 0) {
            int vertex = queue.remove();

            for (Edge e : graph[vertex]) {
                if (visited[e.dest] == true && e.dest != parent[vertex]) {
                    return true;
                } else if (!visited[e.dest]) {
                    parent[e.dest] = vertex;
                    queue.add(e.dest);
                    visited[vertex] = true;
                }
            }
        }
        return false;
    }

    public static boolean isCyclicDFS(int node, int parent, LinkedList<Edge>[] graph, boolean[] visited) {
        visited[node] = true;

        for (Edge e : graph[node]) {
            if (!visited[e.dest]) {
                boolean ans = isCyclicDFS(e.dest, node, graph, visited);
                if (ans) {
                    return true;
                }
            } else if (e.dest != parent) {
                return true;
            }
        }
        return false;
    }
}
