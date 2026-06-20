public class SubtreeOfAnotherTree {
    static void main() {
        TreeNode node0 = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2, node0, null);
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4, node1, node3);

        TreeNode root = new TreeNode(3, node4, node5);
        TreeNode subRoot = new TreeNode(4, node1, node2);

        System.out.println(isSubtree(root, subRoot));
    }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (subRoot == null) return true;
        if (root == null) return false;

        if (root.val == subRoot.val && isSameTree(root, subRoot)) return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null) {
            return q == null;
        }

        if (q == null) {
            return false;
        }

        if (p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}