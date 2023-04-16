package com.hyl.reactivedemo.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p> </p>
 *
 * @author hyl.c
 * @date {2023/4/13}
 */
public class e_02_选择排序 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(" ");
        int[] ints = Arrays.stream(strings)
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < ints.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < ints.length; j++) {
                if (ints[j] < ints[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = ints[minIndex];
                ints[minIndex] = ints[i];
                ints[i] = temp;
            }
        }
        for (int i : ints) {
            System.out.print(i + " ");
        }
    }
}
