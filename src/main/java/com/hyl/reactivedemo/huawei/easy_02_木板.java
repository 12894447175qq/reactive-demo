package com.hyl.reactivedemo.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p> </p>
 *
 * @author hyl.c
 * @date {2023/4/8}
 */
public class easy_02_木板 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split("");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        // 已经排序
        int[] nums = Arrays.stream(scanner.nextLine().split(""))
                .mapToInt(Integer::valueOf)
                .sorted()
                .toArray();

        for (int i = 0; i < nums.length - 1; i++) {
            if (m == 0) {
                break;
            }
            int diff = nums[i + 1] - nums[i] + 1;
            if (m >= diff) {
                m -= diff;
                nums[i] = nums[i] + diff;
            } else {
                nums[i] = nums[i] + m;
                m = 0;
            }
        }

        System.out.println(Math.min(nums[0], nums[1]));
    }
}
