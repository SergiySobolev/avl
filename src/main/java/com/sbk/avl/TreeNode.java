package com.sbk.avl;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
class TreeNode {
    private int val;
    private TreeNode parent;
    private TreeNode left;
    private TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode parent) {
        this.val = val;
        this.parent = parent;
    }

    void LLRotation() {
        if (this.hasLeftChild()) {
            log.info("LL rotation around node [{}]", val);
            TreeNode newRoot = getLeft();
            TreeNode newRootRight = getLeft().getRight();
            newRoot.setParent(this.getParent());
            this.setLeft(newRoot.getLeft());
            newRoot.setRight(this);
            setNewSubRootOfYourParent(newRoot);
            this.setParent(newRoot);
            this.setLeft(newRootRight);
        }
    }

    void LRRotation() {
        if (this.hasLeftChild()) {
            log.info("LR rotation around node [{}]", val);
            TreeNode newRoot = getLeft().getRight();
            TreeNode newRootRight = this;
            TreeNode newRootLeft = this.getLeft();
            setNewSubRootOfYourParent(newRoot);
            newRoot.setParent(this.getParent());
            newRoot.setRight(newRootRight);
            newRoot.setLeft(newRootLeft);
            newRootRight.setParent(newRoot);
            newRootRight.setLeft(null);
            newRootLeft.setParent(newRoot);
            newRootLeft.setRight(null);
        }
    }

    void RRRotation() {
        if (this.hasRightChild()) {
            log.info("RR rotation around node [{}]", val);
            TreeNode newRoot = getRight();
            TreeNode newRootLeft = this;
            TreeNode newRootRight = this.getRight().getRight();
            setNewSubRootOfYourParent(newRoot);
            newRoot.setParent(this.getParent());
            newRoot.setRight(newRootRight);
            newRoot.setLeft(newRootLeft);
            newRootRight.setParent(newRoot);
            newRootRight.setRight(null);
            newRootLeft.setParent(newRoot);
            newRootLeft.setRight(null);
        }
    }

    void RLRotation() {
        if (this.hasRightChild()) {
            log.info("RL rotation around node [{}]", val);
            TreeNode newRoot = getRight().getLeft();
            TreeNode newRootRight = this.getRight();
            TreeNode newRootLeft = this;
            setNewSubRootOfYourParent(newRoot);
            newRoot.setParent(this.getParent());
            newRoot.setRight(newRootRight);
            newRoot.setLeft(newRootLeft);
            newRootRight.setParent(newRoot);
            newRootRight.setLeft(null);
            newRootLeft.setParent(newRoot);
            newRootLeft.setRight(null);
        }
    }

    TreeNode leftDescendant() {
        if(!hasLeftChild()) return this;
        TreeNode cur  = this;
        while(Objects.nonNull(cur.getLeft())){
            cur = cur.getLeft();
        }
        return cur;
    }

    TreeNode next() {
        return hasRightChild() ? getRight().leftDescendant() : getParent();
    }

    private void setNewSubRootOfYourParent(TreeNode newRoot) {
        if (Objects.nonNull(this.getParent())) {
            if (this.getParent().getLeft() == this) {
                this.getParent().setLeft(newRoot);
            } else {
                this.getParent().setRight(newRoot);
            }
        }
    }

    void rotateLeft() {
        right.setParent(this.parent);
        right.setLeft(this);
        this.setParent(right);
        this.setRight(null);
    }

    boolean hasLeftChild() {
        return Objects.nonNull(left);
    }

    boolean hasRightChild() {
        return Objects.nonNull(right);
    }

    boolean hasOnlyOneChild() {
        return hasLeftChild() ^ hasRightChild();
    }

    boolean hasTwoChildren() {
        return hasLeftChild() && hasRightChild();
    }

    boolean hasParent() {
        return Objects.nonNull(parent);
    }

    boolean isLeaf() {
        return !(hasRightChild() || hasLeftChild());
    }

    int height() {
        return 1 + Math.max(
                Objects.nonNull(getLeft()) ? getLeft().height() : 0,
                Objects.nonNull(getRight()) ? getRight().height() : 0
        );
    }

    int balanceFactor() {
        return (Objects.nonNull(getLeft()) ? getLeft().height() : 0)
                - (Objects.nonNull(getRight()) ? getRight().height() : 0);
    }

    void cutOf() {
        setParent(null);
        setRight(null);
        setLeft(null);
    }

    void print() {
        int height = this.height();
        int lastRowNodesNumber = (int) Math.pow(2, height - 1);
        int lastRowLength = lastRowNodesNumber * 8;
        List<TreeNode> currentRow = new ArrayList<>();
        currentRow.add(this);
        while (!currentRow.isEmpty()) {
            List<TreeNode> newCurrentRow = new ArrayList<>();
            String shift = new String(new char[lastRowLength / (currentRow.size() + 1)]).replace('\0', ' ');
            System.out.println();
            System.out.println();
            System.out.print(shift);
            for (TreeNode node : currentRow) {
                if (Objects.nonNull(node)) {
                    newCurrentRow.add(node.getLeft());
                    newCurrentRow.add(node.getRight());
                    // System.out.print(String.format("(%s,%s,%s)", node.getVal(), node.height(), node.balanceFactor()));
                    System.out.print(node.getVal());
                } else {
                    newCurrentRow.add(null);
                    newCurrentRow.add(null);
                    System.out.print("N");
                }
                System.out.print(shift);
                if (currentRow.indexOf(node) + 1 == currentRow.size() / 2) {
                    System.out.print(new String(new char[10]).replace('\0', ' '));
                }
            }
            currentRow.clear();
            if (newCurrentRow.stream().filter(Objects::nonNull).collect(Collectors.toList()).size() > 0) {
                currentRow.addAll(newCurrentRow);
            }

        }
    }

    @Override
    public String toString() {
        return new StringBuilder().append("[Val=").append(val)
                .append(" Parent=").append(parent == null ? "" : parent.getVal())
                .append(" Left=").append(left == null ? "" : left.getVal())
                .append(" Right=").append(right == null ? "" : right.getVal())
                .append("]")
                .toString();
    }
}
