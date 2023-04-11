package Tree;

public class BTree {

    private BTreeNode root;

    public BTree(){
        root = null;
    }

    public BTreeNode search(int value){
        if (root != null){
            return root.search(value);
        }
        return null;
    }
}
