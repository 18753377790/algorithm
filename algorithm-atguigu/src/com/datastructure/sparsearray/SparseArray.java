package com.datastructure.sparsearray;

/**
 * @Author 李非凡
 * @Description: 稀疏数组
 * @Date 2020/2/29 21:33
 * @Version 1.0
 */
public class SparseArray {

    public static void main(String[] args) {

        /*
         * 创建一个元素的二维数组
         * 1表示黑子，2表示蓝子
         */
        int[][] chessArray = new int[11][11];

        chessArray[1][2] = 1;
        chessArray[2][3] = 2;
        chessArray[4][5] = 2;
        // 输出原始的二维数组
        System.out.println("原始的二维数组：");
        for (int[] row : chessArray) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        /*
         将二维数组转为稀疏数组
         1.先遍历二维数组，得到非零数据的个数
         */

        int sum = 0;
        for (int[] ints : chessArray) {
            for (int j = 0; j < chessArray.length; j++) {
                if (ints[j] != 0) {
                    sum++;
                }
            }
        }
        System.out.println(sum);

        // 2.创建对应的稀疏数组
        int[][] sparseArray = new int[sum + 1][3];
        // 给稀疏数组赋值
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;

        // count用于记录是第几个非0数据
        int count = 0;
        // 遍历二维数组，将非零的值存放到稀疏数组中
        for (int i = 0; i < chessArray.length; i++) {
            for (int j = 0; j < chessArray.length; j++) {
                if (chessArray[i][j] != 0) {
                    // 由于是进来就++，所以count初始值为0
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArray[i][j];
                }
            }
        }

        // 输出稀疏数组的形式
        System.out.println("得到的稀疏数组为: ");
        for (int[] ints : sparseArray) {
            System.out.printf("%d\t%d\t%d\t\n", ints[0], ints[1], ints[2]);
        }

        /*
         将稀疏数组恢复成原始的二维数组
         1.先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
         */

        int[][] chessArray2 = new int[sparseArray[0][0]][sparseArray[0][1]];

        // 2.在读取稀疏数组后几行的数据（从第二行开始），并赋给原始的二维数组即可
        for (int i = 1; i < sparseArray.length; i++) {
            chessArray2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        // 输出恢复后的二维数组
        System.out.println("恢复后的二维数组：");
        for (int[] row : chessArray2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}
