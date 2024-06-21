package my.mood;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

    // Implementation of Breadth First Search ( BFS )
    public void BFS(int source){
        Queue<Integer> queue = new LinkedList<>();
        boolean [] isCorrect = new boolean[vertices];
        isCorrect[source] = true;

        queue.offer(source);
        while (!queue.isEmpty()) {
            int a = queue.poll();
            System.out.print(a + " ");

            for (int element : adjacencyList[a]){
                if (!isCorrect[element]){
                    isCorrect[element] = true;
                    queue.offer(element);
                }
            }
        }
    }

    // Implementation of Depth First Search ( DFS )
    public void DFS(int source){
        Stack<Integer> stack = new Stack<>();
        boolean [] isVisited = new boolean[vertices];
        stack.push(source);

        while (!stack.isEmpty()){
            int a = stack.pop();
            if (!isVisited[a]){
                isVisited[a] = true;
                System.out.print(a + " ");

                for (int element : adjacencyList[a]){
                    if (!isVisited[element]){
                        stack.push(element);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        AdjacencyList adjacencyList = new AdjacencyList(5);
        adjacencyList.addNode(0, 1);
        adjacencyList.addNode(1, 2);
        adjacencyList.addNode(2, 3);
        adjacencyList.addNode(3, 0);
        adjacencyList.addNode(2,4);
        System.out.println(adjacencyList);

        // Implementation of BFS
        adjacencyList.BFS(0);

        // implementation pf DFS
        System.out.println();
        adjacencyList.DFS(2);
    }
}
