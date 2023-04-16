package com.hyl.reactivedemo.huawei;

import java.util.Scanner;

/**
 * <p> </p>
 *
 * @author hyl.c
 * @date {2023/4/8}
 */
public class easy_50_核酸检测 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caiNum = scanner.nextInt();
        int zhiNum = scanner.nextInt();
        int[] zhiRas = new int[caiNum];
        for (int i = 0; i < zhiRas.length; i++) {
            zhiRas[i] = scanner.nextInt();
        }
        int[][] dp = new int[caiNum + 1][zhiNum + 1];
        int sum = 0;
        for (int i = 1; i <= caiNum; i++) {
            for (int j = 0; j <= zhiNum; j++) {
                if (j == 0) {
                    dp[i][j] = sum = sum + (int) (zhiRas[i - 1] * 0.8);
                    continue;
                }
                if (i >= j) {
                    dp[i][j] = dp[i][0] + (j) * (int) (zhiRas[i - 1] * 0.2);
                } else {
                    dp[i][j] = dp[i][i] + (j - i) * (int) (zhiRas[i - 1] * 0.1);
                }
            }
        }
        System.out.println(dp[caiNum][zhiNum]);
    }
}
