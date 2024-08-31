public class BTisSubtreeidentical {

    // Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isIdentical(TreeNode root, TreeNode subRoot) {
        if (subRoot == null && root == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }
        if (root.val == subRoot.val) {
            return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
        }
        
        return false;
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (isIdentical(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public static void main(String[] args) {
        // Example usage:
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        TreeNode subRoot = new TreeNode(4);
        subRoot.left = new TreeNode(1);
        subRoot.right = new TreeNode(2);

        BTisSubtreeidentical checker = new BTisSubtreeidentical();
        System.out.println(checker.isSubtree(root, subRoot));  // Output: true
    }
}
