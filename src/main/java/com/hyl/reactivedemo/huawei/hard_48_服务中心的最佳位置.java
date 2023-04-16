package com.hyl.reactivedemo.huawei;

import java.util.Scanner;

/**
 * <p> </p>
 *
 * @author hyl.c
 * @date {2023/4/9}
 */
public class hard_48_服务中心的最佳位置 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        scanner.nextLine();
        int[][] nums = new int[size][2];
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            String[] split = scanner.nextLine().split(" ");
            for (int j = 0; j < split.length; j++) {
                int parseInt = Integer.parseInt(split[j]);
                nums[i][j] = parseInt;
                min = Math.min(min, parseInt);
                max = Math.max(max, parseInt);
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = min; i < max; i++) {
            int t = distance(nums, i);
            ans = Math.min(ans, t);
        }
        System.out.println(ans);
    }

    private static int distance(int[][] nums, int position) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i][1] < position) {
                ans += position - nums[i][1];
            } else if (nums[i][0] > position) {
                ans += nums[i][0] - position;
            } else if (nums[i][0] <= position && nums[i][1] >= position) {
                ans += 0;
            }
        }
        return ans;
    }
}
