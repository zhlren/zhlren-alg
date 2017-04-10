package zhlren.ltcd.alg;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by bjrenzhili on 17/4/10.
 */
public class Pb107 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> list = new LinkedList<List<Integer>>();
        level(list, root, 0);
        return list;
    }

    private void level(LinkedList<List<Integer>> list, TreeNode node, int l) {
        if (null == node) {
            return;
        }
        if (l > list.size() - 1) {
            list.add(0, new LinkedList<Integer>());
        }

        list.get(list.size() - 1 - l).add(node.val);

        level(list, node.left, l + 1);
        level(list, node.right, l + 1);
    }

    @Test
    public void test() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        System.out.println(levelOrderBottom(treeNode1));
    }
}
