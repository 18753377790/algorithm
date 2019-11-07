package com.algorithm.offer.string;

/**
 * @Author 李非凡
 * @Description:
 * 替换空格
 *
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * @Date 2019/8/13 16:51
 * @Version 1.0
 */
public class ReplaceSpace {

    /**
     * 将StringBuffer转换为String然后调用String类的replace()方法，
     * 前面的是要替换的字符串，后面的是替换的字符串
     * @param str 要改变的字符串
     * @return 改完的字符串
     */
    private String replaceSpace(StringBuffer str){
//        return str.toString().replace(" ","%20");
        return str.toString().replaceAll("\\s","%20");
    }

    public static void main(String[] args) {
        String string = "We Are Happy";
        StringBuffer sb = new StringBuffer(string);
        ReplaceSpace rs = new ReplaceSpace();
        System.out.println(rs.replaceSpace(sb));
    }
}
