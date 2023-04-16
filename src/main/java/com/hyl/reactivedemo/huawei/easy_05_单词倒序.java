package com.hyl.reactivedemo.huawei;

import java.util.Scanner;
import java.util.Stack;

/**
 * <p> </p>
 *
 * @author hyl.c
 * @date {2023/4/8}
 */
public class easy_05_单词倒序 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String source = scanner.nextLine();
        StringBuilder builder = new StringBuilder();
        char[] chars = source.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < chars.length; i++) {
            char value = chars[i];
            if (value == ',' || value == '.' || value == ' ') {
                while (!stack.isEmpty()) {
                    builder.append(stack.pop());
                }
                builder.append(value);
            } else {
                stack.add(value);
            }
        }

        System.out.println(builder.toString());
    }
}
