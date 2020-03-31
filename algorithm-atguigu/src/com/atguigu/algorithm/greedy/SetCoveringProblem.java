package com.atguigu.algorithm.greedy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author 李非凡
 * @Description: 集合覆盖问题
 * @Date 2020/3/30 21:33
 * @Version 1.0
 */
public class SetCoveringProblem {

    public static void main(String[] args) {
        Map<String, Set<String>> broadcasts = new HashMap<>(16);

        Set<String> set1 = new HashSet<>();
        set1.add("北京");
        set1.add("上海");
        set1.add("天津");

        Set<String> set2 = new HashSet<>();
        set2.add("广州");
        set2.add("北京");
        set2.add("深圳");

        Set<String> set3 = new HashSet<>();
        set3.add("成都");
        set3.add("上海");
        set3.add("杭州");

        Set<String> set4 = new HashSet<>();
        set4.add("上海");
        set4.add("天津");

        Set<String> set5 = new HashSet<>();
        set5.add("杭州");
        set5.add("大连");

        broadcasts.put("K1", set1);
        broadcasts.put("K2", set2);
        broadcasts.put("K3", set3);
        broadcasts.put("K4", set4);
        broadcasts.put("K5", set5);

        Set<String> allAreas = new HashSet<>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("深圳");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大连");

        Set<String> selects = setCovering(broadcasts, allAreas);
    }

    /**
     *
     * @param map
     * @param set
     * @return
     */
    private static Set<String> setCovering(Map<String, Set<String>> map, Set<String> set) {

        // 定义
        Set<String> tempSet = new HashSet<>();

        //
        String maxKey;

        return null;
    }
}
