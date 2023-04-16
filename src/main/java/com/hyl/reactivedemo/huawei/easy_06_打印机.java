package com.hyl.reactivedemo.huawei;

import java.util.LinkedHashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * <p> </p>
 *
 * @author hyl.c
 * @date {2023/4/10}
 */
public class easy_06_打印机 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        scanner.nextLine();
        LinkedHashMap<Integer, PriorityQueue> map = new LinkedHashMap<>();
        int id = 1;
        for (int i = 0; i < size; i++) {
            String[] split = scanner.nextLine().split(" ");
            // 输入
            if (split.length == 3) {
                id++;
                int p = Integer.parseInt(split[1]);
                int num = Integer.parseInt(split[2]);
                PrintTask task = new PrintTask(id, num, p);
                PriorityQueue<PrintTask> queue = map.getOrDefault(p, new PriorityQueue<PrintTask>(((o1, o2) ->
                        o1.priority == o2.priority ? o1.id - o2.id : o2.priority - o1.priority)));
                queue.add(task);
                if (!map.containsKey(p)) {
                    map.put(p, queue);
                }
            } else {
                // 输出
                int p = Integer.parseInt(split[1]);
                PriorityQueue queue = map.get(p);
                if (!queue.isEmpty()) {
                    PrintTask poll = (PrintTask) queue.poll();
                    System.out.println(poll.id);
                } else {
                    System.out.println("NULL");
                }


            }

        }


    }

    static class PrintTask {
        private int id;
        private int priority;
        private int p;

        public PrintTask(int id, int priority, int p) {
            this.id = id;
            this.priority = priority;
            this.p = p;
        }


    }
}
