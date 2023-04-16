package com.hyl.reactivedemo.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * <p> </p>
 *
 * @author hyl.c
 * @date {2023/4/10}
 */
public class easy_43_AI处理器组合 {
    public static void main(String[] args) {
        String s="x";
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().replace("[", "")
                .replace("]", "")
                .split(",");
        int cpnN = scanner.nextInt();
        if (cpnN > split.length) {
            System.out.println("[]");
            return;
        }
        int[] cpnIndex = Arrays.stream(split)
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        List<List<Integer>> ansList = new ArrayList<>();
        if (cpnIndex[0] < 4) {
            ansList.add(new ArrayList<>());
        }
        if (cpnIndex[cpnIndex.length - 1] > 4) {
            ansList.add(new ArrayList<>());
        }
        for (int index : cpnIndex) {
            if (index < 4) {
                ansList.get(0).add(index);
            } else {
                ansList.get(1).add(index);
            }
        }
        switch (cpnN) {
            case 1:
                if (ansList.size() == 1) {
                    System.out.println(ansList);
                    return;
                }
                List<List<Integer>> ans1 = new ArrayList<>();
                ans1.add(check(ansList, new int[]{1, 3, 2, 4}));
                System.out.println(ans1);
                return;

            case 2:
                if (ansList.size() == 1) {
                    System.out.println(ansList);
                    return;
                }
                List<List<Integer>> ans2 = new ArrayList<>();
                ans2.add(check(ansList, new int[]{2, 4, 3}));
                System.out.println(ans2);
                return;
            case 4:
                List<List<Integer>> ans4 = new ArrayList<>();
                ans4.add(check(ansList, new int[]{4}));
                System.out.println(ans4);
                return;
            case 8:
                int ans8 = 1;
                for (List<Integer> integers : ansList) {
                    if (integers.size() == 4) {
                        ans8++;
                    }
                }
                if (ans8 == 2) {
                    System.out.println(ansList);
                } else {
                    System.out.println("[]");
                }
                return;
            default:
                return;

        }
    }

    private static List<Integer> check(List<List<Integer>> ansList, int[] ints) {
        List<Integer> integers0 = ansList.get(0);
        List<Integer> integers1 = ansList.get(1);
        for (int i : ints) {
            if (integers0.size() == i) {
                return integers0;
            }
            if (integers1.size() == i) {
                return integers0;
            }
        }
        return new ArrayList<>();
    }
}
