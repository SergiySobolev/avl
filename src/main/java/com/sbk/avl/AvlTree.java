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
        int height = root.height();
        int lastRowNodesNumber = (int) Math.pow(2, height-1);
        int lastRowLength = lastRowNodesNumber * 8;
        List<TreeNode> currentRow = new ArrayList<>();
        currentRow.add(root);
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
                    System.out.print(String.format("(%s,%s,%s)", node.getVal(), node.height(), node.balanceFactor()));
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
