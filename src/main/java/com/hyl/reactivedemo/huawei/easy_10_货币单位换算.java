package com.hyl.reactivedemo.huawei;

import java.util.Scanner;

/**
 * <p> </p>
 *
 * @author hyl.c
 * @date {2023/4/10}
 */
public class easy_10_货币单位换算 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        double ans = 0;
        scanner.nextLine();
        for (int i = 0; i < length; i++) {
            String line = scanner.nextLine();
            double process = process(line);
            ans+=process;
        }
        System.out.println(ans);
    }

    private static double process(String line) {
        double ans = 0;
        char[] chars = line.toCharArray();
        String numStr = "";
        for (char c : chars) {
            if (Character.isDigit(c)) {
                numStr += c;
            } else {
                if (numStr.isEmpty()) {
                    continue;
                }
                ans += covert(numStr, c);
                numStr="";
            }
        }
        return ans;
    }

    private static double covert(String numStr, char c) {
        int num = Integer.parseInt(numStr);
        switch (c) {
            case 'C':
                return (double) num * 100;
            case 'H':
                return (double) num * 10000 / 123 ;
            case 'J':
                return (double) num * 10000 / 1825;
            case 'E':
                return (double) num * 10000 / 14;
            case 'G':
                return (double) num * 10000 / 12;
            case 'f':
                return (double) num;
            case 'c':
                return (double) num * 100/ 123  ;
            case 's':
                return (double) num * 100/ 1825  ;
            case 'e':
                return (double) num * 100/ 14  ;
            case 'p':
                return (double) num * 100 / 12  ;
            default:
                return 0;
        }
    }

}
