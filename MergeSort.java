public class MergeSort {
    int array[];
    int tempmArr[];
    int length;
public static void main(String[] args) {
        int inputArr[] = { 36,19,13,48,21 };
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(inputArr);
        for(int i:inputArr){
            System.out.println(i+" ");
        }
}

    public void sort(int inputArr[]) {
        this.array = inputArr;
        this.length = inputArr.length;
        this.tempmArr = new int[length];
        divideArray(0, length - 1);
    }

    //list dividing
    public void divideArray(int lindex, int hindex) {
        if (lindex < hindex) {
            int middle = lindex + (hindex - lindex) / 2;
            //sort lside arr
            divideArray(lindex, middle);
            //sort rside arr
            divideArray(middle + 1, hindex);
            merge(lindex, middle, hindex);
        }

    }

    public void merge(int lindex, int middle, int hindex) {
        for (int i = lindex; i <= hindex; i++) {
            tempmArr[i] = array[i];
        }
        int i = lindex;
        int j = middle;
        int k = lindex;
        while (i <= middle && j <= hindex) {
            if (tempmArr[i] <= tempmArr[j]) {
                array[k] = tempmArr[i];
                i++;
            } else {
                array[k] = tempmArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempmArr[i];
            k++;
            i++;
        }
    }
}

