package com.hyl.reactivedemo.huawei;

import java.util.Scanner;

/**
 * <p> </p>
 *
 * @author hyl.c
 * @date {2023/4/8}
 */
public class easy_49_贪心商人 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int skuNums = scanner.nextInt();
        int days = scanner.nextInt();
        int[] maxInventory = new int[skuNums];
        for (int i = 0; i < maxInventory.length; i++) {
            maxInventory[i] = scanner.nextInt();
        }
        int[][] skuPrices = new int[skuNums][days];
        int[][] skuProfit = new int[skuNums][days];
        for (int i = 0; i < skuNums; i++) {
            for (int j = 0; j < days; j++) {
                int price = scanner.nextInt();
                skuPrices[i][j] = price;
                if (j != 0) {
                    skuProfit[i][j] = price - skuPrices[i][j - 1];
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < skuNums; i++) {
            for (int j = 0; j < days; j++) {
                int profit = skuProfit[i][j];
                if (profit > 0) {
                    ans += profit * maxInventory[i];
                }
            }
        }
        System.out.println(ans);

    }
}
