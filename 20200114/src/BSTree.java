/**
 * @author ：LD
 * @description：TODO
 * @date ：2021/1/16 10:15
 */

/**
 * 二叉搜索树
 */
public class BSTree {
    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node(int val) {
            this.val = val;
        }
    }

    public Node root = null;
    public  boolean insert(int val) {
        Node node = new Node(val);
        if(root == null) {
            this.root = node;
            return true;
        }
         Node cur = root;
        Node prev = null;
        while(cur != null) {
            if(val < cur.val) {
                prev = cur;
                cur = cur.left;
            }else if(val > cur.val) {
                prev = cur;
                cur = cur.right;
            }else {
                return false;
            }
        }
        if(val < prev.val) {
            prev.left = node;
        }else {
            prev.right = node;
        }
        return true;
    }
    public void preOrder(Node root) {
        if(this.root == null) {
            return;
        }
        System.out.println(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

}
