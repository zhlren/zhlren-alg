package zhlren.ltcd.alg.tree;

import jdk.nashorn.internal.ir.IfNode;

import java.util.*;

/**
 * Created by baidu on 2017/4/15.
 */
public class PostOrderTravel {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }

    public void posterTravel(TreeNode root){
        if (null == root || (null == root.left && null == root.right)){
            return;
        }
        List<TreeNode> res = new LinkedList<zhlren.ltcd.alg.tree.PostOrderTravel.TreeNode>();
        Stack<TreeNode> stack = new Stack<zhlren.ltcd.alg.tree.PostOrderTravel.TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode cur = stack.peek();
            if (null == cur.left && null == cur.right){
                res.add(stack.pop());
            }
            else {
                if (null != cur.right){
                    stack.push(cur.right);
                }
                if (null != cur.left){
                    stack.push(cur.left);
                }
            }
        }
        return;
    }

}
