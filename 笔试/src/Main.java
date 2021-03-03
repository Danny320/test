import java.lang.management.GarbageCollectorMXBean;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author ：LD
 * @description：TODO
 * @date ：2021/3/2 20:01
 */
public class Main {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        for(int i = 0; i < k; i++) {
            for(int j = 0; j < input.length-1-i; j++) {
                if(input[j+1] >input[j] ) {
                    int tmp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = tmp;
                }
            }
        }
       ArrayList<Integer> list = new ArrayList<>();
        for(int i = input.length-1; i >= k; i--) {
            list.add(input[i]);
        }
        return list;
    }
    public static ArrayList<Integer> GetLeastNumbers_Solution1(int[] input, int k) {
        Arrays.sort(input);
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] input = {9,2,3,1,5,6};
        int k = 3;
        ArrayList<Integer> list = GetLeastNumbers_Solution1(input,k);
        for (int i: list) {
            System.out.print(i);
        }
    }
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String str1 = "";
        int len = 0;
        int i = 0;
        for(; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch >= '0' && ch <= '9') {
                len++;
            }else {
                if(len > str1.length()) {
                    str1 = str.substring(i-len,i);
                }
                len = 0;
            }
        }
        if(len > str1.length()) {
            str1 = str.substring(i-len,i);
        }
        System.out.println(str1);
    }
}
