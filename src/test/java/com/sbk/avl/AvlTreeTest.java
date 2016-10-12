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
    public void insert_LLRotation_3() throws Exception {
        AvlTree tree = AvlTreeUtils.buildAvlTreeFromArray(10,9);
        tree.insert(8);
        assertEquals(tree.getRoot().getVal(),9);
        assertEquals(tree.getRoot().getRight().getVal(),10);
        assertEquals(tree.getRoot().getLeft().getVal(),8);
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
    public void insert_LRRotation_2() throws Exception {
        AvlTree tree = AvlTreeUtils.buildAvlTreeFromArray(10,8);
        tree.insert(9);
        assertEquals(tree.getRoot().getVal(),9);
        assertEquals(tree.getRoot().getRight().getVal(),10);
        assertEquals(tree.getRoot().getLeft().getVal(),8);
    }

    @Test
    public void insert_RRRotation_1() throws Exception {
        AvlTree tree = AvlTreeUtils.buildAvlTreeFromArray(10,5,13,4,6,null,17,null,null,null,7);
        tree.insert(8);
        tree.print();
        assertEquals(10, tree.getRoot().getVal());
        assertEquals(5, tree.getRoot().getLeft().getVal());
        assertEquals(4, tree.getRoot().getLeft().getLeft().getVal());
        assertEquals(7, tree.getRoot().getLeft().getRight().getVal());
        assertEquals(6, tree.getRoot().getLeft().getRight().getLeft().getVal());
        assertEquals(8, tree.getRoot().getLeft().getRight().getRight().getVal());
        assertFalse(tree.getRoot().getLeft().getLeft().hasLeftChild());
        assertFalse(tree.getRoot().getLeft().getLeft().hasRightChild());
        assertFalse(tree.getRoot().getLeft().getRight().getRight().hasLeftChild());
        assertFalse(tree.getRoot().getLeft().getRight().getRight().hasRightChild());
        assertFalse(tree.getRoot().getLeft().getRight().getLeft().hasLeftChild());
        assertFalse(tree.getRoot().getLeft().getRight().getLeft().hasRightChild());
        assertFalse(tree.getRoot().getLeft().getRight().getRight().hasLeftChild());
        assertFalse(tree.getRoot().getLeft().getRight().getRight().hasRightChild());
    }

    @Test
    public void insert_RRRotation_2() throws Exception {
        AvlTree tree = AvlTreeUtils.buildAvlTreeFromArray(10,null,11);
        tree.insert(12);
        tree.print();
        assertEquals(tree.getRoot().getVal(),11);
        assertEquals(tree.getRoot().getRight().getVal(),12);
        assertEquals(tree.getRoot().getLeft().getVal(),10);
    }

    @Test
    public void insert_RLRotation_1() throws Exception {
        AvlTree tree = AvlTreeUtils.buildAvlTreeFromArray(10,5,13,4,6,null,17,null,null,null,8);
        tree.insert(7);
        assertEquals(10, tree.getRoot().getVal());
        assertEquals(5, tree.getRoot().getLeft().getVal());
        assertEquals(7, tree.getRoot().getLeft().getRight().getVal());
        assertEquals(6, tree.getRoot().getLeft().getRight().getLeft().getVal());
        assertEquals(8, tree.getRoot().getLeft().getRight().getRight().getVal());
        assertFalse(tree.getRoot().getLeft().getRight().getLeft().hasRightChild());
        assertFalse(tree.getRoot().getLeft().getRight().getLeft().hasLeftChild());
        assertFalse(tree.getRoot().getLeft().getRight().getRight().hasRightChild());
        assertFalse(tree.getRoot().getLeft().getRight().getRight().hasLeftChild());
    }

    @Test
    public void insert_RLRotation_2() throws Exception {
        AvlTree tree = AvlTreeUtils.buildAvlTreeFromArray(10,8);
        tree.insert(7);
        tree.print();
        assertEquals(tree.getRoot().getVal(),8);
        assertEquals(tree.getRoot().getRight().getVal(),10);
        assertEquals(tree.getRoot().getLeft().getVal(),7);
    }

    @Test
    public void multiple_insert_1()  throws Exception {
        AvlTree tree = new AvlTree();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(6);
        tree.insert(9);
        tree.insert(-2);
        tree.insert(-9);
        tree.insert(-8);
        tree.insert(-7);
        tree.print();
        assertEquals(tree.getRoot().getVal(),2);

        assertEquals(tree.getRoot().getLeft().getVal(),-2);
        assertEquals(tree.getRoot().getRight().getVal(),6);

        assertEquals(tree.getRoot().getLeft().getLeft().getVal(),-8);
        assertEquals(tree.getRoot().getLeft().getRight().getVal(),1);
        assertEquals(tree.getRoot().getRight().getLeft().getVal(),3);
        assertEquals(tree.getRoot().getRight().getRight().getVal(),9);

        assertEquals(tree.getRoot().getLeft().getLeft().getLeft().getVal(),-9);
        assertEquals(tree.getRoot().getLeft().getLeft().getRight().getVal(),-7);

    }

    @Test
    public void next_1() throws Exception {
        AvlTree tree = AvlTreeUtils.buildAvlTreeFromArray(10,7,13,4,6,12,17,3);
        System.out.println(tree.next(tree.getRoot()));
    }

    @Test
    public void delete_1() throws Exception {
        AvlTree tree = new AvlTree();
        tree.insert(1);
        tree.delete(1);
        assertTrue(tree.isEmpty());
    }

    @Test
    public void delete_2() throws Exception {
        AvlTree tree = new AvlTree();
        tree.insert(1);
        tree.insert(2);
        tree.delete(2);
        assertFalse(tree.isEmpty());
        assertEquals(tree.getRoot().getVal(), 1);
        assertFalse(tree.getRoot().hasRightChild());
        assertFalse(tree.getRoot().hasLeftChild());
    }

    @Test
    public void delete_3() throws Exception {
        AvlTree tree = new AvlTree();
        tree.insert(1);
        tree.insert(2);
        tree.insert(-1);
        tree.insert(3);
        tree.print();
        tree.delete(2);
//        tree.print();
//        assertFalse(tree.isEmpty());
//        assertEquals(tree.getRoot().getVal(), 1);
//        assertFalse(tree.getRoot().hasRightChild());
//        assertFalse(tree.getRoot().hasLeftChild());
    }

    @Test
    public void delete_4() throws Exception {
        AvlTree tree = new AvlTree();
        tree.insert(1);
        tree.insert(2);
        tree.insert(-1);
        tree.insert(3);
        tree.delete(2);
        assertEquals(tree.getRoot().getVal(), 1);
        assertEquals(tree.getRoot().getLeft().getVal(), -1);
        assertEquals(tree.getRoot().getRight().getVal(), 3);
    }

    @Test
    public void delete_5() throws Exception {
        AvlTree tree = new AvlTree();
        tree.insert(1);
        tree.insert(-1);
        tree.insert(3);
        tree.insert(4);
        tree.delete(3);
        tree.print();
        assertEquals(tree.getRoot().getVal(), 1);
        assertEquals(tree.getRoot().getLeft().getVal(), -1);
        assertEquals(tree.getRoot().getRight().getVal(), 4);
    }

    @Test
    public void delete_6() throws Exception {
        AvlTree tree = new AvlTree();
        tree.insert(5);
        tree.insert(4);
        tree.insert(3);
        tree.insert(2);
        tree.delete(3);
        tree.print();
        assertEquals(tree.getRoot().getVal(), 4);
        assertEquals(tree.getRoot().getLeft().getVal(), 2);
        assertEquals(tree.getRoot().getRight().getVal(), 5);
    }

    @Test
    public void delete_7() throws Exception {
        AvlTree tree = new AvlTree();
        tree.insert(5);
        tree.insert(4);
        tree.insert(2);
        tree.insert(3);
        tree.delete(2);
        tree.print();
        assertEquals(tree.getRoot().getVal(), 4);
        assertEquals(tree.getRoot().getLeft().getVal(), 3);
        assertEquals(tree.getRoot().getRight().getVal(), 5);
    }

    @Test
    public void delete_8() throws Exception {
        AvlTree tree = new AvlTree();
        tree.insert(11);
        tree.insert(4);
        tree.insert(3);
        tree.insert(10);
        tree.insert(7);
        tree.insert(1);
        tree.insert(9);
        tree.print();
        tree.delete(4);
        assertEquals(7, tree.getRoot().getVal());
        assertEquals(3, tree.getRoot().getLeft().getVal());
        assertEquals(10, tree.getRoot().getRight().getVal());
        assertEquals(9, tree.getRoot().getRight().getLeft().getVal());
        assertEquals(11, tree.getRoot().getRight().getRight().getVal());
    }

    @Test
    public void delete_9() throws Exception {
        AvlTree tree = new AvlTree();
        tree.insert(11);
        tree.insert(4);
        tree.insert(3);
        tree.insert(10);
        tree.insert(7);
        tree.insert(1);
        tree.insert(9);
        tree.delete(11);
        assertEquals(4, tree.getRoot().getVal());
        assertEquals(3, tree.getRoot().getLeft().getVal());
        assertEquals(9, tree.getRoot().getRight().getVal());
        assertEquals(7, tree.getRoot().getRight().getLeft().getVal());
        assertEquals(10, tree.getRoot().getRight().getRight().getVal());
    }
}