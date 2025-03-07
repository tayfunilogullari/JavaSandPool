import java.io.IOException;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


public class RecoverTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public TreeNode recoverFromPreorder(String traversal) {
        char[] arr = traversal.toCharArray();

        String[] nodeVals = traversal.split("-");

        int val = Integer.parseInt(nodeVals[0]);
        TreeNode node = new TreeNode(val);

        int depth = 0;

        for (int i = 1; i < nodeVals.length; i++) {
            String str = nodeVals[i];
            if (str != null && !str.isEmpty()) {
                val = Integer.parseInt(str);
                insertNode(node, val, depth, 0);
                depth = 0;
            }
            else {
                depth++;
            }
        }
        return node;
    }

    private boolean insertNode(TreeNode node, final int val, final int depth, int currentDepth) {
        if (node == null) {
            return false;
        }

        if (depth == currentDepth) {
            if (node.left == null) {
                node.left = new TreeNode(val);
                return true;
            }
            else if (node.right == null) {
                node.right = new TreeNode(val);
                return true;
            }
            return false;
        } else if (depth < currentDepth) {
            return false;
        }
        ++currentDepth;
        if (!insertNode(node.left, val, depth, currentDepth))
        {
            return insertNode(node.right, val, depth, currentDepth);
        }
        return true;
    }




    public static void main(String[] args) throws IOException {

        RecoverTree sen = new RecoverTree();

        TreeNode r = sen.recoverFromPreorder(new String("1-2--3--4-5--6--7"));

        System.out.println(r);
    }
}
