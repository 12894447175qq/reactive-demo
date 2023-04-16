package com.hyl.reactivedemo.huawei;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * <p> </p>
 *
 * @author hyl.c
 * @date {2023/4/10}
 */
public class easy_41_静态代码扫描服务 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        scanner.nextLine();
        int[] fileNums = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] fileSizes = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> firstMap = new HashMap<>();
        for (int i = 0; i < fileNums.length; i++) {
            int fileIndex = fileNums[i];
            int fileSize = fileSizes[i];
            int total = map.getOrDefault(fileIndex, 0) + fileSize;
            map.put(fileIndex, total);
            if (!firstMap.containsKey(fileIndex)) {
                firstMap.put(fileIndex, fileSize);
            }
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans += Math.min(entry.getValue(), firstMap.get(entry.getKey()) + M);
        }
        System.out.println(ans);
    }
}
