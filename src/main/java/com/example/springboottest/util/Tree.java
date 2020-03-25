package com.example.springboottest.util;

import java.util.ArrayList;
import java.util.List;

public class Tree<T> {
    private T data;
    private Tree left;
    private Tree right;


    public List<T> preOrder(){
        List<T> list = new ArrayList<>();

        return null;
    }
    public List<T> midOrder(){
        return null;
    }
    public List<T> afterOrder(){
        return null;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
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
