package Array.Graph;

import Array.DisjointSet;
import Array.Element;
import Array.Queue;

public class Graph {

    private int[][] edges;
    private int vertexCount;

    public Graph(int vertexCount){
        this.vertexCount = vertexCount;
        edges = new int[vertexCount][vertexCount];
        for (int i = 0; i < vertexCount; i++){
            for (int j = 0; j < vertexCount; j++){
                edges[i][j] = 0;
            }
        }
    }

    public void addEdge(int from, int to){
        edges[from][to] = 1;
    }

    public void addEdge(int from, int to, int weight){
        edges[from][to] = weight;
    }

    public void connectedComponentsDisjointSet(){
        DisjointSet sets = new DisjointSet(vertexCount);
        for (int fromNode = 0; fromNode < vertexCount; fromNode++){
            for (int toNode = 0; toNode < vertexCount; toNode++){
                if (edges[fromNode][toNode] > 0){
                    if (sets.findSetRecursive(fromNode) != sets.findSetRecursive(toNode)){
                        sets.unionOfSets(fromNode, toNode);
                    }
                }
            }
        }
    }

    public int connectedComponentDfs(){
        int component = 0;
        boolean[] visited = new boolean[vertexCount];
        for (int vertex = 0; vertex < vertexCount; vertex++){
            visited[vertex] = true;
            depthFirstSearch(visited, vertex);
            component++;
        }
        return component;
    }

    private void depthFirstSearch(boolean[] visited, int fromNode){
        for (int toNode = 0; toNode < vertexCount; toNode++){
            if (edges[fromNode][toNode] > 0){
                if (!visited[toNode]){
                    visited[toNode] = true;
                    depthFirstSearch(visited, toNode);
                }
            }
        }
    }

    public int connectedComponentBfs(){
        int component = 0;
        boolean[] visited = new boolean[vertexCount];
        for (int vertex = 0; vertex < vertexCount; vertex++){
            visited[vertex] = true;
            breadthFirstSearch(visited, vertex);
            component++;
        }
        return component;
    }

    private void breadthFirstSearch(boolean[] visited, int startNode){
        int fromNode;
        Queue queue = new Queue(100);
        queue.enqueue(new Element(startNode));
        while (!queue.isEmpty()){
            fromNode = queue.dequeue().getData();
            for (int toNode = 0; toNode < vertexCount; toNode++) {
                if (edges[fromNode][toNode] > 0) {
                    if (!visited[toNode]){
                        visited[toNode] = true;
                        queue.enqueue(new Element(toNode));
                    }
                }
            }
        }
    }

}
