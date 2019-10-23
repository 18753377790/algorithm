package com.algorithm.luban.day02;

/**
 * @Author 李非凡
 * @Description:
 * 自定义ArrayList
 * 数组与集合的区别：
 * 数组是固定大小，集合是动态大小
 * ArrayList底层是用数组实现的
 *
 * 添加数据：ArrayList需要不停的扩容数组且需要进行数组搬家，效率较低
 * 删除数据：ArrayList需要将数据前移，越前面的数据删除效率越低，越后面的数据删除效率越高，所以删除数据要从后往前删
 * 遍历数据：ArrayList遍历数据效率非常高
 * 获取（查找）或设置数据：ArrayList获取（查找）或设置数据效率非常高
 *
 * 开发中，ArrayList用的更多，ArrayList会被当做存储数据的仓库，只添加一次
 * @Date 2019/4/7 20:52
 * @Version 1.0
 */
public class MyArrayList {

    /**
     * ArrayList初始数组默认初始容量是10，这里设置为4
     */
    private Object[] objs = new Object[4];

    /**
     * 供外部外部看到的大小，这里使用了障眼法
     */
    private int size = 0;

    /**
     * 返回集合大小
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 向集合中添加元素
     * @param value
     */
    public void add(Object value){
        //添加前需要判断数组是否还有位置可以存放数据
        if (size >= objs.length){
            //放不下，搬家（创建一个更大的数组，ArrayList默认扩容是1.5倍）
            Object[] temp = new Object[size * 2];
            for (int i = 0; i < objs.length; i++) {
                temp[i] = objs[i];
            }
            objs = temp;
        }
        objs[size] = value;
        size++;
    }

    /**
     * 根据索引返回集合中的元素
     * @param index
     * @return
     */
    public Object get(int index){
        //这里不能判断数组的长度，否则隐藏数组的算法就会暴露，索引从1开始，长度从0开始，索引不能等于长度
        if (index >= size){
            System.out.println("超出范围");
            return null;
        }
        return objs[index];
    }

    /**
     * 根据索引设置集合中的元素
     * @param index
     * @param value
     */
    public void set(int index, Object value){
        //这里不能判断数组的长度，否则隐藏数组的算法就会暴露，索引从1开始，长度从0开始，索引不能等于长度
        if (index >= size){
            System.out.println("超出范围");
        }
        objs[index] = value;
    }

    /**
     * 清除集合中所有的元素
     */
    public void clear(){
        //将大小归零是最快的清除方法，用户再往里面添加数据会覆盖原有数据，跟硬盘删除和格式化原理一样
        size = 0;
        for (int i = 0; i < objs.length; i++) {
            objs[i] = null;
        }
    }

    /**
     * 根据索引删除集合中的元素
     * @param index
     */
    public void removeAt(int index){
        // 这里不能判断数组的长度，否则隐藏数组的算法就会暴露，索引从1开始，长度从0开始，索引不能等于长度
        if (index >= size){
            System.out.println("超出范围");
        }
        // 将后面的数据向前移动，最后一个数据没必要删除，因为size变了访问不到，如果添加数据，会将最后原有的覆盖
        for (int i = index+1; i < size; i++) {
            objs[i - 1] = objs[i];
        }
        size--;
    }
}

