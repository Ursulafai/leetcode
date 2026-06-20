import java.util.HashMap;
import java.util.Map;

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

        Map<TreeNode, Long> hashMap = new HashMap<>();
        computeHash(root, hashMap);

        long subHash = computeHash(subRoot, new HashMap<>());

        return hashMap.containsValue(subHash);
    }

    private static long computeHash(TreeNode node, Map<TreeNode, Long> hashMap) {
        if (node == null) return 0;

        long leftHash = computeHash(node.left, hashMap);
        long rightHash = computeHash(node.right, hashMap);

        long leftExists = (node.left != null) ? 1 : 0;
        long rightExists = (node.right != null) ? 1 : 0;

        long hash = 31L * node.val + 17L * leftHash + 13L * rightHash
                + 7L * leftExists + 5L * rightExists;;

        hashMap.put(node, hash);

        return hash;
    }

}