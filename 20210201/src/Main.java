/**
 * @author ：LD
 * @description：TODO
 * @date ：2021/2/1 20:33
 */
public class Main {

      class ListNode {
          public ListNode(int val) {
              this.val = val;

          }
        int val;
        ListNode next = null;
     }

    public ListNode addInList (ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        // write code here
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        while (head1 != null) {
            str1.append("" + head1.val);
        }
        while (head2 != null) {
            str2.append("" + head2.val);
        }
        int a = Integer.parseInt(str1.toString());
        int b = Integer.parseInt(str2.toString());
        int c = a + b;
        int v = 0;
        ListNode ret = new ListNode(-1);
        ListNode Next = ret;
        while (c != 0) {
            v = c % 10;
            c = c / 10;
            ListNode cur = new ListNode(v);
            Next.next = cur;
            Next = cur;
        }
        return ret.next;
    }

    public static void main(String[] args) {
        
    }
}
