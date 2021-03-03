import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ：LD
 * @description：TODO
 * @date ：2021/1/14 19:07
 */
public class Solution {
    public static void maxLength (int[] arr) {
        // write code here
        int start = 0;
        int end = 0;
        int ret = 0;
        int[] arr1 = new int[9];
        int j = 0;
        Set<Integer> set = new HashSet<>();
        boolean flag = true;
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i])) {
                arr1[j++] = set.size();
                set.clear();
                set.add(arr[i]);
                flag = false;
            } else {
                set.add(arr[i]);
            }
        }
//        if(flag) {
//            //return set.size();
//        }
//        int tmp = arr1[0];
//        for (int i = 1; i < arr1.length; i++) {
//            if (arr1[i] > tmp) {
//                int n = arr1[i];
//                arr1[i] = tmp;
//                tmp = n;
//            }
//        }
//        return arr1[0];
        for(int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i]);
        }
    }

//    public static void quickSort(int[] arr) {
//         quick(arr,0,arr.length-1);
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
//        while(low < high) {
//            while(low < high && arr[high] >= tmp ) {
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

    public static void shellSort(int[] arr) {
        int[] drr = {5,3,1};
        for(int i = 0; i < drr.length; i++) {
            int flag = drr[i];
            shell(arr,flag);
        }
    }
    public static void shell(int[] arr, int flag) {
        for(int i = flag; i < arr.length; i++) {
            int tmp = arr[i];
            int j = 0;
            for(j = i-flag; j >= 0; j-=flag) {
                if(tmp < arr[j]) {
                    arr[j+flag] = arr[j];
                }else {
                    break;
                }
            }
            arr[j+flag] = tmp;
        }
    }

    public static void selectSort(int[] arr) {
        for(int i = 1; i < arr.length-1; i++) {
            for(int j =i+1; j < arr.length; j++) {
                if(arr[j] < arr[i]) {
                    int tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                }
            }
        }
    }

    public static void  heapSort(int[] arr) {
        crarteHeap(arr);
        int end = arr.length-1;
        while(end > 0) {
            int tmp = arr[0];
            arr[0] = arr[end];
            arr[end] = tmp;
            adjustDown(arr,0,end);
            end--;
        }
    }
    public static void crarteHeap(int[] arr) {
        for(int i = (arr.length-1-1)/2; i >= 0; i--) {
            adjustDown(arr,i,arr.length);
        }
    }
    public static void adjustDown(int[] arr,int root,int len) {
        int parent = root;
        int child = 2*parent+1;
        while(child < len) {
            if((child+1) < len && arr[child+1] > arr[child]) {
                child++;
            }
            if(arr[child] > arr[parent]) {
                int tmp = arr[child];
                arr[child] = arr[parent];
                arr[parent] = tmp;
                parent = child;
                child = 2*parent+1;
            }else {
                break;
            }
        }
    }

    public static void bubbleSort(int[] arr) {
        for(int i = 0; i < arr.length-1;i++) {
            boolean flag = true;
            for(int j = 0; j < arr.length-1-i; j++) {
                if(arr[j] > arr[j+1]) {
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


    public enum haha{

    }
    public static void main(String[] args) {
        int[] arr = {2,2,7,4,5};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
        maxLength(arr);
        //System.out.println(maxLength(arr));
    }
}
