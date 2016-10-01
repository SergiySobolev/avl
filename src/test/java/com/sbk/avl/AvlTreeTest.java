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

    @Test
    public void insert_LRRotation_1() throws Exception {
        AvlTree tree = AvlTreeUtils.buildAvlTreeFromArray(10,7,13,4,6,null,17,2);
        tree.insert(3);
        tree.print();
        assertEquals(10, tree.getRoot().getVal());
        assertEquals(7, tree.getRoot().getLeft().getVal());
        assertEquals(3, tree.getRoot().getLeft().getLeft().getVal());
        assertEquals(6, tree.getRoot().getLeft().getRight().getVal());
        assertEquals(4, tree.getRoot().getLeft().getLeft().getRight().getVal());
        assertEquals(2, tree.getRoot().getLeft().getLeft().getLeft().getVal());
        assertFalse(tree.getRoot().getLeft().getLeft().getLeft().hasLeftChild());
        assertFalse(tree.getRoot().getLeft().getLeft().getLeft().hasRightChild());
        assertFalse(tree.getRoot().getLeft().getLeft().getRight().hasLeftChild());
        assertFalse(tree.getRoot().getLeft().getLeft().getRight().hasRightChild());
    }

    @Test
    public void insert_RRRotation_1() throws Exception {
        AvlTree tree = AvlTreeUtils.buildAvlTreeFromArray(10,5,13,4,6,null,17,null,null,null,7);
        tree.insert(8);
        tree.print();
        assertEquals(10, tree.getRoot().getVal());
        assertEquals(5, tree.getRoot().getLeft().getVal());
        assertEquals(4, tree.getRoot().getLeft().getLeft().getVal());
        assertEquals(8, tree.getRoot().getLeft().getRight().getVal());
        assertEquals(4, tree.getRoot().getLeft().getLeft().getVal());
        assertEquals(6, tree.getRoot().getLeft().getRight().getLeft().getVal());
        assertEquals(7, tree.getRoot().getLeft().getRight().getRight().getVal());
        assertFalse(tree.getRoot().getLeft().getLeft().hasLeftChild());
        assertFalse(tree.getRoot().getLeft().getLeft().hasRightChild());
        assertFalse(tree.getRoot().getLeft().getRight().getRight().hasLeftChild());
        assertFalse(tree.getRoot().getLeft().getRight().getRight().hasRightChild());
        assertFalse(tree.getRoot().getLeft().getRight().getLeft().hasLeftChild());
        assertFalse(tree.getRoot().getLeft().getRight().getLeft().hasRightChild());
        assertFalse(tree.getRoot().getLeft().getRight().getRight().hasLeftChild());
        assertFalse(tree.getRoot().getLeft().getRight().getRight().hasRightChild());
    }

}