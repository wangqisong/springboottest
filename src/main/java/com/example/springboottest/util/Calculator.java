package com.example.springboottest.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * 计算器：中缀表达式--》后缀表达式--》计算--》得值
 */
public class Calculator {
    public static void main(String[] args) {
//        System.out.println("1".matches("^[0-9]$"));
        Calculator.calculate("(1+1+3-1)*9+2");
    }
    public static Double calculate(String expression){
        Stack stack = new Stack();
        char[] chars = expression.toCharArray();
        String regex = "^[0-9]$";
        Character[] fh = {'+','-','*','/','(',')'};
        ArrayList<Character> f = new ArrayList<Character>();
        Collections.addAll(f,fh);
        //ArrayList<Character> f = (ArrayList) Arrays.asList(fh);
        StringBuffer sb = new StringBuffer();
        for (char c:chars){
            String s = String.valueOf(c);
            if(s.matches(regex)){
                sb.append(s);
                continue;
            }
            if(f.contains(c)){
                if(')'==c){
                    while((char)stack.peek()!='('){
                        sb.append(stack.pop());
                    }
                    if ((char)stack.peek()=='('){
                        stack.pop();
                    }
                    continue;
                }
                stack.push(c);
            }
        }
        while(!stack.empty()){
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());
        Double result;
        char[] chars1 = sb.toString().toCharArray();

        for (char c:chars1){
            String s = String.valueOf(c);
            if(s.matches(regex)){
                stack.push(s);
                continue;
            }
            Integer i=0;
            if('+'==c){
                i =  Integer.valueOf((String.valueOf(stack.pop()))) + Integer.valueOf((String.valueOf(stack.pop())));
            }else if('-'==c){
                i =  Integer.valueOf((String.valueOf(stack.pop()))) - Integer.valueOf((String.valueOf(stack.pop())));
            }else if('*'==c){
                i =  Integer.valueOf((String.valueOf(stack.pop()))) * Integer.valueOf((String.valueOf(stack.pop())));
            }
            stack.push(i);
        }
        System.out.println(stack.pop());

        return null;
    }
}
