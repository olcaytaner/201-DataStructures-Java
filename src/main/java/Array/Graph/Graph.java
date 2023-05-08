package Array.Graph;

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
}
