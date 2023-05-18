package List.Graph;

public class Edge {

    private int from;
    private int to;
    private int weight;
    private Edge next;

    public Edge(int from, int to, int weight){
        this.from = from;
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

    public int getFrom(){
        return from;
    }

    public int getWeight(){
        return weight;
    }

}
