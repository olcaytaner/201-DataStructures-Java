package List.Graph;

public class Edge {
    private int to;
    private int weight;
    private Edge next;

    public Edge(int to, int weight){
        this.to = to;
        this.weight = weight;
        this.next = null;
    }

    public void setNext(Edge next){
        this.next = next;
    }

    public Edge getNext(){
        return next;
    }

    public int getTo(){
        return to;
    }

    public int getWeight(){
        return weight;
    }

}
