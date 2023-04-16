package com.hyl.reactivedemo.huawei;

import java.util.Scanner;

/**
 * <p> </p>
 *
 * @author hyl.c
 * @date {2023/4/9}
 */
public class hard_01_不含101的数字 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int left = scanner.nextInt();
        int right = scanner.nextInt();
        int ans = 0;
        String target = "101";
        for (int i = left; i <= right; i++) {
            if (!Integer.toBinaryString(i).contains(target)) {
                ans++;
            }
        }
        System.out.println(ans);

    }
}
