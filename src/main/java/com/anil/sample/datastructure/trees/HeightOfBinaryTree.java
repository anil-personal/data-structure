package com.anil.sample.datastructure.trees;

public class HeightOfBinaryTree {
    public static void main(String[] args) {
        HeightOfBinaryTree heightOfBinaryTree = new HeightOfBinaryTree();
        Tree tree = heightOfBinaryTree.createTree();
        System.out.println(heightOfBinaryTree.measureHeight(tree));
    }

    public int measureHeight(Tree tree) {
        if (tree == null) {
            return -1;
        }
        int leftSideHeight = measureHeight(tree.left);
        int rightSideHeight = measureHeight(tree.right);
        return (leftSideHeight > rightSideHeight) ? (leftSideHeight + 1) : (rightSideHeight + 1);
    }

    private Tree createTree() {
        Tree root = new Tree(4);

        Tree two = new Tree(2);
        Tree six = new Tree(6);
        root.setLeft(two);
        root.setRight(six);

        Tree one = new Tree(1);
        Tree three = new Tree(3);

        two.setLeft(one);
        two.setRight(three);

        Tree five = new Tree(5);
        Tree seven = new Tree(7);
        six.setLeft(five);
        six.setRight(seven);

        Tree eight = new Tree(8);
        seven.setRight(eight);

        return root;
    }

    private class Tree {
        private int value;
        private Tree left;
        private Tree right;

        public Tree(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Tree getLeft() {
            return left;
        }

        public void setLeft(Tree left) {
            this.left = left;
        }

        public Tree getRight() {
            return right;
        }

        public void setRight(Tree right) {
            this.right = right;
        }
    }
}
