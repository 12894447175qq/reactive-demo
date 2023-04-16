package com.hyl.reactivedemo.recall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EightQueensCase {
    private final static int COL = 8;
    private static int[][] ints = new int[COL][COL];

    // 回溯
    public void recall(int rows, List<Integer[][]> result) {
        // 回溯有结果
        if (rows == COL) {
            int[][] copyOf = Arrays.copyOf(EightQueensCase.ints, ints.length);
            //result.add(copyOf);
            return;
        }
        for (int i = 0; i < COL; i++) {
            // 检测当前位置
            if (verify(rows,i)) {
                ints[rows][i] = 1;
                recall(rows + 1, result);
                ints[rows][i] = 0;
            }
        }

    }

    private boolean verify(int rows, int col) {
        for (int j = 0; j < rows; j++) {
            // 检测同一行是否有数据
            if (ints[j][col]==1){
                return false;
            }
            // 左上方已有皇后
            if (col - rows + j >= 0 && ints[j][col - rows + j] == 1) {
                return false;
            }
            // 右上方已有皇后
            if (col + rows - j < COL && ints[j][col + rows - j] == 1) {
                return false;
            }
        }
        return true;
    }

    //  自己手写 一次
    public static void main(String[] args) {
        List<Integer[][]> list = new ArrayList<>();
        EightQueensCase queensCase = new EightQueensCase();
        queensCase.recall(0, list);
        System.out.println(list);
    }
}
