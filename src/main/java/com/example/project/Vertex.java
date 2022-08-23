package com.example.project;

import java.util.ArrayList;

public class Vertex {
    int data;
    ArrayList<Vertex> adjacentVertices;

    public Vertex(int data) {
        adjacentVertices = new ArrayList<>();
        this.data = data;
    }

    public boolean addAdjacentVertex(Vertex to) {
        for (Vertex v : adjacentVertices) {
            // Verificando si ya existe
            if (v.data == to.data) {
                return false;
            }
        }
        this.adjacentVertices.add(to);

        return true;
    }

    public boolean removeAdjacentVertex(int to) {
        for (int i = 0; i < adjacentVertices.size(); i++) {
            // Encontrando vertice adjacente
            if (this.adjacentVertices.get(i).data == to) {
                this.adjacentVertices.remove(i);
                return true;
            }
        }
        return false;
    }
}
