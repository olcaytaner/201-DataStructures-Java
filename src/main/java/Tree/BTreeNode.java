package Tree;

public class BTreeNode {

    private int[] K;
    private BTreeNode[] children;
    private int m;
    private int d;
    private boolean leaf;

    public BTreeNode(int d){
        m = 0;
        this.d = d;
        leaf = true;
        K = new int[2 * d + 1];
        children = new BTreeNode[2 * d + 1];
    }

    public BTreeNode search(int value){
        if (leaf){
            return this;
        }
        int childNo = position(value);
        if (childNo != -1){
            return children[childNo].search(value);
        }
        return null;
    }

    private int position(int value){
        if (m == 0){
            return -1;
        }
        if (value > K[m - 1]){
            return m;
        } else {
            for (int i = 0; i < m; i++){
                if (value <= K[i]){
                    return i;
                }
            }
        }
        return -1;
    }


}
