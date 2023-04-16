package com.hyl.reactivedemo.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p> </p>
 *
 * @author hyl.c
 * @date {2023/4/13}
 */
public class e_01_冒泡排序 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(" ");
        int[] ints = Arrays.stream(strings)
                .mapToInt(Integer::parseInt)
                .toArray();

        int times = 0;
        for (int i = 0; i < ints.length; i++) {
            // 没有交换，代表 全部都已经有序，顺序ok
            boolean success = true;
            for (int j = 0; j < ints.length - i - 1; j++) {
                if (ints[j] > ints[j + 1]) {
                    //交换位置
                    int temp = ints[j];
                    ints[j] = ints[j + 1];
                    ints[j + 1] = temp;
                    times++;
                    success = false;
                }
            }
            if (success) {
                break;
            }
        }
        for (int i : ints) {
            System.out.print(i + " ");
        }
        System.out.println(times);
    }

}
