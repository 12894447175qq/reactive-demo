package com.hyl.reactivedemo.huawei;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * <p> </p>
 *
 * @author hyl.c
 * @date {2023/4/8}
 */
public class easy_01_猜灯谜 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] sourceArray = null;
        String[] targetArray = null;
        while (scanner.hasNextLine()) {
            sourceArray = scanner.nextLine().split(",");
            targetArray = scanner.nextLine().split(",");
        }
        // source 中获取 target
        List<String> ans = new ArrayList<>();
        for (String source : sourceArray) {
            for (String target : targetArray) {
                if (source.equals(target)) {
                    ans.add(target);
                    break;
                }
                if (equalTo(source, target)) {
                    ans.add(target);
                    break;
                }

            }
        }
        if (ans.isEmpty()) {
            ans.add("not found");
        }
        String ansStr = ans.stream().collect(Collectors.joining(","));
        System.out.println(ansStr);

    }

    private static boolean equalTo(String source, String target) {
        HashSet<Character> targetSet = new HashSet<>();
        for (char c : target.toCharArray()) {
            targetSet.add(c);
        }
        for (char sc : source.toCharArray()) {
            if (!targetSet.contains(sc)) {
                return false;
            }
        }
        return true;
    }
}
