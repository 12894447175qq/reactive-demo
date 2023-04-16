package com.hyl.reactivedemo.huawei;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * <p> </p>
 *
 * @author hyl.c
 * @date {2023/4/8}
 */
public class easy_47_字符串重新排序 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        String ans = Arrays.stream(split)
                .map(e -> {
                    char[] charArray = e.toCharArray();
                    Arrays.sort(charArray);
                    return String.valueOf(charArray);
                })
                .peek(e -> map.put(e, map.getOrDefault(e, 0) + 1))
                .sorted((o1, o2) -> {
                    Integer o1Num = map.get(o1);
                    Integer o2Num = map.get(o2);
                    if (o1Num > o2Num) {
                        return -1;
                    }
                    if (o1Num < o2Num) {
                        return 1;
                    }
                    char[] o1C = o1.toCharArray();
                    char[] o2C = o2.toCharArray();
                    if (o1C.length == o2C.length) {
                        for (int i = 0; i < o1C.length; i++) {
                            if (o2C[i] > o1C[i]) {
                                return -1;
                            }
                            if (o2C[i] < o1C[i]) {
                                return 1;
                            }
                        }
                        return 0;
                    } else {
                        return o1C.length - o2C.length;
                    }
                })
                .collect(Collectors.joining(" "));
        System.out.println(ans);

    }
}
