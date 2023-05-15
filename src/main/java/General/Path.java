package General;

public class Path {

    private int distance;
    private int previous;

    public Path(int distance, int previous) {
        this.distance = distance;
        this.previous = previous;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setPrevious(int previous) {
        this.previous = previous;
    }
}
