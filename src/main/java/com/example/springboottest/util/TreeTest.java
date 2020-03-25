package com.example.springboottest.util;

public class TreeTest {
    private static Tree<String> tree;
    {
        System.out.println("代码块");
        tree = new Tree<String>();
        tree.setData("a");
        Tree<String> leftTree = new Tree<String>();
        leftTree.setData("b");
        Tree<String> rightTree = new Tree<String>();
        rightTree.setData("c");

        tree.setLeft(leftTree);
        tree.setRight(rightTree);
    }

    public static void main(String[] args) {

    }
}
