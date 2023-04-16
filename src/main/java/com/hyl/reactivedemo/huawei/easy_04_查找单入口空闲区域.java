package com.hyl.reactivedemo.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * <p> </p>
 *
 * @author hyl.c
 * @date {2023/4/8}
 */
public class easy_04_查找单入口空闲区域 {
    private static List<Pos> enterList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        scanner.nextLine();
        int[][] nums = new int[row][col];
        for (int i = 0; i < row; i++) {
            String[] split = scanner.nextLine().split(" ");
            for (int j = 0; j < split.length; j++) {
                if (split[j].equals("X")) {
                    nums[i][j] = 0;
                } else {
                    nums[i][j] = 1;
                    if (i == 0 || i == row - 1) {
                        enterList.add(new Pos(i, j));
                    } else if (j == 0 || j == col - 1) {
                        enterList.add(new Pos(i, j));
                    }
                }
            }
        }
        int asxNum = 0, ans = 0, ax = 0, ay = 0;
        for (Pos pos : enterList) {
            int x = dfs(nums, pos.x, pos.y, 0);
            if (x > 0) {
                if (x > ans) {
                    ans = x;
                    ax = pos.x;
                    ay = pos.y;
                }
                asxNum++;
            }

        }
        if (asxNum == 0) {
            System.out.println("NULL");
        }
        if (asxNum > 1) {
            System.out.println(ans);
        }

        System.out.println(ax + " " + ay + " " + ans);
    }

    private static int dfs(int[][] nums, int x, int y, int sum) {
        // 判断当前节点是否五路可走
        for (int i = x; i < nums.length; i++) {
            for (int j = y; j < nums[0].length; j++) {
                //不能走回头路
                nums[i][j] = 0;

                //下
                if (i + 1 < nums.length && nums[i + 1][j] == 1) {
                    int dfs = dfs(nums, i + 1, j, sum + 1);
                    if (dfs > 0) {
                        //回撤
                        nums[i][j] = 1;
                        return dfs;
                    }
                }

                //右
                if (j + 1 < nums[0].length && nums[i][j + 1] == 1) {
                    int dfs = dfs(nums, i, j + 1, sum + 1);
                    if (dfs > 0) {
                        //回撤
                        nums[i][j] = 1;
                        return dfs;
                    }
                }

                //左
                if (j - 1 >= 0 && nums[i][j - 1] == 1) {
                    int dfs = dfs(nums, i, j - 1, sum + 1);
                    if (dfs > 0) {
                        //回撤
                        nums[i][j] = 1;
                        return dfs;
                    }
                }
                //上
                if (i - 1 >= 0 && nums[i - 1][j] == 1) {
                    int dfs = dfs(nums, i - 1, j, sum + 1);
                    if (dfs > 0) {
                        //回撤
                        nums[i][j] = 1;
                        return dfs;
                    }
                }

                //回撤
                nums[i][j] = 1;
                if (sum == 0) {
                    return sum + 1;
                }
                // 是入口，联通了
                if (enterList.contains(new Pos(i,j))) {
                    return -1;
                }
                return sum + 1;

            }
        }
        return -1;
    }

    static class Pos {
        private int x;
        private int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pos pos = (Pos) o;
            return x == pos.x &&
                    y == pos.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

}
