package com.hyl.reactivedemo.recall;

public class EightQueens {
    private final int N = 4; // 棋盘大小
    private int[][] board = new int[N][N]; // 棋盘
    private int count = 0; // 解法计数器

    // 判断当前位置是否可行
    private boolean isValid(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) { // 同一列已有皇后
                return false;
            }
            if (col - row + i >= 0 && board[i][col - row + i] == 1) { // 左上方已有皇后
                return false;
            }
            if (col + row - i < N && board[i][col + row - i] == 1) { // 右上方已有皇后
                return false;
            }
        }
        return true;
    }

    // 回溯算法求解
    private void backtrack(int row) {
        if (row == N) { // 找到一个解法
            count++;
            printSolution();
            return;
        }
        for (int col = 0; col < N; col++) {
            if (isValid(row, col)) { // 当前位置可行
                board[row][col] = 1; // 放置皇后
                backtrack(row + 1); // 继续搜索下一行
                board[row][col] = 0; // 回溯，撤销当前选择
            }
        }
    }

    // 输出解法
    private void printSolution() {
        System.out.println("Solution " + count + ":");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        EightQueens eq = new EightQueens();
        eq.backtrack(0);
    }
}
