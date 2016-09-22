package com.sbk.avl;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TreeNode {
    private int val;
    private TreeNode parent;
    private TreeNode left;
    private TreeNode right;
    TreeNode(int val){
        this.val = val;
    }
    int height() {
        return  1 + Math.max(
                Objects.nonNull(getLeft()) ? getLeft().height() : 0,
                Objects.nonNull(getRight()) ? getRight().height() : 0
        );
    }
    int balanceFactor() {
        return Math.abs((Objects.nonNull(getLeft()) ? getLeft().height() : 0)
                - (Objects.nonNull(getRight()) ? getRight().height() : 0));
    }
}
