package com.example.project;

public interface Graph {
    public boolean addEdge(int from, int to);

    public boolean removeEdge(int from, int to);

    public int countConnectedComponents();
}
