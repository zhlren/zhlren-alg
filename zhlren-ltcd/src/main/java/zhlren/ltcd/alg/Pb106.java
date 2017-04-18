package zhlren.ltcd.alg;

import org.junit.Test;

/**
 * Created by bjrenzhili on 17/4/18.
 */
public class Pb106 {

    /**
     *  DFS
     可以肯定后序遍历序列中最后一个数一定是当前二叉树的根节点root。又因为二叉树不存在相同的数，我们可以找到root在中序遍历中位置p。

     则我们可以分别找到两颗子树对应的中序和后序遍历：

     左子树的中序 = inOrder[1 .. p - 1]
     左子树的后序 = postOrder[1 .. p - 1]
     右子树的中序 = inOrder[p + 1 .. n]
     右子树的后序 = postOrder[p .. n - 1]
     在此基础上我们就可以递归处理两颗子树。

     当我们发现当前中序遍历和后序遍历长度都为 1 的时候，也就找到了叶子节点，此时我们开始回溯。
     */

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    @Test
    public void test() {
        int[] inorder = { 1, 2, 3, 4 };
        int[] postorder = { 4, 3, 2, 1 };
        TreeNode treeNode = buildTree(inorder, postorder);
        int i = 0;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildChildTree(inorder, postorder, 0, inorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode buildChildTree(int[] inorder, int[] postorder, int inorderStart, int inorderEnd, int postorderStart,
            int postorderEnd) {
        if (inorderStart == inorderEnd) {
            return new TreeNode(inorder[inorderEnd]);
        }
        else if (inorderEnd < inorderStart) {
            return null;
        }
        int newRootIndex = -1;
        int newRootValue = postorder[postorderEnd];
        TreeNode root = new TreeNode(newRootValue);
        for (int i = inorderStart; i <= inorderEnd; i++) {
            if (inorder[i] == newRootValue) {
                newRootIndex = i;
                break;
            }
        }
        if (null != root) {
            root.left = buildChildTree(inorder, postorder, inorderStart, newRootIndex - 1, postorderStart,
                    newRootIndex - 1 - inorderStart + postorderStart);
            root.right = buildChildTree(inorder, postorder, newRootIndex + 1, inorderEnd,
                    newRootIndex - inorderStart + postorderStart, postorderEnd - 1);
        }
        return root;
    }

}
