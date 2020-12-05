import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class List {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            if(!map.containsKey(arr[i])) {
                map.put(arr[i],0);
            }else {
                int tmp = map.get(arr[i]);
                map.put(arr[i],tmp+1);
            }
        }
        for(int i = n/2; i<n; i++) {
            if(map.get(arr[i])>n/2) {
                System.out.println(arr[i]);
                return;
            }
        }
    }
}
