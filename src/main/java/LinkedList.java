public class LinkedList {
    private Node head;
    private Node tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public void insertFirst(Node newNode) {
        if (tail == null) {
            tail = newNode;
        }
        newNode.setNext(head);
        head = newNode;
    }

    public void insertLast(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
    }

    public void insertMiddle(Node newNode, Node previous) {
        newNode.setNext(previous.getNext());
        previous.setNext(newNode);
    }

    /**
     * @param value The value to be searched.
     * @return The node that has the data value. If no node exists, returns null.
     */
    public Node search(int value) {
        Node tmp = head;
        while (tmp != null) {
            if (value == tmp.getData()) {
                return tmp;
            }
            tmp = tmp.getNext();
        }
        return null;
    }

    public Node getNodeI(int i) {
        Node tmp = head;
        int index = 0;
        while (tmp != null) {
            if (index == i){
                return tmp;
            }
            index++;
            tmp = tmp.getNext();
        }
        return null;
    }

    public int numberOfElements(){
        Node tmp = head;
        int count = 0;
        while (tmp != null) {
            count++;
            tmp = tmp.getNext();
        }
        return count;
    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        Node tmp = head;
        while (tmp != null) {
            result.append(tmp).append(" ");
            tmp = tmp.getNext();
        }
        return result.toString();
    }
}
