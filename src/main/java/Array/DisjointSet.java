package Array;

public class DisjointSet {
    private Set[] sets;
    private int count;

    public DisjointSet(int[] elements, int count){
        sets = new Set[count];
        for (int i = 0; i < count; i++){
            sets[i] = new Set(elements[i], i);
        }
        this.count = count;
    }

    public int findSetRecursive(int index){
        int parent = sets[index].getParent();
        if (parent != index){
            return findSetRecursive(parent);
        }
        return parent;
    }

    public int findSetIterative(int index){
        int parent = sets[index].getParent();
        while (parent != index){
            index = parent;
            parent = sets[index].getParent();
        }
        return parent;
    }

    public void unionOfSets(int index1, int index2){
        int x = findSetIterative(index1);
        int y = findSetIterative(index2);
        if (sets[x].getDepth() < sets[y].getDepth()){
            sets[x].setParent(y);
        } else {
            sets[y].setParent(x);
            if (sets[x].getDepth() == sets[y].getDepth()){
                sets[x].incrementDepth();
            }
        }
    }
}
