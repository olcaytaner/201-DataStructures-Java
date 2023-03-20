package List;

public class DoublyLinkedList extends LinkedList{

    public void insertFirst(DoublyNode newNode) {
        if (tail == null) {
            tail = newNode;
        } else {
            ((DoublyNode) head).setPrevious(newNode);
        }
        newNode.setNext(head);
        head = newNode;
    }

    public void insertMiddle(DoublyNode newNode, DoublyNode previous) {
        newNode.setNext(previous.getNext());
        newNode.setPrevious(previous);
        ((DoublyNode) previous.getNext()).setPrevious(newNode);
        previous.setNext(newNode);
    }

    public void insertLast(DoublyNode newNode) {
        if (head == null) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        newNode.setPrevious((DoublyNode) tail);
        tail = newNode;
    }

    public void deleteFirst(){
        head = head.getNext();
        if (head == null){
            tail = null;
        } else {
            ((DoublyNode)head).setPrevious(null);
        }
    }

    public void deleteMiddle(DoublyNode node){
        ((DoublyNode) node.getNext()).setPrevious(node.getPrevious());
        node.getPrevious().setNext(node.getNext());
    }

    public void deleteLast(){
        tail = ((DoublyNode)tail).getPrevious();
        if (tail != null){
            tail.setNext(null);
        } else {
            head = null;
        }
    }
}
