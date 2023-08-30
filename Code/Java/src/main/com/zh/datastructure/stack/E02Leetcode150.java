package main.com.zh.datastructure.stack;

import java.util.LinkedList;

public class E02Leetcode150 {
    public int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (String t : tokens) {
            switch (t) {
                case "+" -> {
                    Integer b = stack.pop();
                    Integer a = stack.pop();
                    stack.push(a + b);
                }
                case "-" -> {
                    Integer b = stack.pop();
                    Integer a = stack.pop();
                    stack.push(a - b);
                }
                case "*" -> {
                    Integer b = stack.pop();
                    Integer a = stack.pop();
                    stack.push(a * b);
                }
                case "/" -> {
                    Integer b = stack.pop();
                    Integer a = stack.pop();
                    stack.push(a / b);
                }
                default -> { //数字
                    stack.push(Integer.parseInt(t));
                }
            }
        }
        return stack.pop();
    }
}
