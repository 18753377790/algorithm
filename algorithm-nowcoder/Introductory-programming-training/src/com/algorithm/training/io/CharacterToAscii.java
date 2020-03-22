package com.algorithm.training.io;

import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description:TODE
 * @Date 2020/3/17 21:49
 * @Version 1.0
 */
public class CharacterToAscii {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.next();

        int i = str.charAt(0);

        System.out.println(i);
    }
}
