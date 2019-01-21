package dataStructuresAndAlgorithms;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

// Java Program to print DFS traversal from a given graph
public class DepthFirstTraversal {

	private int V; // no. of vertices

	// Array of lists for adjacency list representation
	LinkedList<Integer> adj[];

	// Constructor
	@SuppressWarnings("unchecked")
	public DepthFirstTraversal(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	// Function to add an edge to the graph
	void addEdge(int v, int w) {
		adj[v].add(w); // Add w to v's list
	}

	// Print DFS from a given source s
	void DFS(int v) {

		// Mark all the vertices as not visited
		boolean visited[] = new boolean[V];
		
		// Create a stack for DFS
		Stack<Integer> stack = new Stack<Integer>();
		// Mark the current node as visited and push it
		stack.push(v);
		visited[v] = true;

		while (!stack.isEmpty()) {
			int current = stack.pop();
			System.out.println(current + " ");

			Iterator<Integer> iterator = adj[current].listIterator();
			while (iterator.hasNext()) {
				int n = iterator.next();
				if (!visited[n]) {
					stack.add(n);
					visited[n] = true;
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DepthFirstTraversal obj = new DepthFirstTraversal(4);
		obj.addEdge(0, 1);
		obj.addEdge(0, 2);
		obj.addEdge(1, 2);
		obj.addEdge(2, 0);
		obj.addEdge(2, 3);
		obj.addEdge(3, 3);

		System.out.println("Following is Depth First Traversal" + "(starting from vertext (2)");
		obj.DFS(2);

	}

}
