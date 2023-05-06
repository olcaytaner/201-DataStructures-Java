package Array;

public class Set {
    private int data;
    private int parent;
    private int depth;

    public Set(int data, int index){
        this.data = data;
        parent= index;
        depth = 1;
    }

    public int getParent() {
        return parent;
    }

    public int getDepth() {
        return depth;
    }

    public void setParent(int parent){
        this.parent = parent;
    }

    public void incrementDepth(){
        depth++;
    }
}
