package List;

public class Hash {

    private LinkedList[] table;

    private int N;

    public Hash(int N){
        table = new LinkedList[N];
        for (int i = 0; i < N; i++){
            table[i] = new LinkedList();
        }
        this.N = N;
    }

    public Node search(int value){
        int address;
        address = hashFunction(value);
        return table[address].search(value);
    }

    public void insert(int value){
        int address;
        address = hashFunction(value);
        table[address].insertLast(new Node(value));
    }

    public void insert(Node node){
        int address;
        address = hashFunction(node.data);
        table[address].insertLast(node);
    }

    public void deleteValue(int value){
        int address;
        if (search(value) != null){
            address = hashFunction(value);
            table[address].deleteValue(value);
        }
    }

    private int hashFunction(int value){
        return value % N;
    }
}
