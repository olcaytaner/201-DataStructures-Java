package Tree;

public class Tree {

    private TreeNode root;

    public Tree(){
        root = null;
    }

    public TreeNode getRoot(){
        return root;
    }

    public void setRoot(TreeNode root){
        this.root = root;
    }

    public TreeNode recursiveSearch(int value){
        if (root != null){
            return root.recursiveSearch(value);
        } else {
            return null;
        }
    }

    public TreeNode iterativeSearch(int value){
        TreeNode tmp = root;
        while (tmp != null){
            if (value < tmp.getData()){
                tmp = tmp.getLeft();
            } else {
                if (value > tmp.getData()){
                    tmp = tmp.getRight();
                } else {
                    return tmp;
                }
            }
        }
        return null;
    }

    public TreeNode iterativeMinSearch(){
        TreeNode tmp = root;
        TreeNode parent = null;
        while (tmp != null) {
            parent = tmp;
            tmp = tmp.getLeft();
        }
        return parent;
    }

    public TreeNode iterativeMaxSearch(){
        TreeNode tmp = root;
        while (tmp != null) {
            if (tmp.getRight() == null){
                return tmp;
            }
            tmp = tmp.getRight();
        }
        return null;
    }

    public TreeNode recursiveMinSearch(){
        if (root != null){
            return root.recursiveMinSearch();
        }
        return null;
    }

    public TreeNode recursiveMaxSearch(){
        if (root != null){
            return root.recursiveMaxSearch();
        }
        return null;
    }

    public void inorder(){
        if (root != null){
            root.inorder();
        }
    }

    public void preorder(){
        if (root != null){
            root.preorder();
        }
    }

    public void postorder(){
        if (root != null){
            root.postorder();
        }
    }

}
