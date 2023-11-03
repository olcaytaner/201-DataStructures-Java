import Tree.Tree;
import Tree.TreeNode;
import org.junit.Test;


public class TreeTest {

    @Test
    public void TestTree(){
        Tree tree = new Tree();
        tree.iterativeInsert(new TreeNode(6));
        tree.iterativeInsert(new TreeNode(4));
        tree.iterativeInsert(new TreeNode(8));
        tree.iterativeInsert(new TreeNode(1));
        tree.iterativeInsert(new TreeNode(10));
        tree.iterativeInsert(new TreeNode(5));
        tree.iterativeInsert(new TreeNode(7));
        tree.prettyPrint();
        tree.delete(6);
        tree.prettyPrint();
        tree.delete(5);
        tree.prettyPrint();
        tree.delete(4);
        tree.prettyPrint();
        tree.delete(1);
        tree.prettyPrint();
    }

}
