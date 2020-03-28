package com.interview.algorithm.pythonbro;

/**
 * @Author 李非凡
 * @Description:
 * 湃森兄弟面试题
 *
 * 代码的执行顺序
 * 下面程序的运行结果是？
 * ball
 * pong
 * ping
 * pong
 * @Date 2019/8/12 16:52
 * @Version 1.0
 */
public class ExecutionSequence {

    /**
     * pong方法
     */
    private static void pong(){
        System.out.println("pong");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(){
            @Override
            public void run() {
                pong();
            }
        };
        // 当调用run()方法执行线程的时候，线程不运行，执行的仅仅是run()方法，所以按顺序执行
        thread.run();
        // 当调用start()方法执行线程的时候，线程运行，但是优先级比main线程低，所以最后执行
        thread.start();
        System.out.println("ping");
    }

    /*
      静态代码块，类加载的时候执行，最先执行
     */
    static {
        System.out.println("ball");
    }
}
