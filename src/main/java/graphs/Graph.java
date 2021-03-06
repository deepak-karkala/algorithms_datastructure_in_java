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
	private int startTime;
	private int finishTime;
	
	Vertex(int id) {
		this.id = id;
		this.visited = false;
		this.predecessor = null;
		this.distance = Integer.MAX_VALUE;
		this.startTime = 0;
		this.finishTime = 0;
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
	
	public void clearAttributes() {
		this.visited = false;
		this.predecessor = null;
		this.distance = Integer.MAX_VALUE;
	}
	
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	
	public void setFinishTime(int finishTime) {
		this.finishTime = finishTime;
	}
}



public class Graph {
	private Vertex[] V;
	private int numVertices;
	private LinkedList<Integer> adj[];
	public static int time = 0;

	Graph(int numVertices) {
		this.numVertices = numVertices;
		V = new Vertex[numVertices];
		adj = new LinkedList[numVertices];

		for (int i=0; i<numVertices; i++) {	
			V[i] = new Vertex(i);
			adj[i] = new LinkedList<Integer>();
		}	
	}
	
	public void addEdge(int u, int v) {
		adj[u].add(v);
	}
	
	public void BreadthFirstSearch(int s) {
		// Clear attributes of all vertices
		for(Vertex u: V) {
			u.clearAttributes();
		}

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
			System.out.print(u + "-");

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
	
	/*
	 * Shortest path between two vertices using Breadth first tree
	 * Should be invoked after Breadth first tree is built
	 * 
	 * @param	s	start vertex
	 * 			v	End vertex	
	 */
	public void findShortestPath(int s, int v) {
		if (s == v) {
			System.out.print(v+"-");
		} else if (V[v].getPredecessor() == null) { 
			return;
		} else {
			findShortestPath(s, V[v].getPredecessor().getId());
			System.out.print(v+"-");
		}
	}
	
	/*
	 * Depth first search
	 */
	public void depthFirstSearch() {
		// Clear attributes of all vertices
		for(Vertex u: V) {
			u.clearAttributes();
		}
		Graph.time = 0;
		for(Vertex u: V) {
			if (!u.isVisited()) {
				depthFirstSearchVisit(u.getId());
			}
		}
	}

	
	public void depthFirstSearchVisit(int u) {
		Graph.time += 1;
		V[u].setStartTime(Graph.time);
		V[u].setVisited(true);
		System.out.print(" (" + u + " ");

		Iterator<Integer> itr = adj[u].listIterator();
		while (itr.hasNext()) {
			int v = itr.next();
			if (!V[v].isVisited()) {
				V[v].setPredecessor(V[u]);
				depthFirstSearchVisit(v);
			}
		}
		Graph.time += 1;
		V[u].setFinishTime(Graph.time);
		System.out.print(u + ")" + " ");
	}
	
	public static void main(String[] args) {
		Graph g = new Graph(8);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 0);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 2);
		g.addEdge(3, 4);
		g.addEdge(3, 5);
		g.addEdge(4, 3);
		g.addEdge(4, 5);
		g.addEdge(4, 6);
		g.addEdge(5, 3);
		g.addEdge(5, 4);
		g.addEdge(5, 6);
		g.addEdge(5, 7);
		g.addEdge(6, 4);
		g.addEdge(6, 5);
		g.addEdge(6, 7);
		g.addEdge(7, 5);
		g.addEdge(7, 6);
		g.BreadthFirstSearch(2);
		
		System.out.println("");
		g.findShortestPath(2, 7);
		
		System.out.println("");
		g.depthFirstSearch();
	}
}