package com.atguigu.algorithm.divide;

/**
 * @Author 李非凡
 * @Description: 汉诺塔问题（分治算法，递归实现）
 * 汉诺塔思路分析
 * 1.如果只有一个圆盘，A->C
 * 2.如果是n >= 2的情况，总是可以看做是两个圆盘，最下面的圆盘，上面的所有圆盘
 *   2.1把最上面的所有圆盘A->B
 *   2.2把最下面的圆盘A->C
 *   2.3把B塔的所有圆盘从B->C
 * 圆盘个数 移动次数
 *  1       1
 *  2       3
 *  3       7
 *  4       15
 *  即count = (2^n) - 1
 * @Date 2020/3/12 10:22
 * @Version 1.0
 */
public class HanoiTowerProblem {

    public static void main(String[] args) {
        hanoiTower(5, 'A', 'B', 'C');
    }

    /**
     * 汉诺塔的移动方法
     * 分治算法
     * @param num 圆盘的数目
     * @param a A柱
     * @param b B柱
     * @param c C柱
     */
    private static void hanoiTower(int num, char a, char b, char c) {
        // 如果只有一个圆盘
        if (num == 1) {
            System.out.println("第1个盘从 " + a + "->" + c);
        }else {
            // 把最上面的圆盘A->B，移动过程会使用到C塔
            hanoiTower(num - 1, a, c, b);
            // 把最下面的圆盘A->C
            System.out.println("第" + num + "个盘从 " + a + "->" + c);
            // 把B塔的所有圆盘从B->C，移动过程会使用到A塔
            hanoiTower(num - 1, b, a, c);
        }
    }
}
