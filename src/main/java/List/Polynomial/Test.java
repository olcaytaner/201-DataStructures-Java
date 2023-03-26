package List.Polynomial;

public class Test {

    public static void main(String[] args){
        Polynomial polynomial1 = new Polynomial();
        polynomial1.insertLast(new TermNode(new Term(4, 5)));
        polynomial1.insertLast(new TermNode(new Term(3, 2)));
        polynomial1.insertLast(new TermNode(new Term(-7, 1)));
        polynomial1.insertLast(new TermNode(new Term(8, 0)));
        System.out.println(polynomial1.toString());
        Polynomial polynomial2 = new Polynomial();
        polynomial2.insertLast(new TermNode(new Term(2, 4)));
        polynomial2.insertLast(new TermNode(new Term(6, 2)));
        polynomial2.insertLast(new TermNode(new Term(7, 1)));
        System.out.println(polynomial2.toString());
        Polynomial result = polynomial1.add(polynomial2);
        System.out.println(result.toString());
    }
}
