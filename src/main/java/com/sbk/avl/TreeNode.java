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
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val, TreeNode parent){
        this.val = val;
        this.parent = parent;
    }
    void LLRotation() {
        if(this.hasLeftChild()) {
            log.info("LL rotation around node [{}]", val);
            TreeNode newRoot = left;
            TreeNode newRootRight = left.getRight();
            newRoot.setParent(this.parent);
            this.setLeft(newRoot.getLeft());
            newRoot.setRight(this);
            this.getParent().setLeft(newRoot);
            this.setParent(newRoot);
            this.setLeft(newRootRight);
        }
    }
    void rotateLeft(){
        right.setParent(this.parent);
        right.setLeft(this);
        this.setParent(right);
        this.setRight(null);
    }

    boolean hasLeftChild(){
        return Objects.nonNull(left);
    }
    boolean hasRightChild(){
        return Objects.nonNull(right);
    }
    boolean hasParent(){
        return Objects.nonNull(parent);
    }
    int height() {
        return  1 + Math.max(
                Objects.nonNull(getLeft()) ? getLeft().height() : 0,
                Objects.nonNull(getRight()) ? getRight().height() : 0
        );
    }
    int balanceFactor() {
        return (Objects.nonNull(getLeft()) ? getLeft().height() : 0)
                - (Objects.nonNull(getRight()) ? getRight().height() : 0);
    }
    void print(){
        int height = this.height();
        int lastRowNodesNumber = (int) Math.pow(2, height-1);
        int lastRowLength = lastRowNodesNumber * 8;
        List<TreeNode> currentRow = new ArrayList<>();
        currentRow.add(this);
        while(!currentRow.isEmpty()){
            List<TreeNode> newCurrentRow = new ArrayList<>();
            String shift = new String(new char[lastRowLength/(currentRow.size()+1)]).replace('\0', ' ');
            System.out.println();
            System.out.println();
            System.out.print(shift);
            for(TreeNode node : currentRow) {
                if(Objects.nonNull(node )) {
                    newCurrentRow.add(node.getLeft());
                    newCurrentRow.add(node.getRight());
                   // System.out.print(String.format("(%s,%s,%s)", node.getVal(), node.height(), node.balanceFactor()));
                    System.out.print( node.getVal());
                } else {
                    newCurrentRow.add(null);
                    newCurrentRow.add(null);
                    System.out.print("N");
                }
                System.out.print(shift);
                if(currentRow.indexOf(node)+1 == currentRow.size()/2){
                    System.out.print(new String(new char[10]).replace('\0', ' '));
                }
            }
            currentRow.clear();
            if(newCurrentRow.stream().filter(Objects::nonNull).collect(Collectors.toList()).size() > 0) {
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
                .toString();
    }
}
