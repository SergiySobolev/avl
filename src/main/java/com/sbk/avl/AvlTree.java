package com.sbk.avl;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
public class AvlTree {
    private TreeNode root;
    public AvlTree(TreeNode root) {
        this.root = root;
    }
}
