package com.hyl.reactivedemo.huawei;

import java.util.HashMap;
import java.util.Scanner;

/**
 * <p> </p>
 *
 * @author hyl.c
 * @date {2023/4/9}
 */
public class hard_03_最多等和不相交连续子序列 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numSize = scanner.nextInt();
        scanner.nextLine();
        int[] nums = new int[numSize];
        String[] split = scanner.nextLine().split(" ");
        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }

        HashMap<Integer, Integer> targetLastIndexMap = new HashMap<>();
        HashMap<Integer, Integer> targetTimeMap = new HashMap<>();
        int ans = 0;
        int[] sumArray = new int[numSize + 1];

        for (int i = 0; i < numSize; i++) {
            sumArray[i + 1] = nums[i] + sumArray[i];

            // 局部最优，到全部最优 动态规划
            for (int j = i; j >= 0; j--) {
                // 代表子序列值 （后向前 i ---》0 ）
                int target = sumArray[i + 1] - sumArray[j];
                if (targetLastIndexMap.getOrDefault(target, 0) <= j) {
                    targetLastIndexMap.put(target, i + 1);
                    targetTimeMap.put(target, targetTimeMap.getOrDefault(target, 0) + 1);
                }
                ans = Math.max(ans, targetTimeMap.get(target));
            }

        }

        System.out.println(ans);

    }


}
