package com.hyl.reactivedemo.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * <p> </p>
 *
 * @author hyl.c
 * @date {2023/4/8}
 */
public class easy_48_Mvp争夺 {
    private static List<Integer> path = new ArrayList<>();
    private static List<List<Integer>> ansList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int minuteNum = 0;
        List<Integer> collect = null;
        while (scanner.hasNextLine()) {
            String[] split = scanner.nextLine().split(" ");
            if (split.length == 1) {
                minuteNum = Integer.parseInt(split[0]);
                continue;
            }
            collect = Arrays.stream(split)
                    .mapToInt(Integer::valueOf)
                    .sorted()
                    .boxed()
                    .collect(Collectors.toList());
        }


        int max = collect.get(collect.size() - 1);
        int sum = 0;
        for (Integer num : collect) {
            sum += num;
        }
        int ans = sum;
        for (int i = 2; i < minuteNum; i++) {
            if (sum % i != 0) {
                continue;
            }
            int score = sum / i;
            if (max > score) {
                break;
            }
            dfs(collect, score, 0, 0);
            if (i == ansList.size()) {
                ans = Math.min(ans, score);
            }
        }
        System.out.println(ans);
    }

    private static void dfs(List<Integer> collect, int target, int score, int start) {
        if (score > target) {
            return;
        }

        if (target == score && score != 0) {
            ansList.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < collect.size(); i++) {
            score += collect.get(i);
            path.add(i);
            dfs(collect, target, score, i + 1);
            score -= collect.get(i);
            path.remove(path.size() - 1);
        }
    }
}
