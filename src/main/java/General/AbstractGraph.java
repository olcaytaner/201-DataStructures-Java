package General;

public abstract class AbstractGraph {

    protected int vertexCount;

    public AbstractGraph(int vertexCount){
        this.vertexCount = vertexCount;
    }

    protected abstract void depthFirstSearch(boolean[] visited, int fromNode);
    protected abstract void breadthFirstSearch(boolean[] visited, int startNode);

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

}
