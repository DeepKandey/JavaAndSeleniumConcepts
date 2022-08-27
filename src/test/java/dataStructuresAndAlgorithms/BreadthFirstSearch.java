package dataStructuresAndAlgorithms;

import java.util.Iterator;
// Java program to print BFS traversal from a given source vertex.
// BFS(int s) traverses vertices reachable from s.
import java.util.LinkedList;

public class BreadthFirstSearch {

  private int v; // no. of vertices
  private LinkedList<Integer> adj[]; // Adjacency List

  @SuppressWarnings("unchecked")
  public BreadthFirstSearch(int v) {
    this.v = v;
    adj = new LinkedList[v];
    for (int i = 0; i < v; i++) {
      adj[i] = new LinkedList<>();
    }
  }

  // Function to add an edge into the graph
  void addEdge(int v, int w) {
    adj[v].add(w);
  }

  // prints BFS traversal from a given source s
  void BFS(int s) {

    // Mark all the vertices as not visited
    boolean visited[] = new boolean[v];

    // Create a queue for BFS
    LinkedList<Integer> queue = new LinkedList<>();

    // Mark the current node as visited and enqueue it
    visited[s] = true;
    System.out.println("Starting at " + s);
    queue.add(s);

    while (queue.size() != 0) {
      // Dequeue a vertex from queue and print it
      s = queue.poll();
      System.out.println("Dequeuing " + s);

      // Get all adjacent vertices of the dequeued vertex s
      // If an adjacent has not been visited, then mark it
      // visited and enqueue it
      Iterator<Integer> i = adj[s].listIterator();
      while (i.hasNext()) {
        int n = i.next();
        if (!visited[n]) {
          visited[n] = true;
          System.out.println("Queueing " + n);
          queue.add(n);
        }
      }
    }
  }

  // Driver method
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    BreadthFirstSearch obj = new BreadthFirstSearch(4);
    obj.addEdge(0, 1);
    obj.addEdge(0, 2);
    obj.addEdge(1, 2);
    obj.addEdge(2, 0);
    obj.addEdge(2, 3);
    obj.addEdge(3, 3);

    System.out.println("Following is Breadth First Traversal" + "(starting from vertext (2)");
    obj.BFS(2);
  }
}
