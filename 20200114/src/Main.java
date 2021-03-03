import java.util.*;

/**
 * @author ：LD
 * @description：TODO
 * @date ：2021/1/14 17:14
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = {3,5,7,9,2,9,1,56,8};
        //topK(arr,5);
        Arrays.sort(arr);
        int tmp = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > tmp) {
                int n = arr[i];
                arr[i] = tmp;
                tmp = n;
            }
        }
    }
    public static void topK(int[] arr, int k) {
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(int i = 0; i < arr.length; i++) {
            if(i < k) {
                queue.offer(arr[i]);
            }
            int tmp = queue.peek();
            if(arr[i] < tmp) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for (int i:queue) {
            System.out.println(i);
        }
    }
}
