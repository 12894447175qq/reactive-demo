package com.hyl.reactivedemo.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p> </p>
 *
 * @author hyl.c
 * @date {2023/4/13}
 */
public class e_03_快排 {
    private static int x = 0;
    private static int y = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(" ");
        int[] ints = Arrays.stream(strings)
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int i = 0; i < ints.length; i++) {
            splitSort(ints, i, ints.length - 1);
        }
        for (int i : ints) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("x:" + x);
        System.out.println("y:" + y);
    }

    private static void splitSort(int[] ints, int left, int right) {
        if (left < right) {
            Integer position = hand(ints, left, right);
            splitSort(ints, left, position - 1);
            splitSort(ints, position + 1, right);
        }
    }

    private static Integer hand(int[] ints, int left, int right) {
        int base = ints[right];

        int leftStart = left;
        for (int i = left; i < right; i++) {
            if (ints[i] <= base) {
                x++;
                if (i == leftStart) {
                    leftStart++;
                    continue;
                }
                //交换位置
                int temp = ints[i];
                ints[i] = ints[leftStart];
                ints[leftStart] = temp;
                leftStart++;
                y++;
            }
        }
        //交换高位
        int temp = ints[leftStart];
        ints[leftStart] = ints[right];
        ints[right] = temp;
        return leftStart;
    }
}
