package dataStructuresAndAlgorithms.graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgorithm {
    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vertices = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        int src = Integer.parseInt(br.readLine());
        /*
        5
        6
        0 1 9
        0 2 6
        0 3 5
        0 4 3
        2 1 2
        2 3 4
        0
         */

        // Write your code here
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, -1, 0));

        boolean[] visited = new boolean[vertices];

        System.out.println("Edge" + " \t " + "Weight");

        while (pq.size() > 0) {
            Pair pair = pq.remove();

            if (visited[pair.v] == true) {
                continue;
            }
            visited[pair.v] = true;

            if (pair.av != -1) {
                System.out.println(pair.v + " <-> " + pair.av + " - " + pair.wt);
            }

            for (Edge e : graph[pair.v]) {
                if (visited[e.nbr] == false) {
                    pq.add(new Pair(e.nbr, pair.v, e.wt));
                }
            }
        }
    }

    private static class Pair implements Comparable<Pair> {
        int v;
        int av;
        int wt;

        Pair(int v, int av, int wt) {
            this.v = v;
            this.av = av;
            this.wt = wt;
        }

        @Override
        public int compareTo(Pair o) {
            return this.wt - o.wt;
        }
    }
}
