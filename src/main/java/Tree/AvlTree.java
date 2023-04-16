package Tree;

public class AvlTree extends Tree{

    public AvlTree(){
        super();
    }

    private int getHeight(AvlTreeNode node){
        if (node == null){
            return 0;
        } else {
            return node.getHeight();
        }
    }

    private AvlTreeNode rotateLeft(AvlTreeNode k2){
        AvlTreeNode k1 = (AvlTreeNode) k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.setHeight(Math.max(getHeight((AvlTreeNode) k2.left), getHeight((AvlTreeNode) k2.right)) + 1);
        k1.setHeight(Math.max(getHeight((AvlTreeNode) k1.left), ((AvlTreeNode) k1.right).getHeight()) + 1);
        return k1;
    }

    private AvlTreeNode rotateRight(AvlTreeNode k1){
        AvlTreeNode k2 = (AvlTreeNode) k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k2.setHeight(Math.max(getHeight((AvlTreeNode) k2.left), ((AvlTreeNode) k2.right).getHeight()) + 1);
        k1.setHeight(Math.max(getHeight((AvlTreeNode) k1.left), getHeight((AvlTreeNode) k1.right)) + 1);
        return k2;
    }

    private AvlTreeNode doubleRotateLeft(AvlTreeNode k3){
        k3.setLeft(rotateRight((AvlTreeNode) k3.left));
        return rotateLeft(k3);
    }

    private AvlTreeNode doubleRotateRight(AvlTreeNode k1){
        k1.setRight(rotateLeft((AvlTreeNode) k1.right));
        return rotateRight(k1);
    }

    public void insert(AvlTreeNode node){
        int LEFT = 1, RIGHT = 2;
        AvlTreeNode y = null, x = (AvlTreeNode) root, t;
        int dir1 = 0, dir2 = 0;
        Stack c = new Stack(100);
        while (x != null){
            y = x;
            c.push(new Element(y));
            dir1 = dir2;
            if (node.data < x.data){
                x = (AvlTreeNode) x.left;
                dir2 = LEFT;
            } else {
                x = (AvlTreeNode) x.right;
                dir2 = RIGHT;
            }
        }
        insertChild(y, node);
        while (!c.isEmpty()){
            x = (AvlTreeNode) c.pop().getData();
            x.setHeight(Math.max(((AvlTreeNode) x.left).getHeight(), ((AvlTreeNode) x.right).getHeight()) + 1);
            if (Math.abs(((AvlTreeNode) x.left).getHeight() - ((AvlTreeNode) x.right).getHeight()) == 2){
                if (dir1 == LEFT){
                    if (dir2 == LEFT){
                        t = rotateLeft(x);
                    } else {
                        t = doubleRotateLeft(x);
                    }
                } else {
                    if (dir2 == LEFT){
                        t = doubleRotateRight(x);
                    } else {
                        t = rotateRight(x);
                    }
                }
                y = (AvlTreeNode) c.pop().getData();
                insertChild(y, t);
                break;
            }
        }
    }

}
