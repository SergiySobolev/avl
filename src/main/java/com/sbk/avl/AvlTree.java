package com.sbk.avl;

import com.sun.tracing.dtrace.NameAttributes;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

import static java.util.Objects.isNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
class AvlTree {
    private TreeNode root;
    void insert(int newKey){
        if(isNull(root)) {
            root = new TreeNode(newKey);
        }
        insert(newKey, root);
    }

    void delete(int keyToDelete) {
        delete(root, keyToDelete);
    }

    boolean isEmpty(){
        return root == null;
    }

    TreeNode next(TreeNode n) {
        return n.hasRightChild() ? n.getRight().leftDescendant() : n.getParent();
    }

    private void delete(TreeNode curRoot, int keyToDelete) {
        if(isNull(curRoot)) return;
        log.info("Deleting key [{}] from node [{}]", keyToDelete, curRoot.getVal());
        if(curRoot.getVal() > keyToDelete) {
            delete(curRoot.getLeft(), keyToDelete);
            return;
        }
        if(curRoot.getVal() < keyToDelete) {
            delete(curRoot.getRight(), keyToDelete);
            return;
        }
        if(curRoot.isLeaf()) {
            if(isTreeRoot(curRoot)){
                root = null;
                return;
            }
            if(curRoot.getParent().getLeft() == curRoot){
                curRoot.getParent().setLeft(null);
            } else {
                curRoot.getParent().setRight(null);
            }
        } else if(curRoot.hasOnlyOneChild()) {
            if(curRoot.hasRightChild()){
                if(isTreeRoot(curRoot)){
                    root = curRoot.getRight();
                    root.setParent(null);
                } else {
                    TreeNode curRootParent = curRoot.getParent();
                    if(curRootParent.getRight() == curRoot) {
                        curRootParent.setRight(curRoot.getRight());
                        curRoot.getRight().setParent(curRootParent);
                    } else {
                        curRootParent.setLeft(curRoot.getRight());
                        curRoot.getRight().setParent(curRootParent);
                    }
                }
            }
            if(curRoot.hasLeftChild()){
                if(isTreeRoot(curRoot)){
                    root = curRoot.getLeft();
                    root.setParent(null);
                } else {
                    TreeNode curRootParent = curRoot.getParent();
                    if(curRootParent.getRight() == curRoot) {
                        curRootParent.setRight(curRoot.getLeft());
                        curRoot.getLeft().setParent(curRootParent);
                    } else {
                        curRootParent.setLeft(curRoot.getLeft());
                        curRoot.getLeft().setParent(curRootParent);
                    }
                }
            }
        } else if(curRoot.hasTwoChildren()){
            TreeNode nextKey = curRoot.next();
            assert !nextKey.hasLeftChild();
            TreeNode nextKeyParent = nextKey.getParent();
            TreeNode nextKeyRight = nextKey.getRight();
            replace(nextKey, nextKeyRight);
            replace(curRoot, nextKey);
            if(root == curRoot) root = nextKey;
            curRoot = nextKeyParent;
        }
        balance(curRoot);
    }

    public void swapNodes(TreeNode one, TreeNode two) {
        if(isNull(one) || isNull(two)) return;
        TreeNode oneParent = one.getParent();
        one.setParent(two.getParent());
        two.setParent(oneParent);
        TreeNode oneLeft = one.getLeft();
        one.setLeft(two.getLeft());
        two.setLeft(oneLeft);
        TreeNode oneRight = one.getRight();
        one.setRight(two.getRight());
        two.setRight(oneRight);
    }

    public void replace(TreeNode toReplace, TreeNode replacer) {
        if(isNull(toReplace) || isNull(replacer)) return;

        TreeNode toReplaceParent = toReplace.getParent();
        if(Objects.nonNull(toReplaceParent)) {
            if (toReplaceParent.getLeft() == toReplace) {
                toReplaceParent.setLeft(replacer);
            } else {
                toReplaceParent.setRight(replacer);
            }
        }
        replacer.setParent(toReplace.getParent());

        if(toReplace.hasRightChild() && toReplace.getRight() != replacer) {
            replacer.setRight(toReplace.getRight());
            replacer.getRight().setParent(replacer);
        }
        if(toReplace.hasLeftChild() && toReplace.getLeft() != replacer) {
            replacer.setLeft(toReplace.getLeft());
            replacer.getLeft().setParent(replacer);
        }
        toReplace.cutOf();
    }

    private boolean isTreeRoot(TreeNode n) {
        return n == root;
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
        if(isNull(root)) return;
        root.print();
    }
}
