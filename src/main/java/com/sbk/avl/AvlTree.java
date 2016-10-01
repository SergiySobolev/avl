package com.sbk.avl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Getter
@AllArgsConstructor
@Slf4j
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
        log.info("Inserting key [{}] at node [{}]", newKey, parent.getVal());
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
        balance(parent);
    }

    private void balance(TreeNode node) {
        assert Objects.nonNull(node);
        int balanceFactor = node.balanceFactor();
        if(balanceFactor == 2){
            balanceLeft(node);
        }
        if(balanceFactor == -2){
            balanceRight(node);
        }
        if(node.hasParent()){
            balance(node.getParent());
        } else {
            root = node;
        }
    }

    private void balanceRight(TreeNode node) {
        assert node.hasRightChild();
        if(node.getRight().balanceFactor() == 1){
            node.RLRotation();
        } else if (node.getRight().balanceFactor() == -1){
            node.RRRotation();
        }
    }

    private void balanceLeft(TreeNode node) {
        assert node.hasLeftChild();
        if(node.getLeft().balanceFactor() == 1){
            node.LLRotation();
        } else if (node.getLeft().balanceFactor() == -1){
            node.LRRotation();
        }
    }

    void print(){
        if(Objects.isNull(root)) return;
        root.print();
    }
}
