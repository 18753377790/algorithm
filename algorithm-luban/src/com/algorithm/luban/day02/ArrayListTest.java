package com.algorithm.luban.day02;

/**
 * @Author 李非凡
 * @Description:
 * 自定义ArrayList测试类
 * @Date 2019/4/9 0:09
 * @Version 1.0
 */
public class ArrayListTest {

    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        list.add(4);
        list.add(6);
        list.add(2);
        list.add(5);
        list.add(8);
        list.add(6);
//        list.set(2,9);
//        list.clear();
//        list.removeAt(1);
//        list.removeAt(2);

        //对集合中元素进行循环遍历删除时，要从后往前循环
        for (int i = 0; i < list.getSize(); i++) {
            if ((int)list.get(i) % 2 == 0){
                list.removeAt(i);
            }
        }

        //遍历输出集合
        for (int i = 0; i < list.getSize(); i++) {
            System.out.println(list.get(i));
        }
    }
}
