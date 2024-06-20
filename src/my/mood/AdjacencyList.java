package my.mood;

import java.util.LinkedList;

public class AdjacencyList {

    public int vertices;
    public int edges;
    LinkedList <Integer>[] adjacencyList;

    public AdjacencyList(int nodes){
        this.vertices = nodes;
        this.edges = 0;

        this.adjacencyList = new LinkedList[nodes];
        for (int i = 0; i < vertices; i++){
            adjacencyList[i] = new LinkedList<>();
        }
    }

    // Implementation of undirected graph using Adjacency Matrix
    public void addNode(int a, int b){
        adjacencyList[a].add(b);
        adjacencyList[b].add(a);
        edges++;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(vertices + " vertices and " + edges + " edges \n");
        for (int i = 0; i < vertices; i++){
            stringBuilder.append(i + " : ");
            for (int j : adjacencyList[i]){
                stringBuilder.append(j + " -> ");
            }
            stringBuilder.append("null\n");
        }
        return stringBuilder.toString();
    }
    public static void main(String[] args) {
        AdjacencyList adjacencyList = new AdjacencyList(4);
        adjacencyList.addNode(0, 1);
        adjacencyList.addNode(1, 2);
        adjacencyList.addNode(2, 3);
        adjacencyList.addNode(3, 0);

        System.out.println(adjacencyList);
    }
}
