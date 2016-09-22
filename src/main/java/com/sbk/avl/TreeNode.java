package com.sbk.avl;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
}
