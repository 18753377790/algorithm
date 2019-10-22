package com.algorithm.interview.meta_app;

import java.util.*;

/**
 * @Author 李非凡
 * @Description:
 * 展心展力笔试题（LeetCode.884）
 *
 * 给定两个句子 A 和 B 。 （句子是一串由空格分隔的单词。每个单词仅由小写字母组成。）
 * 如果一个单词在其中一个句子中只出现一次，在另一个句子中却没有出现，那么这个单词就是不常见的。
 * 返回所有不常用单词的列表。
 * 您可以按任何顺序返回列表。
 *
 * 示例 1：
 *
 * 输入：A = "this apple is sweet", B = "this apple is sour"
 * 输出：["sweet","sour"]
 *
 * 示例 2：
 * 输入：A = "apple apple", B = "banana"
 * 输出：["banana"]
 *
 * 提示：
 * 0 <= A.length <= 200
 * 0 <= B.length <= 200
 * A 和 B 都只包含空格和小写字母。
 * @Date 2019/8/16 22:42
 * @Version 1.0
 */
public class UncommonFromSentences {

    public static void main(String[] args) {
        String A = "this apple is sweet";
        String B = "this apple is sour";
        System.out.println(Arrays.toString(new UncommonFromSentences().uncommonFromSentences(A, B)));
    }

    /**
     * 最后的结果字符串数组只要出现一次的单词。
     * 使用HashMap，以每个单词为key，以其出现次数为value，
     * 将字符串A、B按照空格拆分为字符串数组，遍历其中的元素，
     * 存入HashMap中，接着遍历HashMap，将value值为1的key元素添加进结果数组中，
     * 最后返回结果数组。
     * @param A
     * @param B
     * @return
     */
    private String[] uncommonFromSentences(String A, String B){
        // 将A，B两个字符串合成一个整体，拆分转换成字符串数组
        String[] strings = (A + " " + B).split(" ");
        // 用ArrayList的动态数组装载符合条件的单词
        List<String> result = new ArrayList<String>();
        // 用HashMap存储单词出现的次数，key是单词，value是单词出现的次数
        Map<String, Integer> map = new HashMap<String, Integer>();
        // 循环遍历字符串数组，将其存入HashMap中，key是单词，value是出现的次数
        for (String string : strings) {
            // 如果字符串不为空，则将
            if (!string.isEmpty())
                // getOrDefault()当Map集合中有这个key时，就使用这个key值，如果没有就使用默认值defaultValue
                map.put(string, map.getOrDefault(string, 0) + 1);
        }
        // 循环遍历HashMap
        for (String key : map.keySet()) {
            // 如果value等于1证明单词只出现一次，将这个单词字符串存入ArrayList集合中
            if (map.get(key) == 1)
                result.add(key);
        }
        // 将ArrayList转换为String数组并返回
        return result.toArray(new String[result.size()]);
    }
}
