import java.util.*;

/**
 *  Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 *
 *  Note: You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 *
 *  Follow up: What if the BST is modified (insert/delete operations) often and you need to find the
 *  kth smallest frequently? How would you optimize the kthSmallest routine?
 */
public class KthSmallest {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(10);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(12);

        System.out.println(kthSmallest(root,2));
    }

    static int kthSmallest(TreeNode root, int k) {
        ArrayList<TreeNode> nums = new ArrayList<>();
        kthSmallest(root, nums);
        return nums.get(k-1).val;
    }

    static void kthSmallest(TreeNode root, ArrayList<TreeNode> nums) {
        if (root == null) return;
        kthSmallest(root.left, nums);
        nums.add(root);
        kthSmallest(root.right, nums);
    }

    /**
     *  Algorithm Design
     *
     *  Solution 1: Keep a counter up to the kth element O(k), k can go all the way up to n so k == n
     *      Use a stack to to insert the TreeNodes into using root, right node, left node order
     *      Pop the stack k times to get the kth smallest element
     *
     */

    /*
    public static int kthSmallest(TreeNode root, int k) {
        if(root == null) throw new IllegalArgumentException("Invalid input!");

        int kthSmallest = 0;

        Queue<TreeNode> queue = new LinkedList<>();

        Stack<Integer> stackResult = new Stack<>();

        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode tmp = queue.remove();
            stackResult.push(tmp.val);
            if(tmp.left != null) stackHolder.push(tmp.left);
            if(tmp.right != null) stackHolder.push(tmp.right);
        }

        while(!stackResult.isEmpty()) System.out.println(stackResult.pop().val);


        while(k > 0) {
            kthSmallest = stackResult.pop().val;
            --k;
        }

        return kthSmallest;
    }*/

    private static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

}
