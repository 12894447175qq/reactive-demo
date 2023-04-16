package com.hyl.reactivedemo.huawei;

import java.util.Scanner;

/**
 * <p> </p>
 *
 * @author hyl.c
 * @date {2023/4/9}
 */
public class hard_02_去除经量少的球 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = scanner.nextInt();
        int bucket = scanner.nextInt();
        scanner.nextLine();
        String[] split = scanner.nextLine().split(" ");
        int[] bucketArray = new int[bucket];

        int total = 0;
        int max = 0;
        for (int i = 0; i < bucket; i++) {
            int num = Integer.parseInt(split[i]);
            bucketArray[i] = num;
            max = Math.max(max, num);
            total += num;
        }

        if (sum >= total) {
            System.out.println("[]");
            return;
        }
        int perBucketMax = sum / bucket;
        int[] ans = new int[bucket];

        for (int i = perBucketMax; i <= max; i++) {
            int tempSum = 0;
            for (int j = 0; j < bucketArray.length; j++) {
                int bucketSize = bucketArray[j];
                if (bucketSize > i) {
                    ans[j] = bucketSize - i;
                } else {
                    ans[j] = 0;
                }
                tempSum += (bucketSize - ans[i]);
            }
            if (tempSum > sum) {
                break;
            }

        }

        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < ans.length; i++) {
            builder.append(ans[i]);
            if (i != ans.length - 1) {
                builder.append(",");
            }
        }
        builder.append("]");
        System.out.println(builder.toString());
    }
}
