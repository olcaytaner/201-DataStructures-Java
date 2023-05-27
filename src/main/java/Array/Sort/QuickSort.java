package Array.Sort;

public class QuickSort implements Sort{

    private int partition(int[] A, int first, int last){
        int x = A[last];
        int i = first - 1;
        for (int j = first; j < last; j++){
            if (A[j] <= x){
                i++;
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
        }
        int tmp = A[i + 1];
        A[i + 1] = A[last];
        A[last] = tmp;
        return i + 1;
    }

    private void quickSort(int[] A, int first, int last){
        if (first < last){
            int pivot = partition(A, first, last);
            quickSort(A, first, pivot - 1);
            quickSort(A, pivot + 1, last);
        }
    }

    @Override
    public void sort(int[] A) {
        quickSort(A, 0, A.length - 1);
    }
}
