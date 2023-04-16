package com.hyl.reactivedemo.huawei;

import java.util.Scanner;

/**
 * <p> </p>
 *
 * @author hyl.c
 * @date {2023/4/10}
 */
public class easy_07_对称字符串 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < size; i++) {
            String[] split = scanner.nextLine().split(" ");
            int n = Integer.parseInt(split[0]);
            int k = Integer.parseInt(split[1]);
            if (n == 1) {
                System.out.println("red");
                continue;
            }
            String str = process(n);
            System.out.println(str.charAt(k) == 'R' ? "red" : "blue");
        }

    }

    private static String process(int n) {
        if (n == 1) {
            return "R";
        }
        String right = process(n - 1);
        String left = "";
        for (int i = 0; i < right.length(); i++) {
            char c = right.charAt(i);
            left += c == 'R' ? "B" : "R";
        }
        return left + right;
    }

}
