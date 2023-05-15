package List.Graph;

import Array.DisjointSet;
import Array.Heap;
import Array.HeapNode;
import General.AbstractGraph;
import General.Path;
import List.Node;
import List.Queue;

public class Graph extends AbstractGraph {
    private EdgeList[] edges;

    public Graph(int vertexCount){
        super(vertexCount);
        edges = new EdgeList[vertexCount];
        for (int i = 0; i < vertexCount; i++){
            edges[i] = new EdgeList();
        }
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

    protected void depthFirstSearch(boolean[] visited, int fromNode){
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

    protected void breadthFirstSearch(boolean[] visited, int startNode){
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

    public Path[] bellmanFord(int source){
        Edge edge;
        Path[] shortestPaths = initializePaths(source);
        for (int i = 0; i < vertexCount - 1; i++){
            for (int fromNode = 0; fromNode < vertexCount; fromNode++){
                edge = edges[fromNode].getHead();
                while (edge != null){
                    int toNode = edge.getTo();
                    int newDistance = shortestPaths[fromNode].getDistance() + edge.getWeight();
                    if (newDistance < shortestPaths[toNode].getDistance()){
                        shortestPaths[toNode].setDistance(newDistance);
                        shortestPaths[toNode].setPrevious(fromNode);
                    }
                    edge = edge.getNext();
                }
            }
        }
        return shortestPaths;
    }

    public Path[] dijkstra(int source){
        Edge edge;
        Path[] shortestPaths = initializePaths(source);
        Heap heap = new Heap(vertexCount);
        for (int i = 0; i < vertexCount; i++){
            heap.insert(new HeapNode(shortestPaths[i].getDistance(), i));
        }
        while (!heap.isEmpty()){
            HeapNode node = heap.deleteMax();
            int fromNode = node.getName();
            edge = edges[fromNode].getHead();
            while (edge != null){
                int toNode = edge.getTo();
                int newDistance = shortestPaths[fromNode].getDistance() + edge.getWeight();
                if (newDistance < shortestPaths[toNode].getDistance()){
                    int position = heap.search(toNode);
                    heap.update(position, newDistance);
                    shortestPaths[toNode].setDistance(newDistance);
                    shortestPaths[toNode].setPrevious(fromNode);
                }
                edge = edge.getNext();
            }
        }
        return shortestPaths;
    }

}
