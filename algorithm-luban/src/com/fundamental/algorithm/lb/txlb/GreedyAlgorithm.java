package com.fundamental.algorithm.lb.txlb;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description:
 * 贪心算法（贪婪算法）
 * 只顾眼前不顾全局，是局部最优解
 *
 * 最重要两点
 * 1.贪心策略
 * 2.通过局部最优解能够得到全局最优解
 *
 * 会议室安排问题
 * 有N个同等级的会议需要在同一天使用同一个会议室，现在给你这个N个会议的开始和结束
 * 时间，你怎么样才能使会议室最大利用？即安排最多场次的会议。
 * 8点~9点
 * 8点~10点
 * 10点~12点
 * 8点~20点
 * 解题思路
 * 结束时间最早的会议优先，作为第一场
 * 找剩下的结束时间最早的，而且开始时间要大于第一场结束，作为第二场
 * 重复以上操作。
 * @Date 2019/9/15 10:49
 * @Version 1.0
 */
public class GreedyAlgorithm {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 会议的次数
        int num = scanner.nextInt();
        List<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            // 开始时间
            int start = scanner.nextInt();
            // 结束时间
            int end = scanner.nextInt();
            Meeting meeting = new Meeting(i + 1, start, end);
            meetings.add(meeting);
        }
        // * List排序，null为使用默认的比较器，以结束时间排序，这个排序其实就是贪心策略
        meetings.sort(null);
        // 当前时间
        int currentTime = 0;
        for (int i = 0; i < num; i++) {
            Meeting meeting = meetings.get(i);
            // * 判断能不能开，开始时间大于当前时间（上一次的结束时间）
            if (meeting.getStartTime() >= currentTime){
                System.out.println(meeting.toString());
                // 更新当前时间
                currentTime = meeting.getEndTime();
            }
        }
    }
}
