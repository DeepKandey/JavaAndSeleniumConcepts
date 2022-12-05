package dataStructuresAndAlgorithms.graphs;

import java.util.ArrayList;
import java.util.Collections;

public class KruskalAlgorithm {

    static class Edge implements Comparable<Edge> {
        int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    private static int findParent(int u, int[] parent) {
        if (u == parent[u]) return u;
        return parent[u] = findParent(parent[u], parent);
    }

    private static void union(int u, int v, int[] parent, int[] rank) {
        u = findParent(u, parent);
        v = findParent(v, parent);

        if (rank[u] < rank[v]) {
            parent[u] = v;
        } else if (rank[u] > rank[v]) {
            parent[v] = u;
        } else {
            parent[v] = u;
            rank[u]++;
        }
    }

    private static void kruskalAlgo(ArrayList<Edge> adj, int vertices) {
        Collections.sort(adj);
        int[] parent = new int[vertices];
        int[] rank = new int[vertices];

        for (int i = 0; i < vertices; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        int costMst = 0;
        ArrayList<Edge> mst = new ArrayList<>();
        for (Edge edge : adj) {
            if (findParent(edge.src, parent) != findParent(edge.dest, parent)) {
                costMst += edge.weight;
                mst.add(edge);
                union(edge.src, edge.dest, parent, rank);
            }
        }
        System.out.println(costMst);
        for (Edge edge : mst) {
            System.out.println(edge.src + " - " + edge.dest + " with weight " + edge.weight);
        }
    }

    public static void main(String[] args) {

        /* Let us create following weighted graph
                 10
            0--------1
            |  \     |
           6|   5\   |15
            |      \ |
            2--------3
                4       */

        int vertices = 5;
        ArrayList<Edge> graph = new ArrayList<>();
        graph.add(new Edge(0, 1, 2));
        graph.add(new Edge(0, 3, 6));
        graph.add(new Edge(1, 3, 8));
        graph.add(new Edge(1, 2, 3));
        graph.add(new Edge(1, 4, 5));
        graph.add(new Edge(2, 4, 7));

        kruskalAlgo(graph, vertices);
    }
}

