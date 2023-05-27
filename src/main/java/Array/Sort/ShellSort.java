package Array.Sort;

public class ShellSort implements Sort{

    private int[] H;

    public ShellSort(int[] H){
        this.H = H;
    }

    @Override
    public void sort(int[] A) {
        for (int k = 0; k < H.length; k++){
            int increment = H[k];
            for (int j = increment; j < A.length; j++){
                int t = A[j];
                int i = j - increment;
                while (i >= 0 && A[i] > t){
                    A[i + increment] = A[i];
                    i -= increment;
                }
                A[i + increment] = t;
            }
        }
    }
}
