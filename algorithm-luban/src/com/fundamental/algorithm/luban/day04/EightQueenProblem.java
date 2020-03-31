package com.fundamental.algorithm.luban.day04;

/**
 * @Author 李非凡
 * @Description:
 * 八皇后问题
 *
 * 国际象棋棋盘上摆八个皇后，让她们互相无法吃掉对方，一共有92种摆法
 *
 * 这个算法的难点在于，如果每一行摆放一个皇后，一行一行往下摆放，
 * 如果有一行无法摆放，就要回退到上一行，将上一行摆放的皇后清除，
 * 让上一行依次往后摆放
 *
 * 如果一种摆法固定以后，最后一行
 *
 * 研究清楚递归算法：什么时候会从下一层回到上一层
 * 经典递归电影：盗梦空间
 * @Date 2019/4/14 1:47
 * @Version 1.0
 */
public class EightQueenProblem {

    /**
     * 国际象棋的8*8的棋盘，0表示没有内容的空格子，1表示有皇后的格子
     * 起始行是第0行，起始列是第0列
     */
    private static int[][] chessboard = new int[8][8];

    /**
     * 计数器
     */
    private static int count = 1;

    public static void main(String[] args) {
        play(0);
    }

    /**
     * 显示棋盘
     */
    private static void showChessboard(){
        System.out.println("第" + count + "种摆法");
        // 计数
        count++;
        // 纵向，换行的效果
        for (int i = 0; i < 8; i++) {
            // 横向，打印每一行的效果
            for (int j = 0; j < 8; j++) {
                System.out.print(chessboard[i][j] + "  ");
            }
            System.out.println();
        }
    }

    /**
     * 验证此位置是否可以放置皇后
     * 八个方向，其中左右方向不能放，
     * 左下，右下，下方没有放皇后
     * @param row 行
     * @param col 列
     * @return 放没放皇后
     */
    private static boolean check(int row, int col){
        // 循环验证正上方（行数变小，列数不变，当前位置从下往上循环）
        for (int i = row - 1; i >= 0; i--) {
            if (chessboard[i][col] == 1)
                return false;
        }
        // 循环验证左上方（行数变小，列数变小，从左下到左上）
        for (int i = row - 1 , j = col - 1; i >=0 && j>= 0; i--, j--) {
            if (chessboard[i][j] == 1)
                return false;
        }
        // 循环验证右上方（行数变小，列数变大，从右下到右上）
        for (int i = row - 1,j = col + 1; i >= 0 && j <= 7; i--, j++) {
            if (chessboard[i][j] == 1)
                return false;
        }
        return true;
    }

    /**
     * 循环遍历当前行，在当前行位置放置皇后
     * @param row 行
     */
    private static void play(int row){
        // 遍历当前行的所有单元格，一行8个格子
        for (int i = 0; i < 8; i++) {
            // 当前行的指定单元格是否能放皇后
            if (check(row,i)){
                // 设置皇后
                chessboard[row][i] = 1;
                // 最后一行设置好后，表示八皇后完成
                if (row == 7){
                    // 显示棋盘效果
                    showChessboard();
                    // 当最后一个皇后摆好，去掉皇后让皇后继续查找其他方案
                }else {
                    // 进行到下一行放皇后，递归调用play()方法
                    play(row + 1);
                    // 去掉皇后（上一行代码表示下面行没有摆放皇后的位置）
                }
                chessboard[row][i] = 0;
            }
        }
    }
}
