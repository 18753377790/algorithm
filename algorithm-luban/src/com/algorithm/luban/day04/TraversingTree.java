package com.algorithm.luban.day04;

import java.io.File;

/**
 * @Author 李非凡
 * @Description:
 * 文件夹的遍历（树的遍历的应用场景）
 * 递归的应用：树的遍历（用循环很难实现，因为不知道树有多少层）
 * 文件夹系统是典型的树形结构
 * 如果递归算法没有终止条件，就会成为死递归，死递归会造成内存不足
 * @Date 2019/4/14 1:49
 * @Version 1.0
 */
public class TraversingTree {

    public static void main(String[] args) {
        File file = new File("D:\\Game");
        // 递归遍历文件夹及其子文件夹和文件不管多少层都能找到
        doFactorial(file);

        // 循环遍历文件夹及其子文件夹和文件需要写很多层循环，且不知道一共有多少层
//        File[] files = file.listFiles();
//        for (int i = 0; i < files.length; i++) {
//            if (files[i].isFile()){
//                System.out.println(files[i].getName());
//            }else {
//
//            }
//        }
    }

    /**
     * 递归遍历文件夹及其子文件夹和文件
     * @param file
     */
    private static void doFactorial(File file){
        // 获取当前文件夹下所有的子文件夹及文件
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()){
                System.out.println("文件：" + files[i].getName());
            }else {
                // 递归调用自己，获取下一次的文件
                doFactorial(files[i]);
            }
        }
    }
}
