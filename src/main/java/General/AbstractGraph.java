package General;

import Array.DisjointSet;
import List.Graph.Edge;

import java.util.Arrays;

public abstract class AbstractGraph {

    protected int vertexCount;

    public AbstractGraph(int vertexCount){
        this.vertexCount = vertexCount;
    }

    protected abstract void depthFirstSearch(boolean[] visited, int fromNode);
    protected abstract void breadthFirstSearch(boolean[] visited, int startNode);
    protected abstract Edge[] edgeList();

    protected Path[] initializePaths(int source){
        Path[] paths = new Path[vertexCount];
        for (int i = 0; i < vertexCount; i++){
            paths[i] = new Path(Integer.MAX_VALUE, -1);
        }
        paths[source].setDistance(0);
        return paths;
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

    public void kruskal(){
        int edgeCount = 0, i;
        DisjointSet sets = new DisjointSet(vertexCount);
        Edge[] list = edgeList();
        Arrays.sort(list);
        i = 0;
        while (edgeCount < vertexCount - 1){
            int fromNode = list[i].getFrom();
            int toNode = list[i].getTo();
            if (sets.findSetRecursive(fromNode) != sets.findSetRecursive(toNode)){
                sets.unionOfSets(fromNode, toNode);
                edgeCount++;
            }
            i++;
        }
    }
}
