package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestExercise1 {

  Exercise1 obj = new Exercise1();

  @Test
  public void case_1() {

    Exercise1 obj = new Exercise1();

    Graph graph = new GraphMatrix(5);
    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(0, 3);
    graph.addEdge(0, 4);
    graph.addEdge(1, 2);
    graph.addEdge(2, 3);
    graph.addEdge(2, 4);

    int result = obj.countConnectedComponents(graph);

    int expected = 1;

    assertEquals(expected, result, "La salida esperada es: " + expected + " pero fue retornado: " + result);
  }

  @Test
  public void case_2() {

    Exercise1 obj = new Exercise1();

    Graph graph = new GraphMatrix(5);
    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(0, 3);
    graph.addEdge(1, 2);
    graph.addEdge(2, 3);

    int result = obj.countConnectedComponents(graph);

    int expected = 2;

    assertEquals(expected, result, "La salida esperada es: " + expected + " pero fue retornado: " + result);
  }

  @Test
  public void case_3() {

    Exercise1 obj = new Exercise1();

    Graph graph = new GraphMatrix(5);

    int result = obj.countConnectedComponents(graph);

    int expected = 5;

    assertEquals(expected, result, "La salida esperada es: " + expected + " pero fue retornado: " + result);
  }

}
