package com.atguigu.datastructure.recursion;

/**
 * @Author 李非凡
 * @Description: 八皇后问题（回溯算法，递归实现）
 * 说明：
 * 理论上应该创建一个二维数组来表示棋盘，但实际上可以通过算法，用一个一维数组即可解决问题。
 * array[8]={0,4,7,5,2,6,1,3}对应array下标表示第几行即第几个皇后，
 * array[i]=value,value表示第i+1个皇后，放在第i+1行的第value+1列
 * @Date 2020/3/4 21:52
 * @Version 1.0
 */
public class EightQueensProblem {

    /**
     * 定义一个MAX表示共有多少个皇后
     */
    private static final int MAX = 8;

    /**
     * 定义数组array，保存皇后放置位置的结果
     * 比如：array[8]={0,4,7,5,2,6,1,3}
     */
    private int[] array = new int[MAX];

    /**
     * 统计八皇后问题有多少种解法
     */
    private static int count = 0;

    /**
     * 统计判断冲突的方法执行了多少次
     */
    private static int judgeCount = 0;

    public static void main(String[] args) {
        // 测试八皇后是否正确
        EightQueensProblem queen = new EightQueensProblem();
        queen.place(0);
        System.out.printf("一共有%d次解法\n", count);
        System.out.printf("一共有%d次判断冲突的次数\n", judgeCount);
    }

    /**
     * 写一个方法可以将皇后摆放的位置输出
     */
    private void print() {
        count++;
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    /**
     * 查看当我们放置第n个皇后时，就去检测该皇后是否和前面已经摆放的皇后冲突
     * @param n 表示第n个皇后
     * @return true为不冲突，false为冲突
     */
    private boolean judgeConflict(int n) {
        judgeCount++;
        for (int i = 0; i < n; i++) {
            /*
             1.array[i] == array[n]表示判断第n个皇后是否和前面的n-1个皇后在同一列
             2.Math.abs(n - i) == Math.abs(array[n] - array[i]表示判断第n个皇后是否和第i个皇后在同一斜线
             |n - i| == |array[n] - array[i]|
             由于棋盘是8*8的正方形，所以当两个元素在同一条斜线上时，行距差等于列距差
             |y1-y2| = |x1-x2|
             3.判断是否在同一行，没有必要，因为n每次都在递增
             */
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 编写一个方法放置第n个皇后
     * 特别注意：place是每一次递归时，进入到place中都有一套for循环，因此会有回溯
     * @param n
     */
    private void place(int n) {
        // n = 8相当于放置第9个皇后（n从0开始），证明8个皇后就已然放好
        if (n == MAX) {
            print();
            return;
        }
        // 依次放入皇后并判断是否冲突
        for (int i = 0; i < MAX; i++) {
            // 先把当前皇后n放到该行的第1列
            array[n] = i;
            // 判断当放置第n个皇后到i列时是否冲突
            if (judgeConflict(n)) {
                // 不冲突，接着放n+1个皇后，即递归开始
                place(n + 1);
            }
            // 如果冲突，就继续执行array[n] = i即将第n个皇后放置在本行的后移的一个位置
        }
    }
}
