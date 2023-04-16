package com.hyl.reactivedemo.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * <p> </p>
 *
 * @author hyl.c
 * @date {2023/4/9}
 */
public class hard_45_最多几个三角形 {
    // 放索引
    private static List<Integer> path = new ArrayList<>();
    private static int ans = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < T; i++) {
            String[] split = scanner.nextLine().split(" ");
            int[] nums = new int[split.length - 1];
            for (int j = 1; j < split.length; j++) {
                nums[j - 1] = Integer.parseInt(split[j]);
            }
            Arrays.sort(nums);
            dfs(nums, 0);
            System.out.println(ans);
            ans=0;
        }

    }

    private static void dfs(int[] nums, int start) {
        if (path.size() == 3) {
            Integer ai = path.get(0);
            Integer bi = path.get(1);
            Integer ci = path.get(2);
            int l1 = nums[ai];
            int l2 = nums[bi];
            int l3 = nums[ci];
            if (l1 == 0 || l2 == 0 || l3 == 0) {
                return;
            }
            if ((l1 * l1 + l2 * l2) == (l3 * l3)) {
                ans++;
                nums[ai] = 0;
                nums[bi] = 0;
                nums[ci] = 0;
            }
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            path.add(i);
            dfs(nums, i + 1);
            path.remove(path.size() - 1);

        }
    }
}
