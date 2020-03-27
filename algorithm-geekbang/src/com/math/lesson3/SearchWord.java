package com.math.lesson3;

import java.util.Arrays;

/**
 * @Author 李非凡
 * @Description: 二分法查找单词
 * 第一步，将整个字典先进行排序（假设从小到大）。
 * 二分法中很关键的前提条件是，所查找的区间是有序的。
 * 这样才能在每次折半的时候，确定被查找的对象属于左半边还是右半边。
 *
 * 第二步，使用二分法逐步定位到被查找的单词。
 * 每次迭代的时候，都找到被搜索区间的中间点，看看这个点上的单词，是否和待查单词一致。
 * 如果一致就返回；如果不一致，要看被查单词比中间点上的单词是小还是大。
 * 如果小，那说明被查的单词如果存在字典中，那一定在左半边；否则就在右半边。
 *
 * 第三步，根据第二步的判断，选择左半边或者后半边，继续迭代式地查找，直到范围缩小到单个的词。
 * 如果到最终仍然无法找到，则返回不存在。
 * @Date 2020/3/23 14:27
 * @Version 1.0
 */
public class SearchWord {

    public static void main(String[] args) {
        String[] dictionary = {"i", "am", "one", "of", "the", "authors", "in", "geekbang"};

        Arrays.sort(dictionary);

        String wordToFind = "i";

        boolean found = search(dictionary, wordToFind);
        if (found) {
            System.out.println(String.format("找到了单词%s", wordToFind));
        } else {
            System.out.println(String.format("未能找到单词%s", wordToFind));
        }
    }

    /**
     * 查找某个单词是否在字典里出现
     * @param dictionary 排序后的字典
     * @param wordToFind 待查的单词
     * @return 是否发现待查的单词
     */
    private static boolean search(String[] dictionary, String wordToFind) {
        // 如果字典为空或字典数组长度为0
        if (dictionary == null || dictionary.length == 0) {
            return false;
        }

        int left = 0;
        int right = dictionary.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (dictionary[middle].equals(wordToFind)) {
                return true;
            }else {
                if (dictionary[middle].compareTo(wordToFind) > 0) {
                    right = middle - 1;
                }else {
                    left = middle + 1;
                }
            }
        }

        return false;
    }
}
