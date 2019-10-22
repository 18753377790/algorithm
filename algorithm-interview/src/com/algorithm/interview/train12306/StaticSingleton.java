package com.algorithm.interview.train12306;

/**
 * @Author 李非凡
 * @Description:
 * 中铁程面试题
 *
 * 静态内部类单例
 * @Date 2019/8/14 10:20
 * @Version 1.0
 */
public class StaticSingleton {

    /**
     *
     */
    private StaticSingleton(){

    }

    /**
     *
     */
    private static class Static{
        private static StaticSingleton singleton = new StaticSingleton();
    }

    /**
     *
     * @return
     */
    public static StaticSingleton getInstance(){
        return Static.singleton;
    }
}
