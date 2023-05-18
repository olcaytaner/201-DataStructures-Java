package List.Graph;

import Array.DisjointSet;
import Array.Heap.HeapNode;
import Array.Heap.MinHeap;
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
        Edge edge = new Edge(from, to, 1);
        edges[from].insert(edge);
    }

    public void addEdge(int from, int to, int weight){
        Edge edge = new Edge(from, to, weight);
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
        MinHeap heap = new MinHeap(vertexCount);
        for (int i = 0; i < vertexCount; i++){
            heap.insert(new HeapNode(shortestPaths[i].getDistance(), i));
        }
        while (!heap.isEmpty()){
            HeapNode node = heap.delete();
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

    protected Edge[] edgeList(){
        Edge[] list;
        int edgeCount = 0;
        for (int i = 0; i < vertexCount; i++){
            Edge edge = edges[i].getHead();
            while (edge != null){
                edgeCount++;
                edge = edge.getNext();
            }
        }
        list = new Edge[edgeCount];
        int index = 0;
        for (int i = 0; i < vertexCount; i++){
            Edge edge = edges[i].getHead();
            while (edge != null){
                list[index] = new Edge(edge.getFrom(), edge.getTo(), edge.getWeight());
                index++;
                edge = edge.getNext();
            }
        }
        return list;
    }

    public void prim(){
        Path[] paths = initializePaths(0);
        MinHeap heap = new MinHeap(vertexCount);
        for (int i = 0; i < vertexCount; i++){
            heap.insert(new HeapNode(paths[i].getDistance(), i));
        }
        while (!heap.isEmpty()){
            HeapNode node = heap.delete();
            int fromNode = node.getName();
            Edge edge = edges[fromNode].getHead();
            while (edge != null){
                int toNode = edge.getTo();
                if (paths[toNode].getDistance() > edge.getWeight()){
                    int position = heap.search(toNode);
                    heap.update(position, edge.getWeight());
                    paths[toNode].setDistance(edge.getWeight());
                    paths[toNode].setPrevious(fromNode);
                }
                edge = edge.getNext();
            }
        }
    }

}
