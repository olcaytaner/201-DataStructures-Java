package List.Polynomial;

public class TermNode {
    protected Term data;
    protected TermNode next;

    public TermNode(Term data){
        this.data = data;
        this.next = null;
    }

    public void setNext(TermNode next){
        this.next = next;
    }

    public TermNode getNext(){
        return next;
    }

    public Term getData(){
        return data;
    }

    public String toString(){
        if (data.degree != 1 && data.degree != 0){
            return "" + data.coefficient + "x" + data.degree;
        } else {
            if (data.degree == 1){
                return "" + data.coefficient + "x";
            } else {
                return "" + data.coefficient;
            }
        }
    }

}
