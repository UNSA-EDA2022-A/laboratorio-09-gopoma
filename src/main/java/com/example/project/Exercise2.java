package com.example.project;

public class Exercise2 {

	public static void main(final String[] args) {

		Exercise2 obj = new Exercise2();

		GraphAdjacentList graph = new GraphAdjacentList();
        graph.addEdge(1, 2);
        graph.addEdge(1, 5);
        graph.addEdge(2, 5);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 1);        
        
		System.out.println("Numero de vertices: " + graph.getNumVertices());
		System.out.println("Numero de aristas: " + graph.getNumEdges());

		obj.removeVertex(graph, 1);

		System.out.println("Numero de vertices: " + graph.getNumVertices());
		System.out.println("Numero de aristas: " + graph.getNumEdges());

	}

	public void removeVertex(GraphAdjacentList graph, int vertex) {
		graph.removeVertex(vertex);
	}
}