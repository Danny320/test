import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class Main {
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        for(int i = 0; i < A.length; i++) {
            int tmp = 1;
            for(int j = 0; j < A.length; j++) {
                if(i!=j) {
                    tmp*=A[j];
                }
            }
            B[i] = tmp;
        }
        return B;
    }
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Character,Integer> map = new HashMap<>();
        String str = sc.nextLine();
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(!map.containsKey(ch)) {
                map.put(ch,1);
            }else {
                int tmp = map.get(ch);
                map.put(ch,tmp+1);
            }
        }
        Set<Character> set = map.keySet();
        for (char a: set) {
            System.out.println(a+":"+map.get(a));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {3,6,1,8,2,9};
        int k = sc.nextInt();
        for(int i = 0; i < k; i++) {
            boolean flag = false;
            for(int j = 0; j < arr.length-1-i; j++) {
                if(arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    flag = true;
                }
            }
            if(flag == false) {
                break;
            }
        }
        System.out.println(arr[arr.length-k]);

    }
}