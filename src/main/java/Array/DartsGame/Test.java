package Array.DartsGame;

public class Test {

    static String dartGame(int[] board, int target){
        Queue k;
        State s;
        s = new State(0, "");
        k = new Queue(10000);
        k.enqueue(new Element(s));
        while (!k.isEmpty()){
            s = k.dequeue().getData();
            if (s.getTotal() == target){
                return s.getDarts();
            }
            for (int i = 0; i < board.length; i++){
                if (s.getTotal() + board[i] <= target){
                    int newTotal = s.getTotal() + board[i];
                    String newDarts = s.getDarts() + " " + board[i];
                    Element child = new Element(new State(newTotal, newDarts));
                    k.enqueue(child);
                }
            }
        }
        return "";
    }

    public static void main(String[] args){
        int[] board = {11, 21, 27, 33, 36};
        System.out.println(dartGame(board, 100));
    }
}
