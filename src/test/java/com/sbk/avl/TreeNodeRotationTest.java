package com.sbk.avl;

import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.*;

public class TreeNodeRotationTest {
    @Test
    public void leftRotate_1() throws Exception {
        TreeNode root = AvlTreeUtils.buildTreeNodeFromArray(1,null,2, null, null, null, 3);
        assertNotNull(root);
        root.print();
        root.rotateLeft();
        root.getParent().print();
        assertEquals(root.getParent().getVal(), 2);
        assertNull(root.getParent().getParent());
        assertEquals(root.getParent().getLeft(), root);
    }
}
