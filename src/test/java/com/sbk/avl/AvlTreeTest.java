package com.sbk.avl;

import org.junit.Test;

import static org.junit.Assert.*;

public class AvlTreeTest {
    @Test
    public void insert_LLRotation_1() throws Exception {
        AvlTree tree = AvlTreeUtils.buildAvlTreeFromArray(10,7,13,4,6,null,17,3);
        tree.insert(2);
        assertEquals(10, tree.getRoot().getVal());
        assertEquals(7, tree.getRoot().getLeft().getVal());
        assertEquals(3, tree.getRoot().getLeft().getLeft().getVal());
        assertEquals(2, tree.getRoot().getLeft().getLeft().getLeft().getVal());
        assertEquals(4, tree.getRoot().getLeft().getLeft().getRight().getVal());
        assertFalse(tree.getRoot().getLeft().getLeft().getRight().hasLeftChild());
        assertFalse(tree.getRoot().getLeft().getLeft().getRight().hasRightChild());
    }
    @Test
    public void insert_LLRotation_2() throws Exception {
        AvlTree tree = AvlTreeUtils.buildAvlTreeFromArray(10,7,13,4,6,null,17,3,5);
        tree.insert(2);
        tree.print();
        assertEquals(10, tree.getRoot().getVal());
        assertEquals(4, tree.getRoot().getLeft().getVal());
        assertEquals(7, tree.getRoot().getLeft().getRight().getVal());
        assertEquals(3, tree.getRoot().getLeft().getLeft().getVal());
        assertEquals(3, tree.getRoot().getLeft().getLeft().getVal());
        assertEquals(2, tree.getRoot().getLeft().getLeft().getLeft().getVal());
        assertFalse(tree.getRoot().getLeft().getLeft().getLeft().hasLeftChild());
        assertFalse(tree.getRoot().getLeft().getLeft().getLeft().hasRightChild());
    }

}