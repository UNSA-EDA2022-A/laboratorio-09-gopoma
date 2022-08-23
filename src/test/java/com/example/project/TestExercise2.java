package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestExercise2 {

  Exercise2 obj = new Exercise2();

  @Test
  public void case_1() {

    Exercise2 obj = new Exercise2();

    GraphAdjacentList graph = new GraphAdjacentList();

    graph.addEdge(1, 2);
    graph.addEdge(1, 5);
    graph.addEdge(2, 5);
    graph.addEdge(2, 3);
    graph.addEdge(3, 4);
    graph.addEdge(4, 1);

    obj.removeVertex(graph, 1);

    boolean result = graph.getNumVertices() == 4 && graph.getNumEdges() == 3;

    boolean expected = true;

    assertEquals(expected, result, "La salida esperada es: " + expected + " pero fue retornado: " + result);

  }

  @Test
  public void case_2() {

    Exercise2 obj = new Exercise2();

    GraphAdjacentList graph = new GraphAdjacentList();

    graph.addEdge(1, 2);
    graph.addEdge(1, 5);
    graph.addEdge(2, 5);
    graph.addEdge(2, 3);
    graph.addEdge(3, 4);
    graph.addEdge(4, 1);

    obj.removeVertex(graph, 1);
    obj.removeVertex(graph, 2);

    boolean result = graph.getNumVertices() == 3 && graph.getNumEdges() == 1;

    boolean expected = true;

    assertEquals(expected, result, "La salida esperada es: " + expected + " pero fue retornado: " + result);

  }

  @Test
  public void case_3() {

    Exercise2 obj = new Exercise2();

    GraphAdjacentList graph = new GraphAdjacentList();

    graph.addEdge(1, 2);
    graph.addEdge(1, 5);
    graph.addEdge(2, 5);
    graph.addEdge(2, 3);
    graph.addEdge(3, 4);
    graph.addEdge(4, 1);

    obj.removeVertex(graph, 1);
    obj.removeVertex(graph, 2);
    obj.removeVertex(graph, 3);

    boolean result = graph.getNumVertices() == 2 && graph.getNumEdges() == 0;

    boolean expected = true;

    assertEquals(expected, result, "La salida esperada es: " + expected + " pero fue retornado: " + result);

  }

}