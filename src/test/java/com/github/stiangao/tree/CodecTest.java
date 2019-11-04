package com.github.stiangao.tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CodecTest {

    @Test
    public void serialize() {
        assertEquals("5(3,1(4(,2),))", new Codec().serialize(tree1()));
    }

    @Test
    public void deserialize() {
        Codec2 codec = new Codec2();
        TreeNode root = codec.deserialize(codec.serialize(tree1()));
        assertEquals(1, root.val);
        assertEquals(2, root.left.val);
        assertEquals(3, root.right.val);
        assertEquals(4, root.right.left.val);
        assertEquals(5, root.right.right.val);

        TreeNode root2 = codec.deserialize("5(3(6,7(8,)),1(4(,2),))");
        assertEquals(5, root2.val);
        assertEquals(3, root2.left.val);
        assertEquals(6, root2.left.left.val);
        assertEquals(7, root2.left.right.val);
        assertEquals(8, root2.left.right.left.val);
        assertEquals(1, root2.right.val);
        assertEquals(4, root2.right.left.val);
        assertEquals(2, root2.right.left.right.val);
    }

    public TreeNode tree1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        return root;
    }

    public TreeNode tree2() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(7);
        root.left.right.left = new TreeNode(8);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(4);
        root.right.left.right = new TreeNode(2);
        return root;
    }
}