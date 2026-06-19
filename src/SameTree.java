public class SameTree {
    static void main() {

        TreeNode node3 = new TreeNode(2);

        TreeNode p = new TreeNode(1, node3, null);
        TreeNode q = new TreeNode(1, null, node3);

        System.out.println(isSameTree(p, q));
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
