package com.algorithm.data_structure;

/**
 * @Author 李非凡
 * @Description:
 * 顺序表
 * @Date 2019/11/4 22:32
 * @Version 1.0
 */
public class SequentialList {

    /**
     * 定义顺序表的最大长度
     */
    private static final int MAX_LENGTH = 100;

    /**
     *
     */
    private Data[] data = new Data[MAX_LENGTH + 1];

    /**
     *
     */
    private int length;

    /**
     *
     */
    private static class Data{
        private String key;
        private String name;
        private int age;
    }

    /**
     *
     * @param list
     */
    public void init(SequentialList list) {
        list.length = 0;
    }

    /**
     *
     * @param list
     * @return
     */
    public int length(SequentialList list) {
        return list.length;
    }

    /**
     *
     * @param list
     * @param n
     * @param data
     * @return
     */
    public int insert(SequentialList list, int n, Data data) {
        int i;

        if (list.length > MAX_LENGTH) {
            System.out.println();
            return 0;
        }

        if (n < 1 || n > list.length - 1)
            return 0;
        return 1;
    }

    public int add() {
        return 0;
    }

    public int delete() {
        return 0;
    }

    public Data findByNumber(SequentialList list, int n) {
        return null;
    }

    public int findByContent(SequentialList list, String key) {
        return 0;
    }

    public int all(SequentialList list) {
        return 0;
    }

    public static void main(String[] args) {

    }
}
