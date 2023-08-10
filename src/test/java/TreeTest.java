import Array.Element;
import Array.Queue;
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
        //tree.prettyPrint();
        System.out.println(tree.nodeCountWithStack());
        System.out.println(tree.nodeCountWithQueue());
    }

}
