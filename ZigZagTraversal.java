import java.util.*;

/**

 Testing Binary Trees and Binary Search Trees

 */
public class ZigZagTraversal {

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.left.left = new Node(0);
        root.left.right = new Node(4);
        root.right = new Node(10);
        root.right.left = new Node(8);
        root.right.right = new Node(9);
        List<List<Node>> res = zigzagOrder(root);
        print(res);
    }

    private static void print(List<List<Node>> res) {
        for(List<Node> l : res) {
            for(Node n : l) {
                System.out.print(n.data + " ");
            }
            System.out.println();
        }
    }

    // traverse in zigzag order
    private static List<List<Node>> zigzagOrder(Node root) {
        if(root == null) throw new IllegalArgumentException("invalid input");
        Queue<Node> queue = new LinkedList<>();
        List<List<Node>> res = new ArrayList<>();
        Node curr = root;
        queue.add(curr);
        int currLevel = 0;
        int numCurrNodes = 1;
        int numNextNodes = 0;
        while(!queue.isEmpty()) {

            List<Node> list = new ArrayList<>();

            // odd level
            while(numCurrNodes-- > 0) {
                Node tmp = queue.poll();

                if (currLevel % 2 != 0)
                    list.add(tmp);
                else if (currLevel % 2 == 0)
                    list.add(0,tmp);

                if(tmp.left != null) {
                    queue.add(tmp.left);
                    ++numNextNodes;
                }
                if(tmp.right != null) {
                    queue.add(tmp.right);
                    ++numNextNodes;
                }

            }

            ++currLevel;
            numCurrNodes = numNextNodes;
            numNextNodes = 0;
            res.add(list);
        }

        return res;
    }

    private static class Node {
        int data;
        Node left, right;
        protected Node(int d) {
            this.data = d;
            this.left = null;
            this.right = null;
        }
    }

}
