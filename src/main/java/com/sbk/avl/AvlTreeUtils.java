package com.sbk.avl;

public class AvlTreeUtils {
    static AvlTree fromArray(int... a) {
        if(a.length == 0) return new AvlTree(null);
        TreeNode treeNode = new TreeNode(a[0]);
        fromArray(treeNode, 0, a);
        return new AvlTree(treeNode);
    }

    private static void fromArray(TreeNode root, int startIndex, int... a) {
        int leftSubtreeIdx = 2*startIndex + 1;
        int rightSubtreeIdx = 2*startIndex + 2;
        if(leftSubtreeIdx < a.length) {
            TreeNode left = TreeNode.builder()
                    .val(a[leftSubtreeIdx])
                    .parent(root)
                    .build();
            root.setLeft(left);
            fromArray(left, leftSubtreeIdx, a);
        }
        if(rightSubtreeIdx < a.length) {
            TreeNode right = TreeNode.builder()
                    .val(a[rightSubtreeIdx])
                    .parent(root)
                    .build();
            root.setRight(right);
            fromArray(right, rightSubtreeIdx, a);
        }
    }
}
