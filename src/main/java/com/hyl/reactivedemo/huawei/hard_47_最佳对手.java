package com.hyl.reactivedemo.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p> </p>
 *
 * @author hyl.c
 * @date {2023/4/9}
 */
public class hard_47_最佳对手 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int size = Integer.parseInt(s[0]);
        int maxDiff = Integer.parseInt(s[1]);
        int[] nums = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        // 奇数差
        int[] diff0 = new int[nums.length / 2];
        // 偶数差
        int[] diff1 = new int[nums.length / 2 - 1];
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (i % 2 == 0) {
                diff1[i / 2 - 1] = nums[i] - nums[i - 1];
            } else {
                diff0[(i - 1) / 2] = nums[i] - nums[i - 1];
            }

        }
        int ans1 = 0, size1 = 0;
        for (int i = 0; i < diff0.length; i++) {
            if (diff0[i] <= maxDiff) {
                ans1 += diff0[i];
                size1++;
            }
        }

        int ans2 = 0, size2 = 0;
        for (int i = 0; i < diff1.length; i++) {
            if (diff1[i] <= maxDiff) {
                ans2 += diff1[i];
                size2++;
            }
        }
        if (size1 > size2) {
            System.out.println(ans1);
            return;
        }
        if (size1 < size2) {
            System.out.println(ans2);
            return;
        }
        if (size1 == 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(Math.min(ans1, ans2));

    }
}
