import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author ：LD
 * @description：TODO
 * @date ：2021/1/10 15:16
 */
public class Sort {
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    /**
     * 时间复杂度：
     * 最坏情况是O（n^2）最好情况(有序) O(n);
     * 越有序越快
     * 空间复杂度 O(1)
     * 稳定性：稳定
     * （如果是稳定的排序，就没有跳跃式的交换）
     * @param arr
     */

    //直接插入排序：每次选择无序区间的第一个数在有序区间的合适位置插入
//    public static void insertSort(int[] arr) {
//        int j;
//        int tmp;
//        for(int i = 1; i < arr.length; i++) {
//              tmp = arr[i];
//            for(j = i-1; j >= 0; j--) {
//                if(arr[j] > tmp) {
//                    arr[j+1] = arr[j];
//                }else  {
//                    break;
//                }
//            }
//            arr[j+1] = tmp;
//        }
//    }
//
//    public static void insertSort(int[] arr) {
//        for(int i = 1; i < arr.length; i++) {
//            int tmp = arr[i];
//            int j;
//            for(j = i-1; j >= 0; j--) {
//                if(tmp < arr[j]) {
//                    arr[j+1] = arr[j];
//                }else {
//                    break;
//                }
//            }
//            arr[j+1] = tmp;
//        }
//    }
    public static void insertSort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j = 0;
            for(j = i-1; j >= 0; j--) {
                if(tmp < arr[j]) {
                    arr[j+1] = arr[j];
                }else {
                    break;
                }
            }
            arr[j+1] = tmp;
        }

    }
//    /**
//     * 希尔排序：采用分组的思想组内进行直接插入排序
//     *
//     * @param arr
//     */
//    public static void shellSort(int[] arr ) {
//        int[] drr = {5,3,1};
//        int grap;
//        for(int n = 0; n < drr.length; n++) {
//            grap = drr[n];
//            shell(arr,grap);
//
//        }
//    }
//    public static void shell(int[] arr,int grap) {
//        int j;
//        int tmp;
//        for(int i = grap; i < arr.length; i++) {
//            tmp = arr[i];
//            for(j = i-grap; j >= 0; j-=grap) {
//                if(arr[j] > tmp) {
//                    arr[j+grap] = arr[j];
//                }else  {
//                    break;
//                }
//            }
//            arr[j+grap] = tmp;
//        }
//    }

    public static void shellSort(int[] arr) {
        int[] drr = {5,3,1};
        int grap;
        for(int i = 0; i < drr.length; i++) {
            grap = drr[i];
            shell(arr,grap);
        }
    }
    public static void shell(int[] arr,int grap) {
        for(int i = grap; i < arr.length; i++) {
            int tmp = arr[grap];
            int j;
            for(j = i-grap; j >= 0; j-=grap) {
                if(tmp < arr[j]) {
                    arr[j+grap] = arr[j];
                }else {
                    break;
                }
            }
            arr[j+grap] = tmp;
        }
    }
//
//
//
//
//    /**
//     * 选择排序:每次从无序区间选择一个合适的数放到有序区间的末尾
//     * 时间复杂度：O(n^2)
//     * 空间复杂度：O(1)
//     * 稳定性：不稳定
//     * @param arr
//     */
//    public static void selectSort(int[] arr) {
//        for(int i = 0 ; i <arr.length-1; i++) {
//            for(int j = i+1; j < arr.length; j++) {
//                if(arr[j] < arr[i]) {
//                    int tmp = arr[j];
//                    arr[j] = arr[i];
//                    arr[i] = tmp;
//                }
//            }
//        }
//    }

//    public static void selectSort(int[] arr) {
//        for(int i = 0; i < arr.length-1; i++) {
//            for(int j = i+1; j < arr.length; j++) {
//                if(arr[j] < arr[i]) {
//                    int tmp = arr[j];
//                    arr[j] = arr[i];
//                    arr[i] = tmp;
//                }
//            }
//        }
//    }
    public static void selectSort(int[] arr) {
        for(int i = 0; i < arr.length-1; i++) {
            for(int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[i]) {
                    int tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                }
            }
        }
    }
//
//
//    /**
//     * 堆排序
//     * 时间复杂度：O(nlogn)
//     * 空间复杂度：O(1)
//     * 稳定性：不稳定
//     * @param
//     */
//    public static void cerateHeap(int[] arr) {
//        for(int i = (arr.length-1-1)/2; i >= 0; i--) {
//            adjustDown(arr,i,arr.length);
//        }
//    }
//    public static void adjustDown(int[] arr,int root,int len) {
//        int parent = root;
//        int child = 2*parent+1;
//        while(child < len) {
//            if ((child + 1) < len && arr[child+1] > arr[child]) {
//                child++;
//            }
//            if(arr[child] > arr[parent]) {
//                int tmp = arr[child];
//                arr[child] = arr[parent];
//                arr[parent] = tmp;
//                parent = child;
//                child = 2*parent+1;
//            }else {
//                break;
//            }
//        }
//    }
//    public static void heapSort(int[] arr) {
//        cerateHeap(arr);
//         int end = arr.length-1;
//         while(end > 0) {
//             int tmp = arr[0];
//             arr[0] = arr[end];
//             arr[end] = tmp;
//             adjustDown(arr,0,end);
//             end--;
//         }
//    }


//    public static void heapSort(int[] arr) {
//        createHeap(arr);
//        int end = arr.length-1;
//        while(end > 0) {
//            int tmp = arr[end];
//            arr[end] = arr[0];
//            arr[0] = tmp;
//            adjustDown(arr,0,end);
//            end--;
//        }
//    }
//    public static void createHeap(int[] arr) {
//        for(int i = (arr.length-1-1)/2; i >= 0; i++) {
//            adjustDown(arr,i,arr.length);
//        }
//    }
//    public static void adjustDown(int[] arr,int root,int len) {
//        int parent = root;
//        int child = 2*parent+1;
//        while(child < len) {
//            if((child+1) < len && arr[child+1] > arr[child]) {
//                child++;
//            }
//            if(arr[child] > arr[parent]) {
//                int tmp = arr[child];
//                arr[child] = arr[parent];
//                arr[parent] = tmp;
//            }else {
//                break;
//            }
//        }
//    }
    public static void heapSort(int[] arr) {
        createHeap(arr);
        int end = arr.length-1;
        while (end > 0) {
            int tmp = arr[0];
            arr[0] = arr[end];
            arr[end] = tmp;
            adjustDown(arr,0,end);
            end--;
        }
    }

    private static void createHeap(int[] arr) {
        for(int i = (arr.length-1-1)/2; i >= 0; i--) {
            adjustDown(arr,i,arr.length);
        }

    }

    private static void adjustDown(int[] arr, int root, int length) {
        int parent = root;
        int child = 2*parent+1;
        while(child < length) {
            if(child+1<length && arr[child+1] > arr[child]) {
                child++;
            }
            if(arr[child] > arr[parent]) {
                int tmp = arr[child];
                arr[child] = arr[parent];
                arr[parent] = tmp;
                parent = root;
                child = 2*parent+1;
            }else {
                break;
            }
        }
    }

    //
//    /**
//     * 冒泡排序
//     * 时间复杂度：最坏O(n^2)，最好O(n)
//     * 空间复杂度：O(1)
//     * 稳定性：稳定
//     * @param
//     */
//    public static void bobbleSort(int[] arr) {
//        for(int i = 0; i < arr.length-1; i++) {
//            boolean flag = true;
//            for(int j = 0; j < arr.length-1-i;j++) {
//                if(arr[j] > arr[j+1]) {
//                    int tmp = arr[j];
//                    arr[j] = arr[j+1];
//                    arr[j+1] = tmp;
//                    flag = false;
//                }
//            }
//            if(flag) {
//                break;
//            }
//        }
//    }
//
    public static void bubbleSort(int[] arr) {
        for(int i = 0; i < arr.length-1; i++) {
            boolean flag = true;
            for(int j = 0; j < arr.length-1-i; j++) {
                if(arr[j] >arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    flag = false;
                }
            }
            if(flag) {
                break;
            }
        }
    }

//
//    /**
//     * 快速排序
//     * 时间复杂度：O(nlogn) 最坏：O(n^2)
//     * 空间复杂度:logn
//     * 稳定性：不稳定
//     * @param
//     */
//
//    public static void quickSort(int[] arr) {
//        quick(arr,0,arr.length-1);
//    }
//    public static void quick(int[] arr,int left,int right) {
//        if(left >= right) {
//            return;
//        }
//        int par = partition(arr,left,right);
//        quick(arr,left,par-1);
//        quick(arr,par+1,right);
//    }
//    public static int partition(int[] arr,int low,int high) {
//        int tmp = arr[low];
//        while(low < high) {
//            while (low < high && arr[high] >= tmp) {
//                high--;
//            }
//            arr[low] = arr[high];
//            while (low < high && arr[low] <= tmp) {
//                low++;
//            }
//            arr[high] = arr[low];
//        }
//        arr[low] = tmp;
//        return low;
//    }


//    public static void quickSort(int[] arr) {
//        quick(arr,0,arr.length-1);
//    }
//    public static void quick(int[] arr,int left,int right) {
//        if(left >= right) {
//            return;
//        }
//        int par = partation(arr,left,right);
//        quick(arr,left,par-1);
//        quick(arr,par+1,right);
//    }
//    public static int partation(int[] arr,int low,int high) {
//        int tmp = arr[low];
//        while (low < high) {
//            while (low < high && arr[high] >= tmp) {
//                high--;
//            }
//            arr[low] = arr[high];
//            while(low < high && arr[low] <= tmp) {
//                low++;
//            }
//            arr[high] = arr[low];
//        }
//        arr[low] = tmp;
//        return low;
//    }
    public static void quickSort(int[] arr) {
        quick(arr,0,arr.length-1);
    }

    private static void quick(int[] arr, int left, int right) {
        if(left >= right) {
            return;
        }
        int par = partation(arr,left,right);
        quick(arr,left,par-1);
        quick(arr,par+1,right);
    }

    private static int partation(int[] arr, int low, int hight) {
        int tmp = arr[low];
        while(low < hight) {
            while(low < hight && arr[hight] > tmp) {
                hight--;
            }
            arr[low] = arr[hight];
            while(low < hight && arr[low] < tmp) {
                low++;
            }
            arr[hight] = arr[low];
        }
        arr[low] = tmp;
        return low;
    }

    /**
     * 归并排序
     *稳定性：稳定
     * 时间复杂度：nlogn
     * 空间复杂度：O(n)
     * @param arr
     */
//    public static void mergeSort(int[] arr) {
//        mergeSortInternal(arr, 0, arr.length - 1);
//
//    }
//    public static void mergeSortInternal(int[] arr, int low, int high) {
//        if(low >= high) {
//            return;
//        }
//        int mid = (low+high)/2;
//        mergeSortInternal(arr,low,mid);
//        mergeSortInternal(arr,mid+1,high);
//        merge(arr,low,mid,high);
//    }
//    public static void merge(int[] arr,int low,int mid,int high) {
//        int s1 = low;
//        int s2 = mid+1;
//        int len = high-low+1;
//        int[] ret = new int[len];
//        int i = 0;
//        while(s1 <= mid && s2 <= high) {
//            if(arr[s1] <= arr[s2]) {
//                ret[i++] = arr[s1++];
//            }else {
//                ret[i++] = arr[s2++];
//            }
//        }
//        while(s1 <= mid) {
//            ret[i++] = arr[s1++];
//        }
//        while(s2 <= high) {
//            ret[i++] = arr[s2++];
//        }
//        for(int j = 0; j <ret.length; j++) {
//            arr[j+low] = ret[j];
//        }
//    }


//    public static void mergeSort(int[] arr) {
//        mergeInternal(arr,0,arr.length-1);
//    }
//
//    public static void mergeInternal(int[] arr, int left, int right) {
//        if(left >= right) {
//            return;
//        }
//        int mid = (left+right)/2;
//        mergeInternal(arr,left,mid);
//        mergeInternal(arr,mid+1,right);
//        merge(arr,left,mid,right);
//    }
//    public static void merge(int[] arr, int low,int mid,int high) {
//        int s1 = low;
//        int s2 = mid+1;
//        int len = high-low+1;
//        int[] ret = new int[len];
//        int i = 0;++
//        while(s1 <= mid && s2 <= high) {
//            if(arr[s1] < arr[s2]) {
//                ret[i++] = arr[s1++];
//            }else {
//                ret[i++] = arr[s2++];
//            }
//        }
//        while(s1 <= mid) {
//            ret[i++] = arr[s1++];
//        }
//        while (s2 <= high) {
//            ret[i++] = arr[s2++];
//        }
//        for(int j = 0; j < ret.length; j++) {
//            arr[j+low] = ret[j];
//        }
//
//    }




    public static void main(String[] args) {
        int arr[] = {1,4,6,8,3,4,9,0};
//        insertSort(arr);
//        System.out.println(Arrays.toString(arr));
//
//        shellSort(arr);
//        System.out.println(Arrays.toString(arr));

//        selectSort(arr);
//        System.out.println(Arrays.toString(arr));
//        heapSort(arr);
//        System.out.println(Arrays.toString(arr));
        quickSort(arr);
        System.out.println(Arrays.toString(arr));


    }


}
