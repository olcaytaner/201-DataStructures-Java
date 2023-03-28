package Array.DartsGame;

public class State {

    private int total;
    private String darts;

    State(int total, String darts){
        this.total = total;
        this.darts = darts;
    }

    public int getTotal() {
        return total;
    }

    public String getDarts() {
        return darts;
    }
}
