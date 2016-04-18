import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by User1 on 4/17/16.
 */
public class BT_Level_Order {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(6);
        root.right = new TreeNode(12);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(15);
        List<List<Integer>> results = levelOrder(root);
    }

    static List<List<Integer>> levelOrder (TreeNode root) {
        if(root == null) return new LinkedList();
        List<List<Integer>> nodes = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode curr = root;
        queue.add(curr);
        int level = 0;
        int nodeCounter = 1;
        int numNodesPerLevel = 1;
        while(!queue.isEmpty()) {

            nodeCounter = numNodesPerLevel;
            numNodesPerLevel = 0;
            nodes.add(new LinkedList());

            while(nodeCounter > 0) {
                TreeNode tmp = queue.remove();
                nodes.get(level).add(tmp.val);
                if (tmp.left != null) {
                    queue.add(tmp.left);
                    ++numNodesPerLevel;
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                    ++numNodesPerLevel;
                }
                --nodeCounter;
            }
            ++level; // move to the next level
        }
        return nodes;
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {
            this.val = x;
        }
    }

}
