package com.algorithm.string;

/**
 * @Author 李非凡
 * @Description: 暴力匹配算法
 *
 * @Date 2020/3/13 0:20
 * @Version 1.0
 */
public class BruteForce {

    public static void main(String[] args) {
        // 主串
        String str = "硅硅谷 尚硅谷你尚硅 尚硅谷你尚硅谷你尚硅你好";
        // 模式串
        String ptr = "尚硅谷你尚硅你";
        int index = bruteForce(str, ptr);
        System.out.println("index=" + index);
    }

    /**
     * 暴力匹配算法
     * @param str 主串（文本串text）
     * @param ptr 模式串（pattern）
     * @return 如果匹配成功，返回主串中首次匹配到模式串的对应下标，如果失败，返回-1
     */
    private static int bruteForce(String str, String ptr) {
        char[] s = str.toCharArray();
        char[] p = ptr.toCharArray();

        int sLen = s.length;
        int pLen = p.length;

        // i表示索引指向s
        int i = 0;
        // j表示索引指向p
        int j = 0;
        // 保证匹配时数组不越界
        while (i < sLen && j < pLen) {
            // 匹配成功
            if (s[i] == p[j]) {
                i++;
                j++;
            }else {
                // 没有匹配成功，如果失败（s[i] != p[j]），令i = i - (j - 1), j = 0
                i = i - (j - 1);
                j = 0;
            }
        }

        // 判断是否匹配成功
        if (j == pLen) {
            return i - j;
        }else {
            return -1;
        }
    }
}
