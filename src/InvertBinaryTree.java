import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
    static void main() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node9 = new TreeNode(9);

        TreeNode node2 = new TreeNode(2, node1, node3);
        TreeNode node7 = new TreeNode(7, node6, node9);

        TreeNode root = new TreeNode(4, node2, node7);

        printLevelOrder(root);
        printLevelOrder(invertTree(root));
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        swapChilds(root);
        return root;
    }

    private static void swapChilds(TreeNode node) {
        if (node == null) return;

        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;

        swapChilds(node.left);
        swapChilds(node.right);
    }

    public static void printLevelOrder(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        System.out.print("[");
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.val);

            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);

            if (!queue.isEmpty()) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}