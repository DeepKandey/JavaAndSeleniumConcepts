package dataStructuresAndAlgorithms.Graphs;

import java.util.ArrayList;
import java.util.Arrays;

// Find the shortest path

public class BellmanFordAlgorithm {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        ArrayList<Integer> first = new ArrayList<>();
        first.add(0);
        first.add(1);
        first.add(9);

        edges.add(first);

        System.out.println(Arrays.toString(bellmanFord(2, 0, 1, edges)));
//        System.out.println(Arrays.deepToString(new int[][]{{1, 2}, {3, 4}, {5, 6}}));
    }

    public static int[] bellmanFord(int n, int src, int dest, ArrayList<ArrayList<Integer>> edges) {

        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[src] = 0;

        // n-1 times
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < edges.size(); j++) {
                // traverse on edge list
                int u = edges.get(j).get(0);
                int v = edges.get(j).get(1);
                int wt = edges.get(j).get(2);

                if (dist[u] != Integer.MAX_VALUE && (dist[u] + wt) < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }

        // check for negative cycle
        boolean flag = false;

        for (int j = 0; j < edges.size(); j++) {
            // traverse on edge list
            int u = edges.get(j).get(0);
            int v = edges.get(j).get(1);
            int wt = edges.get(j).get(2);

            if (dist[u] != Integer.MAX_VALUE && (dist[u] + wt) < dist[v]) {
                flag = true;
                break;
            }
        }

        if (!flag) {
            System.out.println("Shortest distance from source to destination is : " + dist[dest]);
            return dist;
        }
        return null;
    }
}
