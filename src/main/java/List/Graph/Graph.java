package List.Graph;

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
        edges[from].addEdge(edge);
    }

    public void addEdge(int from, int to, int weight){
        Edge edge = new Edge(to, weight);
        edges[from].addEdge(edge);
    }

}
