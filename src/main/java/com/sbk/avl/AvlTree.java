package com.sbk.avl;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
class AvlTree {
    private TreeNode root;
    void insert(int newKey){
        if(Objects.isNull(root)) {
            root = new TreeNode(newKey);
        }
        insert(newKey, root);
    }

    private void insert(int newKey, TreeNode parent) {
        assert Objects.nonNull(parent);
        if(parent.getVal() > newKey) {
            if(parent.hasLeftChild()) {
                insert(newKey, parent.getLeft());
            } else {
                parent.setLeft(new TreeNode(newKey, parent));
            }
        }
        if(parent.getVal() < newKey) {
            if(parent.hasRightChild()) {
                insert(newKey, parent.getRight());
            } else {
                parent.setRight(new TreeNode(newKey, parent));
            }
        }

    }

    void print(){
        if(Objects.isNull(root)) return;
        root.print();
    }
}
