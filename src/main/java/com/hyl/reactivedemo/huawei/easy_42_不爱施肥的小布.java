package com.hyl.reactivedemo.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p> </p>
 *
 * @author hyl.c
 * @date {2023/4/10}
 */
public class easy_42_不爱施肥的小布 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int size = Integer.parseInt(split[0]);
        int day = Integer.parseInt(split[1]);
        int[] ints = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        if (day < size) {
            System.out.println(-1);
            return;
        }
        for (int i = 0; i < ints.length; i++) {
            int totalDay = i + 1;
            for (int j = i + 1; j < ints.length; j++) {
                if (ints[j] % ints[i] == 0) {
                    totalDay += ints[j] / ints[i];
                } else {
                    totalDay += (ints[j] / ints[i] + 1);

                }
            }
            if (totalDay <= day) {
                System.out.println(ints[i]);
                return;
            }
        }

    }
}
