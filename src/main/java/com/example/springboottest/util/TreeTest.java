package com.example.springboottest.util;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TreeTest {
    public static Tree<String> tree;

    {
        System.out.println("代码块");
        tree = new Tree<String>();
        tree.setData("a");
        setChild(tree, "b", "c");
    }


    private void setChild(Tree tree,Object leftData,Object rightData){
        Tree<String> leftTree = new Tree<String>();
        leftTree.setData((String) leftData);
        Tree<String> rightTree = new Tree<String>();
        rightTree.setData((String) rightData);

        tree.setLeft(leftTree);
        tree.setRight(rightTree);
    }
    public TreeTest(){
        System.out.println("111");
    }

    public static void main(String[] args) {
        TreeTest treeTest = new TreeTest();
        Tree<String> tree = treeTest.tree;
        Tree left = tree.getLeft();
        Tree right = tree.getRight();
        treeTest.setChild(left,"d" ,"e" );
        treeTest.setChild(right,"f" ,"g" );
        List<String> strings = tree.preOrder(new ArrayList<String>());
        System.out.println();
    }
}
