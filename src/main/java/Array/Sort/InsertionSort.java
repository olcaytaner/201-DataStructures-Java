package Array.Sort;

public class InsertionSort implements Sort{

    @Override
    public void sort(int[] A) {
        for (int j = 1; j < A.length; j++){
            int t = A[j];
            int i = j - 1;
            while (i >= 0 && A[i] > t){
                A[i + 1] = A[i];
                i--;
            }
            A[i + 1] = t;
        }
    }
}
