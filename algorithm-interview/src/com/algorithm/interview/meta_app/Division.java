package com.algorithm.interview.meta_app;

/**
 * @Author 李非凡
 * @Description:
 * 除数的异常处理
 * @Date 2019/8/16 22:27
 * @Version 1.0
 */
public class Division {

    public static void main(String[] args) {
        System.out.println(getDivision(10));
    }

    /**
     *
     * @param n
     * @return
     */
    private static int getDivision(int n){
        try {
            n += 1;
            if (n / 0 > 0){
                n += 10;
            }else {
                n -= 10;
            }
        }catch (Exception e){
            n++;
        }
        n++;
        // n++会先返回然后再加一
        return n++;
    }
}
