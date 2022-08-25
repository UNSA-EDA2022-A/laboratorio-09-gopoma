package com.example.project;

import java.util.ArrayList;

public class GraphAdjacentList implements Graph {
    private ArrayList<Vertex> vertices;
    private int numVertices;

    public GraphAdjacentList() {
        vertices = new ArrayList<>();
    }

    // Agregar una arista desde un vertice 'from' a un vertice 'to'
    public boolean addEdge(int from, int to) {
        Vertex fromV = null, toV = null;
        for(Vertex v: vertices) {
            if(from == v.data) { // verificando si 'from' existe
                fromV = v;
            } else if(to == v.data) { // verificando si 'to' existe
                toV = v;
            }
            if(fromV != null && toV != null) {
                break; // ambos nodos deben existir, si no paramos
            }
        }
        if(fromV == null) {
            fromV = new Vertex(from);
            vertices.add(fromV);
            numVertices++;
        }
        if(toV == null) {
            toV = new Vertex(to);
            vertices.add(toV);
            numVertices++;
        }        
        return fromV.addAdjacentVertex(toV) && toV.addAdjacentVertex(fromV);
    }

    // Eliminamos la arista del vertice 'from' al vertice 'to'
    public boolean removeEdge(int from, int to) {
        Vertex fromV = null, toV = null;
        for(Vertex v: vertices) {
            if(from == v.data)
                fromV = v;
            if(to == v.data)
                toV = v;
            if(fromV != null && toV != null)
                break;
        }
        if(fromV == null || toV == null) {
            return false;
        }
        return fromV.removeAdjacentVertex(to) && toV.removeAdjacentVertex(from);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Vertex v: vertices) {
            sb.append("Vertex: ");
            sb.append(v.data);
            sb.append("\n");
            sb.append("Adjacent vertices: ");
            for (Vertex v2 : v.adjacentVertices) {
                sb.append(v2.data);
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public int getNumEdges() {
        int count = 0;
        for(int i = 0; i < this.vertices.size(); i++){
            count += this.vertices.get(i).adjacentVertices.size();
        }
        return count;
    }

    public int getNumVertices() {
        return numVertices;
    }

    public void setNumVertices(int numVertices) {
        this.numVertices = numVertices;
    }

    public ArrayList<Integer> dephFirstSearch(int initial) {
        Vertex target = null;
        for(Vertex v: this.vertices) {
            if(initial == v.data) {
                target = v;
                break;
            }
        }
        return target == null ? null : dephFirstSearch(target, new ArrayList<Integer>());
    }

    // Taking into consideration a Undirected Graph (Extra implementation added in 'addEdge' and 'removeEdge' methods)
    // Implementing DFS here taking into consideration the GraphMatrix DFS's implementation
    public ArrayList<Integer> dephFirstSearch(Vertex target, ArrayList<Integer> visited) {
        visited.add(target.data);
        for(Vertex v: target.adjacentVertices) {
            if(!visited.contains(v.data)) {
                dephFirstSearch(v, visited);
            }
        }
        return visited;
    }

    public int countConnectedComponents() {
        // Initializing available with all vertices' data from Graph as they are unique
        ArrayList<Integer> available = new ArrayList<Integer>();
        for(Vertex v: this.vertices) {
            available.add(v.data);
        }

        int cc = 0; // Counter for Connected Components
        while(!available.isEmpty()) {
            // Until there is not an unexplored vertex through DFS, continue visiting and removing from the available List
            for(Integer result: this.dephFirstSearch(available.get(0))) {
                // Note that 'result' was intentionally casted to Integer for its use in remove method to avoid ambiguitie as an int can also refer to the position in the List
                available.remove(result);
            }
            cc++;
        }
        return cc;
    }

    public boolean removeVertex(int vertex){
        return false;
    }

    public static void main(String args[]) {
        GraphAdjacentList graph = new GraphAdjacentList();
        graph.addEdge(1, 2);
        graph.addEdge(1, 5);
        graph.addEdge(2, 5);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 1);  
        graph.addEdge(10, 12); 
        graph.addEdge(1024, 1025);                           
        System.out.println(graph);
        System.out.println(graph.dephFirstSearch(5));
        System.out.println(graph.countConnectedComponents());
    }
}
