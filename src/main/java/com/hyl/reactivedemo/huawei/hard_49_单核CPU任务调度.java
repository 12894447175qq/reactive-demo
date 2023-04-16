package com.hyl.reactivedemo.huawei;

import java.util.*;

/**
 * <p> </p>
 *
 * @author hyl.c
 * @date {2023/4/9}
 */
public class hard_49_单核CPU任务调度 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Task> taskList = new ArrayList<>();
        while (scanner.hasNextLine()) {
            int[] ints = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            taskList.add(new Task(ints[0], ints[1], ints[2], ints[3]));
        }
        cal(taskList);
    }

    private static void cal(List<Task> taskList) {
        Task first = taskList.remove(0);
        // 第一个任务的到达时间
        int start = first.arrive;
        PriorityQueue<Task> queue = new PriorityQueue<Task>(((o1, o2) -> {
            if (!o1.priority.equals(o2.priority)) {
                return o2.priority - o1.priority;
            }
            return o1.arrive - o2.arrive;
        }));
        queue.add(first);
        for (int i = 0; i < taskList.size(); i++) {
            Task nextTask = taskList.get(i);
            Task curTask = queue.peek();

            int curFinish = start + curTask.need;

            // 判断时间,上个任务是否完成
            if (nextTask.arrive >= curFinish) {
                //取出
                Task poll = queue.poll();
                System.out.println(poll.id + " " + curFinish);
                start = curFinish;
                // 做点事情
                if (nextTask.arrive > curFinish) {
                    while (!queue.isEmpty()) {
                        Task task = queue.peek();
                        int taskFinish = start + task.need;
                        if (nextTask.arrive < taskFinish) {
                            task.need = task.need - (nextTask.arrive - start);
                            break;
                        } else {
                            queue.poll();
                            System.out.println(task.id + " " + taskFinish);
                            start = taskFinish;
                        }
                    }
                    start = nextTask.arrive;
                }
            } else {
                // 当前时间 设置为 当前到达的时间
                curTask.need = curTask.need - (nextTask.arrive - start);
                start = nextTask.arrive;
            }
            queue.add(nextTask);
        }
        while (!queue.isEmpty()) {
            Task task = queue.poll();
            int taskFinish = start + task.need;
            System.out.println(task.id + " " + taskFinish);
            start = taskFinish;
        }

        System.out.println(queue);
    }

    static class Task {
        private Integer id;
        private Integer priority;
        private Integer need;
        private Integer arrive;

        public Task(Integer id, Integer priority, Integer need, Integer arrive) {
            this.id = id;
            this.priority = priority;
            this.need = need;
            this.arrive = arrive;
        }
    }
}
