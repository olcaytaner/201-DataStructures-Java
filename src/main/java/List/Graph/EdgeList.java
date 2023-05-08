package List.Graph;

import List.Node;

public class EdgeList {
    private Edge head;
    private Edge tail;

    public EdgeList() {
        head = null;
        tail = null;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public Edge search(int to) {
        Edge tmp = head;
        while (tmp != null) {
            if (to == tmp.getTo()) {
                return tmp;
            }
            tmp = tmp.getNext();
        }
        return null;
    }

    public void addEdge(Edge newEdge) {
        if (head == null) {
            head = newEdge;
        } else {
            tail.setNext(newEdge);
        }
        tail = newEdge;
    }

}
