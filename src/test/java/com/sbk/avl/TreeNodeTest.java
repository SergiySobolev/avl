package com.sbk.avl;

import org.junit.Test;

import static org.junit.Assert.*;

public class TreeNodeTest {
    @Test
    public void calcHeight() throws Exception {
        TreeNode node = AvlTreeUtils.buildTreeNodeFromArray(1,2,3);
        assertNotNull(node);
        assertEquals(node.height(), 2);
        assertEquals(node.getLeft().height(), 1);
    }
    @Test
    public void calcBalanceFactor_1() throws Exception {
        TreeNode node = AvlTreeUtils.buildTreeNodeFromArray(1,2,3,4,null,null,null,8);
        assertNotNull(node);
        assertEquals(node.balanceFactor(), 2);
        assertEquals(node.getLeft().balanceFactor(), 2);
        assertEquals(node.getLeft().getLeft().balanceFactor(), 1);
        assertEquals(node.getLeft().getLeft().getLeft().balanceFactor(), 0);
    }
    @Test
    public void calcBalanceFactor_2() throws Exception {
        TreeNode node = AvlTreeUtils.buildTreeNodeFromArray(1,null,3,null,null,null,7);
        assertNotNull(node);
        assertEquals(node.balanceFactor(), -2);
        assertEquals(node.getRight().balanceFactor(), -1);
        assertEquals(node.getRight().getRight().balanceFactor(), 0);
    }

    @Test
    public void leftDescendant_1() {
        AvlTree tree = AvlTreeUtils.buildAvlTreeFromArray(10,7,13);
        assertEquals(tree.getRoot().leftDescendant().getVal(), 7);
        tree.insert(9);
        assertEquals(tree.getRoot().leftDescendant().getVal(), 7);
        tree.insert(5);
        assertEquals(tree.getRoot().leftDescendant().getVal(), 5);
    }

    @Test
    public void leftDescendant_2() {
        AvlTree tree = AvlTreeUtils.buildAvlTreeFromArray(10);
        assertEquals(tree.getRoot().leftDescendant().getVal(), 10);
    }

    @Test
    public void next_1() {
        AvlTree tree = AvlTreeUtils.buildAvlTreeFromArray(10);
        assertNull(tree.getRoot().next());
        tree.insert(20);
        assertEquals(tree.getRoot().next().getVal(), 20);
        TreeNode curRoot = tree.getRoot();
        tree.insert(19);
        assertEquals(curRoot.next().getVal(), 19);
    }

    @Test
    public void next_2() {
        AvlTree tree = AvlTreeUtils.buildAvlTreeFromArray(10);
        assertNull(tree.getRoot().next());
        tree.insert(5);
        tree.insert(20);
        assertEquals(tree.getRoot().next().getVal(), 20);
        tree.insert(19);
        assertEquals(tree.getRoot().next().getVal(), 19);
    }
}