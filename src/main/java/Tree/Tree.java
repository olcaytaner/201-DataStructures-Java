package Tree;

public class Tree {

    protected TreeNode root;

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

    protected void insertChild(TreeNode parent, TreeNode child){
        if (parent == null) {
            root = child;
        } else {
            if (child.data < parent.data) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        }
    }

    public void iterativeInsert(TreeNode node){
        TreeNode parent = null;
        TreeNode tmp = root;
        while (tmp != null) {
            parent = tmp;
            if (node.getData() < tmp.getData()){
                tmp = tmp.getLeft();
            } else {
                tmp = tmp.getRight();
            }
        }
        insertChild(parent, node);
    }

    public void recursiveInsert(TreeNode node){
        if (root == null){
            root = node;
        } else {
            root.recursiveInsert(node);
        }
    }

    public void prettyPrint(){
        if (root != null){
            root.prettyPrint(0);
        }
    }

    public int nodeCountWithStack(){
        TreeNode tmp;
        int count = 0;
        Stack c = new Stack(100);
        if (root != null){
            c.push(new Element(root));
        }
        while (!c.isEmpty()){
            Element e = c.pop();
            count++;
            tmp = e.getData();
            if (tmp.getLeft() != null){
                c.push(new Element(tmp.getLeft()));
            }
            if (tmp.getRight() != null){
                c.push(new Element(tmp.getRight()));
            }
        }
        return count;
    }

    public int nodeCountWithQueue(){
        TreeNode tmp;
        int count = 0;
        Queue c = new Queue(100);
        if (root != null){
            c.enqueue(new Element(root));
        }
        while (!c.isEmpty()){
            Element e = c.dequeue();
            count++;
            tmp = e.getData();
            if (tmp.getLeft() != null){
                c.enqueue(new Element(tmp.getLeft()));
            }
            if (tmp.getRight() != null){
                c.enqueue(new Element(tmp.getRight()));
            }
        }
        return count;
    }

}
