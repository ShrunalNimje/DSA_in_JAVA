package my.mood;

public class Graph {

    public int vertices;
    public int edges;
    public int [][] adjacencyMatrix;

    public Graph(int nodes){
        this.vertices = nodes;
        this.edges = 0;
        this.adjacencyMatrix = new int[nodes][nodes];
    }

    // Implementation of adjacency matrix
    public void addEdges(int a, int b){
        adjacencyMatrix[a][b] = 1;
        adjacencyMatrix[b][a] = 1;
        edges++;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(vertices).append(" vertices and ").append(edges).append(" edges\n");

        for (int i = 0; i < vertices; i++){
            stringBuilder.append(i).append(" : ");

            // here we can put edges as well as vertices
            for (int j = 0; j < edges; j++){
                stringBuilder.append(adjacencyMatrix[i][j]).append(" ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString() ;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdges(0, 1);
        graph.addEdges(1, 2);
        graph.addEdges(2, 3);
        graph.addEdges(3, 0);

        System.out.println(graph);
    }
}
