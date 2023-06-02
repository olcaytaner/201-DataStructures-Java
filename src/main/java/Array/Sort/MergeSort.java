package Array.Sort;

public class MergeSort implements Sort{

    private void merge(int[] A, int start, int middle, int end){
        int leftCount = middle - start + 1;
        int rightCount = end - middle;
        int[] leftPart = new int[leftCount + 1];
        int[] rightPart = new int[rightCount + 1];
        for (int i = 0; i < leftCount; i++){
            leftPart[i] = A[start + i];
        }
        for (int i = 0; i < rightCount; i++){
            rightPart[i] = A[middle + i + 1];
        }
        leftPart[leftCount] = Integer.MAX_VALUE;
        rightPart[rightCount] = Integer.MAX_VALUE;
        int i = 0, j = 0;
        for (int k = start; k <= end; k++){
            if (leftPart[i] <= rightPart[j]){
                A[k] = leftPart[i];
                i++;
            } else {
                A[k] = rightPart[j];
                j++;
            }
        }
    }

    private void mergeSort(int[] A, int first, int last){
        if (first < last){
            int pivot = (first + last) / 2;
            mergeSort(A, first, pivot);
            mergeSort(A, pivot + 1, last);
            merge(A, first, pivot, last);
        }
    }

    @Override
    public void sort(int[] A) {
        mergeSort(A, 0, A.length - 1);
    }
}
