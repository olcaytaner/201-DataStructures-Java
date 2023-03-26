package List.Polynomial;

public class Polynomial {

    protected TermNode head;
    protected TermNode tail;

    public Polynomial() {
        head = null;
        tail = null;
    }

    public Polynomial add(Polynomial polynomial){
        TermNode i, j, k, node;
        Polynomial result;
        int coefficient, degree;
        i = head;
        j = polynomial.head;
        result = new Polynomial();
        while (i != null && j != null){
            if (i.data.degree == j.data.degree){
                coefficient = i.data.coefficient + j.data.coefficient;
                degree = i.data.degree;
                i = i.next;
                j = j.next;
            } else
            if (i.data.degree > j.data.degree){
                coefficient = i.data.coefficient;
                degree = i.data.degree;
                i = i.next;
            } else {
                coefficient = j.data.coefficient;
                degree = j.data.degree;
                j = j.next;
            }
            if (coefficient != 0){
                node = new TermNode(new Term(coefficient, degree));
                result.insertLast(node);
            }
        }
        if (i == null)
            k = j;
        else
            k = i;
        while (k != null){
            node = new TermNode(new Term(k.getData().coefficient, k.getData().degree));
            result.insertLast(node);
            k = k.next;
        }
        return result;
    }

    public void insertLast(TermNode newTermNode) {
        if (head == null) {
            head = newTermNode;
        } else {
            tail.setNext(newTermNode);
        }
        tail = newTermNode;
    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        TermNode tmp = head;
        while (tmp != null) {
            result.append(tmp).append(" ");
            tmp = tmp.getNext();
        }
        return result.toString();
    }
}
