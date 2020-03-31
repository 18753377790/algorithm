package com.fundamental.algorithm.classical_algorithm;

/**
 * @Author 李非凡
 * @Description:
 * 百钱买百鸡
 * 公鸡5文钱一只，母鸡3文钱1只，小鸡1文钱3只，如果用100文钱买100只鸡，那么公鸡，母鸡和小鸡各应该买多少只呢？
 * @Date 2019/11/6 17:34
 * @Version 1.0
 */
public class BuyChickens {

    /**
     * 百钱买百鸡求解
     * 设公鸡为x，母鸡为y，小鸡为z，则
     * x+y+z=100
     * 5x+3y+z/3=100
     * @param money 钱数（百钱）
     * @param number 鸡数（白鸡）
     */
    private static void buyChicken(int money, int number) {
        for (int x = 0; x <= number ; x++) {
            for (int y = 0; y <= number ; y++) {
                int z = number - x - y;
                if (z > 0 && z % 3 == 0 && x * 5 + y* 3 + z / 3 == money) {
                    System.out.printf("公鸡：%d只，母鸡：%d只，小鸡：%d只\n", x, y, z);
                }else {
                    System.out.print("");
                }
            }
        }
    }

    public static void main(String[] args) {
        // 百钱
        int money = 100;
        // 百鸡
        int number = 100;

        System.out.println("百钱买百鸡问题的求解结果为：");

        buyChicken(money, number);
    }
}
