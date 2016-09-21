package com.sbk.avl;

import org.junit.Test;

import static com.sbk.avl.AvlTreeUtils.fromArray;
import static org.junit.Assert.*;

public class AvlTreeUtilsTest {
    @Test
    public void testFromArray() throws Exception {
        AvlTree tree = fromArray(1,2,3);
        TreeNode tn = tree.getRoot();
        assertEquals(tn.getVal(), 1);
        assertNull(tn.getParent());
        assertEquals(tn.getLeft().getVal(), 2);
        assertEquals(tn.getLeft().getParent(), tn);
        assertEquals(tn.getRight().getVal(),3);
        assertEquals(tn.getRight().getParent(),tn);
    }

}