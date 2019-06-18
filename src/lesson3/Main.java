package lesson3;

import lesson3.stack.Stack;
import lesson3.stack.StackImpl;

public class Main {
    public static void main(String[] args) {
        printRightToLeft("1234567890");
    }

    private static void printRightToLeft(String text) {
        Stack<Character> stack = new StackImpl<>(text.length());
        char[] charArray = text.toCharArray();
        for (char c : charArray) {
            stack.push(c);
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
