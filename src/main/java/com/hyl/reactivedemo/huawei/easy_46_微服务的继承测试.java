package com.hyl.reactivedemo.huawei;

import java.util.Scanner;

/**
 * <p> </p>
 *
 * @author hyl.c
 * @date {2023/4/8}
 */
public class easy_46_微服务的继承测试 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numLength = Integer.parseInt(scanner.nextLine());
        int[][] nums = new int[numLength][numLength];
        int out = 0, index = 0, ans = 0;
        while (scanner.hasNextLine()) {
            String[] split = scanner.nextLine().split(" ");
            if (split.length != numLength) {
                out = Integer.parseInt(split[0]);
                break;
            }
            for (int i = 0; i < split.length; i++) {
                nums[index][i] = Integer.parseInt(split[i]);
            }
            index++;
        }
        ans = dfs(nums, out - 1);
        System.out.println(ans);

    }

    private static int dfs(int[][] nums, int out) {
        int max = 0;
        for (int j = 0; j < nums[out].length; j++) {
            if (j == out || nums[out][j] == 0) {
                continue;
            }
            int v = dfs(nums, j);
            max = Math.max(v, max);
        }

        return max + nums[out][out];
    }
}
