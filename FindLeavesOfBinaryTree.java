import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**

    Find all of the leaves of a binary tree

                5
            /       \
        3               10
    /       \       /       \
   0               4        15
                           /
                          12

 */
public class FindLeavesOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(10);
        root.right.right = new TreeNode(15);
        root.right.right.left = new TreeNode(12);
        System.out.println(findLeaves(root));
    }

    private static int findLeaves(TreeNode root) {
        if(root == null) throw new IllegalArgumentException("invalid input");
        Queue<TreeNode> queue = new LinkedList<>();
        List<TreeNode> leaves = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            if(tmp.left != null) queue.add(tmp.left);
            if(tmp.right != null) queue.add(tmp.right);
            if(tmp.left == null && tmp.right == null) leaves.add(tmp);
        }

        for(TreeNode n : leaves)
            System.out.println(n.data);

        return leaves.size();
    }

    private static void traverse(TreeNode root) {
        if(root == null) return;
        traverse(root.left);
        System.out.println(root.data);
        traverse(root.right);
    }

    private static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int d) {
            this.data = d;
            this.left = null;
            this.right = null;
        }
    }

}
