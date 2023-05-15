package Array.Graph;

import Array.*;
import General.AbstractGraph;
import General.Path;

public class Graph extends AbstractGraph {

    private int[][] edges;

    public Graph(int vertexCount){
        super(vertexCount);
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

    public void connectedComponentDisjointSet(){
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

    protected void depthFirstSearch(boolean[] visited, int fromNode){
        for (int toNode = 0; toNode < vertexCount; toNode++){
            if (edges[fromNode][toNode] > 0){
                if (!visited[toNode]){
                    visited[toNode] = true;
                    depthFirstSearch(visited, toNode);
                }
            }
        }
    }

    protected void breadthFirstSearch(boolean[] visited, int startNode){
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

    public Path[] bellmanFord(int source){
        Path[] shortestPaths = initializePaths(source);
        for (int i = 0; i < vertexCount - 1; i++){
            for (int fromNode = 0; fromNode < vertexCount; fromNode++){
                for (int toNode = 0; toNode < vertexCount; toNode++){
                    int newDistance = shortestPaths[fromNode].getDistance() + edges[fromNode][toNode];
                    if (newDistance < shortestPaths[toNode].getDistance()){
                        shortestPaths[toNode].setDistance(newDistance);
                        shortestPaths[toNode].setPrevious(fromNode);
                    }
                }
            }
        }
        return shortestPaths;
    }

    public Path[] dijkstra(int source){
        Path[] shortestPaths = initializePaths(source);
        Heap heap = new Heap(vertexCount);
        for (int i = 0; i < vertexCount; i++){
            heap.insert(new HeapNode(shortestPaths[i].getDistance(), i));
        }
        while (!heap.isEmpty()){
            HeapNode node = heap.deleteMax();
            int fromNode = node.getName();
            for (int toNode = 0; toNode < vertexCount; toNode++){
                int newDistance = shortestPaths[fromNode].getDistance() + edges[fromNode][toNode];
                if (newDistance < shortestPaths[toNode].getDistance()){
                    int position = heap.search(toNode);
                    heap.update(position, newDistance);
                    shortestPaths[toNode].setDistance(newDistance);
                    shortestPaths[toNode].setPrevious(fromNode);
                }
            }
        }
        return shortestPaths;
    }

}
