package com.algorithm.practice.basic;

/**
 * @Author 李非凡
 * @Description: 基于接缝裁剪的图像压缩
 * @Date 2020/2/28 22:27
 * @Version 1.0
 */
public class ImageCompression {

    /**
     * row
     */
    private static final int ROW = 8;

    /**
     * column
     */
    private static final int COLUMN = 10;

    private int[][] arrayA = {
            {1,2,3,4,5,6,7,8,9,10},
            {2,3,4,5,6,7,8,9,10,11},
            {8,4,6,2,7,2,7,8,12,15},
            {10,23,5,7,9,10,13,9,18,20},
            {4,8,1,9,23,6,8,11,17,30},
            {9,5,1,7,5,7,5,19,6,8},
            {10,45,7,2,8,2,6,8,2,13},
            {10,5,30,29,5,8,6,2,5,20},
    };

    private int[][] arrayB = new int[ROW][COLUMN];

    private int[][] arrayC = new int[ROW][COLUMN];

    /**
     *
     * @param a
     * @param b
     * @param c
     * @return
     */
    private int minOf3(int a, int b, int c) {
        if(a <= b && a <= c) {
            return a;
        } else {
            return Math.min(b, c);
        }
    }

    /**
     *
     * @param i
     * @param j
     * @return
     */
    private int getMin(int i, int j) {
        int a1, a2, a3;
        if(j - 1 >= 0) {
            a1 = arrayB[i - 1][j - 1];
        } else {
            a1 = Integer.MAX_VALUE;
        }
        a2 = arrayB[i - 1][j];
        if(j + 1 < COLUMN) {
            a3 = arrayB[i - 1][j + 1];
        } else {
            a3 = Integer.MAX_VALUE;
        }
        int min = minOf3(a1,a2,a3);
        if(min == a1) {
            arrayC[i][j] = -1;
        } else if(min == a2) {
            arrayC[i][j] = 0;
        } else {
            arrayC[i][j] = 1;
        }
        return min;
    }

    private void dp() {
        for(int i = 0;i < ROW; i++) {
            for(int j = 0; j < COLUMN; j++) {
                arrayB[i][j] = arrayA[i][j];
            }
        }

        for(int i = 1; i < ROW; i++) {
            for(int j = 0;j < COLUMN; j++) {
                arrayB[i][j] += getMin(i,j);
            }
        }
    }

    private void printB() {
        for(int i = 0; i < ROW; i++) {
            for(int j = 0; j < COLUMN; j++) {
                System.out.printf("%2d ", arrayB[i][j]);
            }
            System.out.println();
        }
    }

    private void printA() {
        for(int i = 0; i < ROW; i++) {
            for(int j = 0; j < COLUMN; j++) {
                System.out.printf("%2d ", arrayA[i][j]);
            }
            System.out.println();
        }
    }

    private void printTrace(int startCol) {

        System.out.printf("col%d:%d ", startCol + 1, arrayA[ROW - 1][startCol]);
        int j = startCol + arrayC[ROW - 1][startCol];
        for(int i = 8 - 2; i>=0; i--) {
            System.out.printf("col%d:%d ", j + 1, arrayA[i][j]);
            j += arrayC[ROW - 1][j];
        }
        System.out.println();
    }

    private int getResult() {
        int min = Integer.MAX_VALUE, mini = 0;
        for(int i = 0; i < COLUMN; i++) {
            if(arrayB[ROW - 1][i] < min) {
                min = arrayB[ROW - 1][i];
                mini = i;
            }

        }
        System.out.println("min cost: " + min);
        return mini;
    }

    public static void main(String[] args) {
        ImageCompression compression = new ImageCompression();
        compression.dp();

        compression.printA();
        System.out.println("-------");
        compression.printB();
        System.out.println("-------");
        int scol = compression.getResult();
//        compression.printTrace(scol);
//        System.out.println(scol);
    }
}
