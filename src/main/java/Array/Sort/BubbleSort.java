package Array.Sort;

public class BubbleSort implements Sort{

    @Override
    public void sort(int[] A) {
        boolean exchanged = true;
        while (exchanged){
            exchanged = false;
            for (int i = 0; i < A.length - 1; i++){
                if (A[i] > A[i + 1]){
                    exchanged = true;
                    int tmp = A[i];
                    A[i] = A[i + 1];
                    A[i + 1] = tmp;
                }
            }
        }
    }
}
