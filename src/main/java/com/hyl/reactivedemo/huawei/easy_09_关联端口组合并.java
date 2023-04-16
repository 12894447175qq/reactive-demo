package com.hyl.reactivedemo.huawei;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p> </p>
 *
 * @author hyl.c
 * @date {2023/4/10}
 */
public class easy_09_关联端口组合并 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        List<TreeSet<Integer>> ans = new ArrayList<>();
        if (length > 10 || length < 1) {
            ans.add(new TreeSet<>());
            System.out.println(ans);
            return;
        }
        scanner.nextLine();
        for (int i = 0; i < length; i++) {
            String[] split = scanner.nextLine().split(",");
            TreeSet<Integer> set = new TreeSet<>();
            Arrays.stream(split)
                    .mapToInt(Integer::parseInt)
                    .sorted()
                    .forEach(set::add);
            ans.add(set);
        }
        boolean mark = true;
        while (mark) {
            mark = false;
            for (int i = 0; i < ans.size(); i++) {
                Set<Integer> left = ans.get(i);
                if (left.size() < 2) {
                    continue;
                }
                boolean m = false;
                for (int j = i+1; j < ans.size(); j++) {
                    Set<Integer> right = ans.get(j);
                    if (right.size() < 2) {
                        continue;
                    }
                    //判断两者交集是不是有两个
                    boolean r = merge(left, right);
                    if (r) {
                        m = true;
                        left.addAll(right);
                        right.clear();
                        break;
                    }
                }
                if (m) {
                    mark=true;
                    break;
                }
            }

        }
        ans.removeIf(TreeSet::isEmpty);
        System.out.println(ans);
    }

    private static boolean merge(Set<Integer> left, Set<Integer> right) {
        int count = 0;
        for (Integer l : left) {
            if (right.contains(l)) {
                count++;
            }
        }
        return count >= 2;
    }
}
