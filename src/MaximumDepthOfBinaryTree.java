public class MaximumDepthOfBinaryTree {
    static void main() {

        TreeNode node1 = new TreeNode(9);
        TreeNode node3 = new TreeNode(15);
        TreeNode node6 = new TreeNode(7);

        TreeNode node2 = new TreeNode(20, node3, node6);
        TreeNode root = new TreeNode(3, node1, node2);

        System.out.println(maxDepth(root));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int leftDept = maxDepth(root.left);
        int rightDept = maxDepth(root.right);

        return Math.max(leftDept, rightDept) + 1;
    }
}