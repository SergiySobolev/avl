package com.sbk.avl;

import org.junit.Test;

import static com.sbk.avl.AvlTreeUtils.buildAvlTreeFromArray;
import static org.junit.Assert.*;

public class AvlTreeUtilsTest {
    @Test
    public void test_fromArray_1() throws Exception {
        AvlTree tree = buildAvlTreeFromArray(1,2,3);
        TreeNode tn = tree.getRoot();
        assertEquals(tn.getVal(), 1);
        assertNull(tn.getParent());
        assertEquals(tn.getLeft().getVal(), 2);
        assertEquals(tn.getLeft().getParent(), tn);
        assertEquals(tn.getRight().getVal(),3);
        assertEquals(tn.getRight().getParent(),tn);
    }

    @Test
    public void test_fromArray_2() throws Exception {
        AvlTree tree = buildAvlTreeFromArray(1,2,3,null,5);
        TreeNode tn = tree.getRoot();
        assertEquals(tn.getVal(), 1);
        assertNull(tn.getParent());
        assertEquals(tn.getLeft().getVal(), 2);
        assertEquals(tn.getLeft().getParent(), tn);
        assertEquals(tn.getRight().getVal(),3);
        assertEquals(tn.getRight().getParent(),tn);
        assertNull(tn.getLeft().getLeft());
        assertEquals(tn.getLeft().getRight().getVal(), 5);
    }

    @Test
    public void test_fromArray_3() throws Exception {
        AvlTree tree = buildAvlTreeFromArray(1,2,3,null,5,6);
        TreeNode tn = tree.getRoot();
        assertEquals(tn.getVal(), 1);
        assertNull(tn.getParent());
        assertEquals(tn.getLeft().getVal(), 2);
        assertEquals(tn.getLeft().getParent(), tn);
        assertEquals(tn.getRight().getVal(),3);
        assertEquals(tn.getRight().getParent(),tn);
        assertNull(tn.getLeft().getLeft());
        assertEquals(tn.getLeft().getRight().getVal(), 5);
        assertEquals(tn.getRight().getLeft().getVal(), 6);
        assertEquals(tn.getRight().getLeft().getParent(), tn.getRight());
    }

}