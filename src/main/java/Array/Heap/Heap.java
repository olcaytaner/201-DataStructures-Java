package Array.Heap;

public abstract class Heap {

    protected HeapNode array[];
    protected int count;

    protected int N;

    abstract protected void percolateDown(int no);
    abstract protected void percolateUp(int no);

    abstract public void update(int k, int newValue);
    public Heap(int N){
        array = new HeapNode[N];
        count = 0;
        this.N = N;
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public boolean isFull(){
        return count == N;
    }

    protected void swapNode(int index1, int index2){
        HeapNode tmpNode;
        tmpNode = array[index1];
        array[index1] = array[index2];
        array[index2] = tmpNode;
    }

    public HeapNode delete(){
        HeapNode tmp;
        tmp = array[0];
        array[0] = array[count - 1];
        percolateDown(0);
        count--;
        return tmp;
    }

    public int search(int name){
        for (int i = 0; i < count; i++){
            if (array[i].getName() == name){
                return i;
            }
        }
        return -1;
    }

    public void insert(HeapNode node){
        count++;
        array[count - 1] = node;
        percolateUp(count - 1);
    }

}
