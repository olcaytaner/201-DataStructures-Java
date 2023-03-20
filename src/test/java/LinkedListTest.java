import List.DoublyLinkedList;
import List.DoublyNode;
import List.LinkedList;
import List.Node;
import org.junit.Test;

public class LinkedListTest {

    @Test
    public void TestInsertFirst(){
        LinkedList list = new LinkedList();
        list.insertFirst(new Node(4));
        list.insertFirst(new Node(5));
        list.insertFirst(new Node(6));
        System.out.println(list.toString());
    }

    @Test
    public void TestDeleteFirst(){
        LinkedList list = new LinkedList();
        list.insertFirst(new Node(4));
        list.insertFirst(new Node(5));
        list.insertFirst(new Node(6));
        System.out.println(list.toString());
        list.deleteLast();
        System.out.println(list.toString());
        list.deleteLast();
        System.out.println(list.toString());
        list.deleteLast();
        System.out.println(list.toString());
    }

    @Test
    public void TestInsertFirstForDouble(){
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertFirst(new DoublyNode(4));
        list.insertFirst(new DoublyNode(5));
        list.insertFirst(new DoublyNode(6));
        System.out.println(list.toString());
    }

}