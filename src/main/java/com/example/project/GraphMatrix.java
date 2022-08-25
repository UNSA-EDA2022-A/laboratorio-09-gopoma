package com.example.project;

import java.util.ArrayList;
import java.util.HashSet;

public class GraphMatrix implements Graph {
    private int numVertices;
    private int[][] adjacency;

    public GraphMatrix(int numVertices) {
        this.numVertices = numVertices;
        this.adjacency = new int[numVertices][numVertices];
    }

    public boolean vertexDoesExist(int aVertex) {
        return aVertex >= 0 && aVertex < this.numVertices;
    }

    @Override
    public boolean addEdge(int from, int to) {
        if(this.vertexDoesExist(from) && this.vertexDoesExist(to)) {
            // As it is not a directed graph
            this.adjacency[from][to] = 1;
            this.adjacency[to][from] = 1;
            return true; // Edge was added successfully
        }
        return false; // 'from' or 'to' are not in range
    }

    @Override
    public boolean removeEdge(int from, int to) {
        if(this.vertexDoesExist(from) && this.vertexDoesExist(to)) {
            // As it is not a directed graph
            this.adjacency[from][to] = 0;
            this.adjacency[to][from] = 0;
            return true; // Edge was removed successfully
        }
        return false; // 'from' or 'to' are not in range
    }

    public ArrayList<Integer> depthFirstSearch(int n) {
        return this.depthFirstSearch(n, new ArrayList<Integer>());
    }

    public ArrayList<Integer> depthFirstSearch(int n, ArrayList<Integer> visited) {
        visited.add(n);
        for(int i = 0; i < this.numVertices; i++) {
            if(this.adjacency[n][i] == 1 && !visited.contains(i)) {
                depthFirstSearch(i, visited);
            }
        }
        return visited;
    }

    public String toString() {
        String s = "    ";
        for(int i = 0; i < this.numVertices; i++) {
            s = s + String.valueOf(i) + " ";
        }
        s = s + " \n";

        for(int i = 0; i < this.numVertices; i++) {
            s = s + String.valueOf(i) + " : ";
            for(int j = 0; j < this.numVertices; j++) {
                s = s + String.valueOf(this.adjacency[i][j]) + " ";
            }
            s = s + "\n";
        }
        return s;
    }

    public int countConnectedComponents() {
        HashSet<Integer> already = new HashSet<Integer>(); // Already Visited Nodes from all DFS results
        int nV = 0; // Not Visited index
        int cc = 0; // Connected Components
        // Case: Taking into consideration when numVertices is 0
        while(already.size() != this.numVertices) {
            ArrayList<Integer> DFS = depthFirstSearch(nV);
            for(int num: DFS) {
                already.add(num);
            }

            // Finding another vertex that was not considered in DFS's list (if exists),
            // so there is more than a single Connected Component
            for(int i = 0; i < this.numVertices; i++) {
                if(!DFS.contains(i) && !already.contains(i)) {
                    nV = i;
                }
            }
            cc++;
        }
        return cc;
    }

    public static void main(String args[]) {
        GraphMatrix graph = new GraphMatrix(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        System.out.println("The graph matrix:");
        System.out.println(graph);
        System.out.println("DFS:");
        System.out.println(graph.depthFirstSearch(0));

        GraphMatrix g = new GraphMatrix(10);
        g.addEdge(4, 5);
        System.out.println(g.countConnectedComponents());
        GraphMatrix g2 = new GraphMatrix(1);
        g2.addEdge(0, 0);
        g2.addEdge(0, 0);
        g2.addEdge(0, 0);
        System.out.println(g2.countConnectedComponents());
        GraphMatrix g3 = new GraphMatrix(0);
        System.out.println(g3.countConnectedComponents());
    }
}
