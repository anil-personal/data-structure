package com.anil.sample.datastructure.trees;

import java.util.LinkedList;
import java.util.List;

public class LevelOrderTraversal
{
    public static void main(String[] args)
    {
        LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();
        Tree tree = levelOrderTraversal.createTree();
        List<Tree> nodes = new LinkedList<>();
        nodes.add(tree);
        levelOrderTraversal.traversal(nodes);

    }

    private void traversal(List<Tree> nodes)
    {
        while (!nodes.isEmpty())
        {
            Tree tree = nodes.remove(0);
            if (tree != null)
            {
                System.out.print(tree.getValue() + " ");
                if (tree.getLeft() != null)
                {
                    nodes.add(tree.getLeft());

                }
                if (tree.getRight() != null)
                {
                    nodes.add(tree.getRight());
                }
            }
        }

    }


    private Tree createTree()
    {
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

}

class Tree
{
    private int value;
    private Tree left;
    private Tree right;

    public Tree(int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return value;
    }

    public void setValue(int value)
    {
        this.value = value;
    }

    public Tree getLeft()
    {
        return left;
    }

    public void setLeft(Tree left)
    {
        this.left = left;
    }

    public Tree getRight()
    {
        return right;
    }

    public void setRight(Tree right)
    {
        this.right = right;
    }
}
