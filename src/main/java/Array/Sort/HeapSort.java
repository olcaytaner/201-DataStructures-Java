package Array.Sort;

import Array.Heap.HeapNode;
import Array.Heap.MinHeap;

public class HeapSort implements Sort{

    @Override
    public void sort(int[] A) {
        MinHeap heap = new MinHeap(A.length);
        for (int i = 0; i < A.length; i++){
            HeapNode heapNode = new HeapNode(A[i], i);
            heap.insert(heapNode);
        }
        for (int i = 0; i < A.length; i++){
            HeapNode heapNode = heap.delete();
            A[i] = heapNode.getData();
        }
    }
}
