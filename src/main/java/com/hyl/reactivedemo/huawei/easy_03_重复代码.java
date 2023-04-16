package com.hyl.reactivedemo.huawei;

import java.util.Scanner;

/**
 * <p> </p>
 *
 * @author hyl.c
 * @date {2023/4/8}
 */
public class easy_03_重复代码 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String left = scanner.nextLine();
        String right = scanner.nextLine();
        // 找出两个字符串中 最长公共串

        //短的作为驱动字段
        if (left.length() > right.length()) {
            String temp = left;
            left = right;
            right = temp;
        }
        String ans = "";
        for (int i = 0; i < left.length(); i++) {
            for (int j = i + 1; j <= left.length(); j++) {
                String leftValue = left.substring(i, j);

                for (int k = 0; k < right.length(); k++) {
                    for (int l = k + 1; l <= right.length() && (l - k) <= (j - i); l++) {
                        String rightValue = right.substring(k, l);
                        if (leftValue.equals(rightValue) && leftValue.length() > ans.length()) {
                            ans = leftValue;
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
