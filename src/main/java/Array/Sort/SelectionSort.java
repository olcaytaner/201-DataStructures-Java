package Array.Sort;

public class SelectionSort implements Sort{
    @Override
    public void sort(int[] A) {
        for (int i = 0; i < A.length - 1; i++){
            int min = A[i];
            int pos = i;
            for (int j = i + 1; j < A.length; j++){
                if (A[j]< min){
                    min = A[j];
                    pos = j;
                }
            }
            if (pos != i){
                A[pos] = A[i];
                A[i] = min;
            }
        }
    }
}
