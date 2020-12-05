import java.util.ArrayList;
import java.util.List;

/**
 * @Author p'c
 * @Date 2020/11/23 18:57
 * @Version 1.0
 */
public class Main {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    private static TreeNode buildTreeByList(List<Integer> preorderList, List<Integer> inorderList) {
        if (preorderList.isEmpty()) {
            return null;
        }

        int rootVal = preorderList.get(0);
        int rootIndex = inorderList.indexOf(rootVal);
        int leftTreeSize = rootIndex;

        List<Integer> leftSubTreePreorderList = preorderList.subList(1, 1 + leftTreeSize);
        List<Integer> leftSubTreeInorderList = inorderList.subList(0, 0 + leftTreeSize);
        TreeNode leftSubTreeRoot = buildTreeByList(leftSubTreePreorderList, leftSubTreeInorderList);

        List<Integer> rightSubTreePreorderList = preorderList.subList(1 + leftTreeSize, preorderList.size());
        List<Integer> rightSubTreeInorderList = inorderList.subList(leftTreeSize + 1, inorderList.size());
        TreeNode rightSubTreeRoot = buildTreeByList(rightSubTreePreorderList, rightSubTreeInorderList);

        TreeNode root = new TreeNode(rootVal);
        root.left = leftSubTreeRoot;
        root.right = rightSubTreeRoot;

        return root;
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> preorderList = arrayToList(preorder);
        List<Integer> inorderList = arrayToList(inorder);

        return buildTreeByList(preorderList, inorderList);
    }

    private static List<Integer> arrayToList(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int e : array) {
            list.add(e);
        }
        return list;
    }

}