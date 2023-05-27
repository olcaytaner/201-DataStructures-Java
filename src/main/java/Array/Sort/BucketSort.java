package Array.Sort;

public class BucketSort implements Sort{

    private int maxValue;

    public BucketSort(int maxValue){
        this.maxValue = maxValue;
    }

    @Override
    public void sort(int[] A) {
        int[] C = new int[maxValue];
        int[] B = new int[A.length];
        for (int i = 0; i < A.length; i++){
            C[A[i]]++;
        }
        for (int i = 1; i < maxValue; i++){
            C[i] += C[i - 1];
        }
        for (int i = A.length - 1; i >= 0; i--){
            B[C[A[i]] - 1] = A[i];
            C[A[i]]--;
        }
        for (int i = 0; i < A.length; i++){
            A[i] = B[i];
        }
    }
}
