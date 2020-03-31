package com.fundamental.algorithm.classical_algorithm;

/**
 * @Author 李非凡
 * @Description:
 * 五家共井
 * 有五家共用一口井，甲，乙，丙，丁，戊五家各有一条绳子汲水：
 * 甲绳 X 2 + 乙绳 = 井深
 * 乙绳 X 3 + 丙绳 = 井深
 * 丙绳 X 4 + 丁绳 = 井深
 * 丁绳 X 5 + 戊绳 = 井深
 * 戊绳 X 6 + 甲绳 = 井深
 * 求甲乙丙丁戊各家绳子的长度和井深
 * @Date 2019/11/6 18:16
 * @Version 1.0
 */
public class FiveWells {

    /**
     * 五家共井问题求解
     * le1*2+len2=len
     * le2*3+len3=len
     * le3*4+len4=len
     * le4*5+len5=len
     * le5*6+len1=len
     * @param len 井深
     * @param len1 甲家绳长
     * @param len2 乙家绳长
     * @param len3 丙家绳长
     * @param len4 丁家绳长
     * @param len5 戊家绳长
     */
    private static void fiveWells(int[] len, int[] len1, int[] len2, int[] len3, int[] len4, int[] len5) {

    }

    public static void main(String[] args) {
        int[] len = {0};
        int[] len1 = {0};
        int[] len2 = {0};
        int[] len3 = {0};
        int[] len4 = {0};
        int[] len5 = {0};

        fiveWells(len, len1, len2, len3, len4, len5);

        System.out.println("五家共井问题求解结果如下：");
        System.out.println("甲家井绳长度为：" + len1[0]);
        System.out.println("乙家井绳长度为：" + len2[0]);
        System.out.println("丙家井绳长度为：" + len3[0]);
        System.out.println("丁家井绳长度为：" + len4[0]);
        System.out.println("戊家井绳长度为：" + len5[0]);
        System.out.println("井深：" + len[0]);
    }
}
