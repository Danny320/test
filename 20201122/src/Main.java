import java.util.Scanner;

/**
 * @Author p'c
 * @Date 2020/11/22 10:13
 * @Version 1.0
        */
public class Main {

    public static  void mergeSort(int[] arr) {
        mergeSortInternal(arr,0,arr.length);
    }
    private static void mergeSortInternal(int[] arr,int low,int high) {
        //求元素个数
        int size = high-low;
        //如果元素个数小于等于1直接返回
        if(size <= 1) {
            return;
        }
        //求中间位置
        int mid =(high+low) / 2;
        //把待排序区间平均分成两段
        //[low,mid)
        //{mid.high)
        //对左右两段按照相同的方式处理
        mergeSortInternal(arr,low,mid);
        mergeSortInternal(arr,mid,high);
        //左右两段已经各自有序
        //合并两个有序区间为一个有序区间
        int[] newArr = new int[size];
        int leftIndex = low;
        int rightIndex = mid;
        int newIndex = 0;
        //左区间内还有数（leftIndex < mid），并且右区间内还有数(rightIndex < high)
        while(leftIndex < mid && rightIndex < high) {

        }

    }
    public static void quickSort(int[] arr) {
        quickSortInternal(arr,0,arr.length-1);
    }
    private static void quickSortInternal(int[] arr, int low, int high){
        int size = high-low+1;
        if(size <= 1) {
            return;
        }
        int pivot = arr[low];
        int left = low;
        int right = high;
        while(left < right) {
            while(left < right && arr[right] >= pivot) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        quickSortInternal(arr,low,left-1);
        quickSortInternal(arr,left+1,high);
    }
    public static int binarySearch(int[] arr,int n) {
        int left = 0;
        int right = arr.length;
        //[left,right)
        int size = right-left;
        while(size > 0) {
            int mid = (right-left) / 2;
            if(n == arr[mid]) {
                return mid;
            }else if(n < arr[mid]) {
                right = mid;
            }else {
                left = mid+1;
            }
        }
        return -1;
    }

    public static void insertSort(int[] arr) {
        int ret = 0;
        for(int i = 1; i < arr.length; i++) {
            ret = arr[i];
            int j = i-1;
            for(; j >= 0; j--) {
                if(ret < arr[j]) {
                    arr[j+1] = arr[j];
                }else {
                    break;
                }
            }
            arr[j+1] = ret;
        }

    }
    public static void bubbleSort(int[] arr) {
        for(int i = 0; i < arr.length-1; i++) {
            boolean flag = true;
            for(int j = 0; j < arr.length-1-i;j++) {
                if(arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    flag = false;
                }
            }
            if(flag == true){
                break;
            }
        }
    }
    public static void func(int n) {
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n-i; j++) {
                System.out.print(" ");
            }
            for(int j = 0; j < i+1; j++) {
                System.out.print(" *");
            }
            System.out.println();
        }
        for(int i = 0; i < n+1; i++) {
            System.out.print(" *");
        }
        System.out.println();
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < i+1; j++) {
                System.out.print(" ");
            }
            for(int j = 0; j < n-i; j++) {
                System.out.print(" *");
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //int n = sc.nextInt();
        //func(n);
        int[] arr = {7,5,4,8,2,6,0};
//        bubbleSort(arr);
//        insertSort(arr);
//        for(int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i]+" ");
//        }
        int n =8;
        System.out.println(binarySearch(arr, n));
    }
}