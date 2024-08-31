import java.util.*;
public class BTSumOfNodesAtK {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int indx = -1;

        public static Node buildTree(int[] nodes) {
            indx++;
            if (nodes[indx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[indx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    public static int sumAtLevelK(Node root, int k) {
        return sumAtLevelKHelper(root, k, 0);
    }

    private static int sumAtLevelKHelper(Node root, int k, int currentLevel) {
        if (root == null) {
            return 0;
        }

        if (currentLevel == k) {
            return root.data;
        }

        int leftSum = sumAtLevelKHelper(root.left, k, currentLevel + 1);
        int rightSum = sumAtLevelKHelper(root.right, k, currentLevel + 1);

        return leftSum + rightSum;
    }

    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the level (k) to find the sum of nodes: ");
        int k = scanner.nextInt();
        scanner.close();

        int sum = sumAtLevelK(root, k);
        System.out.println("Sum of nodes at level " + k + " is: " + sum);
    }
}
