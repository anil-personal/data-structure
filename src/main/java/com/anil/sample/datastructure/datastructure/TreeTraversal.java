package com.anil.sample.datastructure.datastructure;

import java.util.*;

public class TreeTraversal {

    private Node rootNode;

    public static void main(String[] args) {
        TreeTraversal treeTraversal = new TreeTraversal();
        populateData(treeTraversal);
        treeTraversal.bft();
        treeTraversal.dftPreOrder();
        treeTraversal.dftInOrder();
        treeTraversal.dftPostOrder();
    }

    /**
     * Breath First Traversal
     */
    private void bft() {
        System.out.println("\n#####  Breath First Traversal #####");
        Queue<Node> bfsNodes = new LinkedList<>();
        bfsNodes.add(rootNode);
        while (!bfsNodes.isEmpty()) {
            Node currentNode = bfsNodes.remove();
            if (currentNode == null) {
                return;
            }
            System.out.print(" " + currentNode.getValue() + " ");
            Node leftNode = currentNode.getLeft();
            if (leftNode != null) {
                bfsNodes.add(leftNode);
            }
            Node rightNode = currentNode.getRight();
            if (rightNode != null) {
                bfsNodes.add(rightNode);
            }

        }
        System.out.println("\n########################################");
    }

    private void dftPreOrder() {
        System.out.println("\n#####  Depth First Traversal (PRE ORDER) #####");
        Stack<Node> dfsNodes = new Stack<>();
        dfsNodes.push(rootNode);
        while (!dfsNodes.isEmpty()) {
            Node currentNode = dfsNodes.pop();
            if (currentNode == null) {
                return;
            }
            System.out.print(" " + currentNode.getValue() + " ");
            Node rightNode = currentNode.getRight();
            if(rightNode != null){
                dfsNodes.push(rightNode);
            }
            Node leftNode = currentNode.getLeft();
            if(leftNode != null){
                dfsNodes.push(leftNode);
            }
        }

        System.out.println("\n########################################");
    }

    private void dftInOrder() {
        System.out.println("\n#####  Depth First Traversal (IN ORDER) #####");
        Stack<Node> dfsNodes = new Stack<>();
        Set<Node> travesedNodes = new HashSet<>();
        dfsNodes.push(rootNode);
        while (!dfsNodes.isEmpty()) {
            Node currentNode = dfsNodes.pop();
            if (currentNode == null) {
                return;
            }
            if(!travesedNodes.contains(currentNode)){
                while(currentNode.getLeft() != null){
                    dfsNodes.push(currentNode);
                    currentNode = currentNode.getLeft();
                }
            }
            System.out.print(" " + currentNode.getValue() + " ");
            travesedNodes.add(currentNode);
            if(!dfsNodes.isEmpty()){
                currentNode = dfsNodes.pop();
                System.out.print(" " + currentNode.getValue() + " ");
                travesedNodes.add(currentNode);
                Node rightNode = currentNode.getRight();
                if(rightNode != null){
                    dfsNodes.push(rightNode);
                }
            }
        }

        System.out.println("\n########################################");
    }

    private void dftPostOrder() {
        System.out.println("\n#####  Depth First Traversal (Post ORDER) #####");
        Stack<Node> dfsNodes = new Stack<>();
        Set<Node> travesedNodes = new HashSet<>();
        dfsNodes.push(rootNode);
        while (!dfsNodes.isEmpty()) {
            Node currentNode = dfsNodes.pop();
            if (currentNode == null) {
                return;
            }
            if(!travesedNodes.contains(currentNode)){
                while(currentNode.getLeft() != null){
                    dfsNodes.push(currentNode);
                    currentNode = currentNode.getLeft();
                }
            }
            System.out.print(" " + currentNode.getValue() + " ");
            travesedNodes.add(currentNode);
            if(!dfsNodes.isEmpty()){
                currentNode = dfsNodes.pop();
                Node rightNode = currentNode.getRight();
                if(rightNode != null && !travesedNodes.contains(rightNode)){
                    dfsNodes.push(rightNode);
                    dfsNodes.push(currentNode);
                }else{
                    System.out.print(" " + currentNode.getValue() + " ");
                }
            }
        }

        System.out.println("\n########################################");
    }


    /**
     *         A
     *     B      C
     *   D   E  F   G
     * H  I
     *
     * @param bft
     */
    private static void populateData(TreeTraversal bft) {
        bft.rootNode = new Node("A");

        Node n1 = new Node("B");
        Node n2 = new Node("C");

        bft.rootNode.setLeft(n1);
        bft.rootNode.setRight(n2);

        Node n3 = new Node("D");
        Node n4 = new Node("E");
        n1.setLeft(n3);
        n1.setRight(n4);

        Node n5 = new Node("F");
        Node n6 = new Node("G");
        n2.setLeft(n5);
        n2.setRight(n6);

        Node n7 = new Node("H");
        Node n8 = new Node("I");
        n3.setLeft(n7);
        n3.setRight(n8);
    }
}

class Node {
    private String value;
    private Node left;
    private Node right;

    public Node(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(value, node.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
