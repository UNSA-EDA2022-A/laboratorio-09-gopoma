package com.example.project;

public class Exercise1 {

	public static void main(final String[] args) {

		Exercise1 obj = new Exercise1();
		GraphMatrix graph = new GraphMatrix(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
		
		System.out.println(obj.countConnectedComponents(graph));
		
	}

	public int countConnectedComponents(Graph grafo) {

		return grafo.countConnectedComponents();
	}
}
