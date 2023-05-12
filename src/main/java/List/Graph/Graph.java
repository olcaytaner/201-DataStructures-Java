package List.Graph;

import Array.DisjointSet;
import List.Node;
import List.Queue;

public class Graph {
    private EdgeList[] edges;
    private int vertexCount;

    public Graph(int vertexCount){
        edges = new EdgeList[vertexCount];
        for (int i = 0; i < vertexCount; i++){
            edges[i] = new EdgeList();
        }
        this.vertexCount = vertexCount;
    }

    public void addEdge(int from, int to){
        Edge edge = new Edge(to, 1);
        edges[from].insert(edge);
    }

    public void addEdge(int from, int to, int weight){
        Edge edge = new Edge(to, weight);
        edges[from].insert(edge);
    }

    public void connectedComponentsDisjointSet(){
        Edge edge;
        int toNode;
        DisjointSet sets = new DisjointSet(vertexCount);
        for (int fromNode = 0; fromNode < vertexCount; fromNode++){
            edge = edges[fromNode].getHead();
            while (edge != null){
                toNode = edge.getTo();
                if (sets.findSetRecursive(fromNode) != sets.findSetRecursive(toNode)){
                    sets.unionOfSets(fromNode, toNode);
                }
                edge = edge.getNext();
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
        Edge edge;
        int toNode;
        edge = edges[fromNode].getHead();
        while (edge != null){
            toNode = edge.getTo();
            if (!visited[toNode]){
                visited[toNode] = true;
                depthFirstSearch(visited, toNode);
            }
            edge = edge.getNext();
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
        Edge edge;
        int fromNode, toNode;
        Queue queue = new Queue();
        queue.enqueue(new Node(startNode));
        while (!queue.isEmpty()){
            fromNode = queue.dequeue().getData();
            edge = edges[fromNode].getHead();
            while (edge != null) {
                toNode = edge.getTo();
                if (!visited[toNode]){
                    visited[toNode] = true;
                    queue.enqueue(new Node(toNode));
                }
                edge = edge.getNext();
            }
        }
    }

}
