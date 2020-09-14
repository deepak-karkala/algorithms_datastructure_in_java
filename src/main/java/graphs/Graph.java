package graphs;

import java.util.*;
/**
 * 
 * Class to support graph operations:
 * 		1. Breadth first Search
 * @author Deepak Karkala
 */

class Vertex {
	private int id;
	private boolean visited;
	private Vertex predecessor;
	private int distance;
	
	Vertex(int id) {
		this.id = id;
		this.visited = false;
		this.predecessor = null;
		this.distance = Integer.MAX_VALUE;
	}
	
	public int getId() {
		return id;
	}
	
	public boolean isVisited() {
		return visited;
	}
	
	public void setVisited(boolean isVisited) {
		visited = isVisited;
	}
	
	public Vertex getPredecessor() {
		return predecessor;
	}
	
	public void setPredecessor(Vertex u) {
		predecessor = u;
	}
	
	public int getDistance() {
		return distance;
	}
	
	public void setDistance(int d) {
		distance = d;
	}
	
	public void setAttributes(boolean isVisited, Vertex predecessor, int distance) {
		this.visited = isVisited;
		this.predecessor = predecessor;
		this.distance = distance;
	}
}


public class Graph {
	private Vertex[] V;
	private int numVertices;
	private LinkedList<Integer> adj[];
	
	Graph(int numVertices) {
		this.numVertices = numVertices;
		V = new Vertex[numVertices];
		//adj = new LinkedList[numVertices];

		for (int i=0; i<numVertices; i++) {	
			V[i] = new Vertex(i);
			adj[i] = new LinkedList<Integer>();
		}	
	}
	
	public void addEdge(int u, int v) {
		adj[u].add(v);
	}
	
	public void BreadthFirstSearch(int s) {
		// Boolean array to track which vertices are visited
		boolean[] visited = new boolean[numVertices];
		visited[s] = true;

		// Set attributes of source vertex
		V[s].setAttributes(true, null, 0);

		
		//Init queue to track visited vertices
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(s);
		
		while (queue.size() != 0) {
			int u = queue.poll();
			
			//Visit all vertices in adjacency list of u
			Iterator<Integer> itr = adj[u].listIterator();
			while(itr.hasNext()) {
				int v = itr.next();
				
				if (!visited[v]) {
					// Mark as visited and add to queue
					visited[v] = true;
					queue.add(v);
					
					// Set attributes of this vertex
					V[v].setAttributes(true, V[u], V[u].getDistance()+1);
				}
				
			}
		}
		
	}
	
	public static void main(String[] args) {
		Graph g = new Graph(8);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		g.addEdge(3, 5);
		g.addEdge(4, 5);
		g.addEdge(4, 6);
		g.addEdge();
		
	}
}