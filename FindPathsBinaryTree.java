import java.util.LinkedList;
import java.util.List;

/**
 * Finds all paths in a binary tree
 */
public class FindPathsBinaryTree {

    public static void main(String[] args) {
        Node root = new Node(7);
        root.left = new Node(3);
        root.left.left = new Node(0);
        root.left.right = new Node(5);
        root.right = new Node(12);
        root.right.left = new Node(9);
        root.right.right = new Node(17);
        List<Node> list = new LinkedList<>();
        printPaths(root);
    }

    /* Given a binary tree, print out all of its root-to-leaf
     paths, one per line. Uses a recursive helper to do the work.*/
    static void printPaths(Node node) {
        int path[] = new int[1000];
        printPathsRecur(node, path, 0);
    }

    /* Recursive helper function -- given a node, and an array containing
     the path from the root node up to but not including this node,
     print out all the root-leaf paths. */
    static void printPathsRecur(Node node, int path[], int pathLen) {
        if (node == null) {
            return;
        }

        /* append this node to the path array */
        path[pathLen] = node.data;
        pathLen++;

        /* it's a leaf, so print the path that led to here */
        if (node.left == null && node.right == null) {
            printArray(path, pathLen);
        } else {

            /* otherwise try both subtrees */
            printPathsRecur(node.left, path, pathLen);
            printPathsRecur(node.right, path, pathLen);
        }
    }

    /* Utility that prints out an array on a line */
    static void printArray(int ints[], int len) {
        int i;
        for (i = 0; i < len; i++) {
            System.out.print(ints[i] + " ");
        }
        System.out.println("");
    }

    private static class Node {
        int data;

        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

}
