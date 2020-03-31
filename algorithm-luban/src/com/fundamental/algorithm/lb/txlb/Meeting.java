package com.fundamental.algorithm.lb.txlb;

/**
 * @Author 李非凡
 * @Description: 会议类
 * @Date 2020/3/30 10:36
 * @Version 1.0
 */
public class Meeting implements Comparable<Meeting>{

    /**
     * 会议编号
     */
    private int meetingNum;

    /**
     * 会议开始时间
     */
    private int startTime;

    /**
     * 会议结束时间
     */
    private int endTime;

    public Meeting(int meetingNum, int startTime, int endTime) {
        this.meetingNum = meetingNum;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * 以结束时间排序，结束早的放前面
     * @param o
     * @return
     */
    @Override
    public int compareTo(Meeting o) {
        if (this.endTime > o.endTime) {
            return 1;
        }
        return -1;
    }

    public int getMeetingNum() {
        return meetingNum;
    }

    public void setMeetingNum(int meetingNum) {
        this.meetingNum = meetingNum;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "meetingNum=" + meetingNum +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
