package com.sbk.avl;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TreeNode {
    private int val;
    private int height;
    private TreeNode parent;
    private TreeNode left;
    private TreeNode right;
    public TreeNode(int val){
        this.val = val;
    }

}
