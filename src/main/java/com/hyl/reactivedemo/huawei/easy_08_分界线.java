package com.hyl.reactivedemo.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p> </p>
 *
 * @author hyl.c
 * @date {2023/4/10}
 */
public class easy_08_分界线 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] sourceArray = scanner.nextLine().split(" ");
        String[] targetArray = scanner.nextLine().split(" ");

        for (int i = 0; i < targetArray.length; i++) {
            String target = targetArray[i];
            boolean hit = false;
            for (int j = 0; j < sourceArray.length; j++) {
                String source = sourceArray[j];
                if (source.length() == target.length()
                        && equal(target, source)) {
                    hit = true;
                    // 不重复
                    sourceArray[i] = "";
                }
            }
            if (!hit) {
                System.out.println(hit);
                return;
            }
        }
        System.out.println(true);
    }

    private static boolean equal(String target, String source) {
        char[] tcs = target.toCharArray();
        char[] scs = source.toCharArray();
        Arrays.sort(tcs);
        Arrays.sort(scs);
        for (int i = 0; i < tcs.length; i++) {
            if (tcs[i] != scs[i]) {
                return false;
            }
        }
        return true;
    }
}
