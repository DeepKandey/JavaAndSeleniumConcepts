package dataStructuresAndAlgorithms.Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class DFS_Algorithm {

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

        int source = Integer.parseInt(br.readLine());

        // Write your code here
        boolean[] visited = new boolean[vertices];

        /* For disconnected graph
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                ArrayList<Integer> component = new ArrayList<>();
                dfs(i, graph, component, visited);
                ans.add(component);
            }
        }

        System.out.println(Arrays.deepToString(ans.toArray()));
*/
        dfs(source, graph, visited); // For connected graph
    }


    public static void dfs(int node, ArrayList<Edge>[] graph, ArrayList<Integer> component, boolean[] visited) {
        visited[node] = true;
        component.add(node);

        for (Edge e : graph[node]) {
            if (!visited[e.dest]) {
                dfs(e.dest, graph, component, visited);
            }
        }
    }

    public static void dfs(int node, ArrayList<Edge>[] graph, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");

        for (Edge e : graph[node]) {
            if (!visited[e.dest]) {
                dfs(e.dest, graph, visited);
            }
        }
    }
}
