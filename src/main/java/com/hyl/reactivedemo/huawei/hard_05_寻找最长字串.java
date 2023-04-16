package com.hyl.reactivedemo.huawei;

import java.util.HashMap;
import java.util.Scanner;

/**
 * <p> </p>
 *
 * @author hyl.c
 * @date {2023/4/9}
 */
public class hard_05_寻找最长字串 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String notStr = scanner.nextLine();
        String source = scanner.nextLine();

        String[] split = source.split(notStr);

        int ans = 0;
        for (int i = 0; i < split.length; i++) {
            char[] chars = split[i].toCharArray();
            if (ans >= chars.length) {
                continue;
            }
            int left = 0;

            // 检测最长长度
            for (int k = 0; k < chars.length; k++) {
                HashMap<Character, Integer> map = new HashMap<>();
                char c = chars[k];
                map.put(c, map.getOrDefault(c, 0) + 1);
                if (map.get(c) > 2) {
                    char lc = chars[left];
                    left++;
                    map.put(lc, map.get(lc) - 1);

                }
                ans = Math.max(ans, chars.length - left);
            }
        }

        System.out.println(ans);
    }
}
