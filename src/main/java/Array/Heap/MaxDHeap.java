package Array.Heap;

public class MaxDHeap extends DHeap {

    public MaxDHeap(int N, int d) {
        super(N, d);
    }

    protected void percolateDown(int no){
        int child, largestChild;
        int value;
        do{
            largestChild = -1;
            value = array[no].getData();
            for (int i = 1; i <= d && d * no + i < count; i++){
                child = d * no + i;
                if (value < array[child].getData()){
                    largestChild = child;
                    value = array[child].getData();
                }
            }
            if (largestChild != -1){
                swapNode(no, largestChild);
                no = largestChild;
            } else {
                break;
            }
        } while (true);
    }
    protected void percolateUp(int no){
        int parent;
        parent = (no - 1) / d;
        while (parent >= 0 && array[parent].getData() < array[no].getData()){
            swapNode(parent, no);
            no = parent;
            parent = (no - 1) / d;
        }
    }

    public void update(int k, int newValue){
        int oldValue = array[k].getData();
        array[k].setData(newValue);
        if (oldValue > newValue){
            percolateDown(k);
        } else {
            percolateUp(k);
        }
    }
}
