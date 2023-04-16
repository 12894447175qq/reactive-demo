package com.hyl.reactivedemo.huawei;

import java.util.Scanner;

/**
 * <p> </p>
 *
 * @author hyl.c
 * @date {2023/4/9}
 */
public class hard_04_excel单元格数值统计 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int row = Integer.parseInt(s[0]);
        int col = Integer.parseInt(s[1]);
        String[][] excelArray = new String[row][col];
        for (int i = 0; i < excelArray.length; i++) {
            String[] split = scanner.nextLine().split(" ");
            for (int j = 0; j < split.length; j++) {
                excelArray[i][j] = split[j];
            }
        }
        String[] areaArray = scanner.nextLine().split(":");
        char[] start = areaArray[0].toCharArray();
        int sy = start[0] - 'A';
        int sx = start[1] - '1';
        char[] end = areaArray[1].toCharArray();
        int ey = end[0] - 'A';
        int ex = end[1] - '1';

        int sum = 0;
        for (int i = sx; i <= ex; i++) {
            for (int j = sy; j <= ey; j++) {
                int val;
                String excelValue = excelArray[i][j];
                if (excelValue.startsWith("=")) {
                    String substring = excelValue.substring(1);
                    if (substring.contains("+")) {
                        String[] split = substring.split("\\+");
                        int left = getValue(excelArray, split[0]);
                        int right = getValue(excelArray, split[1]);
                        val = left + right;
                    } else if (substring.contains("-")) {
                        String[] split = substring.split("-");
                        int left = getValue(excelArray, split[0]);
                        int right = getValue(excelArray, split[1]);
                        val = left - right;
                    } else {
                        val = getValue(excelArray, substring);
                    }

                } else {
                    val = Integer.parseInt(excelValue);
                }
                sum += val;
            }
        }


        System.out.println(sum);
    }

    private static int getValue(String[][] excelArray, String index) {
        char[] chars = index.toCharArray();
        if (chars[0] < 'A' || chars[0] > 'Z') {
            return Integer.parseInt(index);
        }
        int y = chars[0] - 'A';
        int x = chars[1] - '1';
        return Integer.parseInt(excelArray[x][y]);
    }
}
