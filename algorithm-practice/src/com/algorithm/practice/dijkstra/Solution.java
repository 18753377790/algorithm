package com.algorithm.practice.dijkstra;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author 靳君
 * @Description:
 *
 * @Date 2020/3/20 22:38
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) throws Exception {
//        File srcFile = new File("./input.txt");
        File srcFile = new File("C:/Users/李非凡/Desktop/usa.txt");
        if (!srcFile.exists()) {
            System.out.println("can not find srcFile named usa.txt. please check it out.");
            return;
        }
        InputStreamReader reader = new InputStreamReader(new FileInputStream(srcFile));

        System.out.println("loading srcFile...please wait for a while.");
        BufferedReader br = new BufferedReader(reader);

        String top = br.readLine();
        if (null == top) {
            System.out.println("Read srcFile named usa.txt format exception.");
            return;
        }
        int[] mapCondition = Arrays.stream(top.split(" ")).mapToInt(Integer::parseInt).toArray();
        int mVexsSize = mapCondition[0];
        int mEdgNum = mapCondition[1];

        Point[] pointColl = new Point[mVexsSize];
        String[] mVexs = new String[mVexsSize];
        for (int i = 0; i < mVexsSize; i++) {
            String str = readLineFormat(br);
            if (str == null) {
                break;
            }
            str = str.trim();
            int[] code = Arrays.stream(str.split("\\s+")).filter(verge -> !"".equals(verge)).mapToInt(Integer::parseInt).toArray();
            pointColl[i] = new Point(code[1], code[2]);
            mVexs[i] = String.valueOf(code[0]);
        }

        System.out.println("pointColl has bean loaded.");
        // there should be having a empty line.
        br.readLine();

        HashMap<Point, Double> mMatrix = new HashMap<>(mVexsSize);

        System.out.println("init");
        for (int i = 0; i < mEdgNum; i++) {
            String str = readLineFormat(br);
            if (str == null) {
                break;
            }
            str = str.trim();
            int[] code = Arrays.stream(str.split("\\s+")).filter(verge -> !"".equals(verge)).mapToInt(Integer::parseInt).toArray();
            double distinct = pointColl[code[0]].distinct(pointColl[code[1]]);
            mMatrix.put(new Point(code[0],code[1]), distinct);
            mMatrix.put(new Point(code[1],code[0]), distinct);
        }

        br.close();
        reader.close();

        System.out.println("Loading srcFIle finished. Our Program has bean ready.Please input as leading.");
        System.out.println("Please input two point split with blank character:");
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            String input = in.nextLine();
            if (null == input || "".equals(input.trim())) {
                System.out.println("error input format.please input as example: 1 2");
                continue;
            }
            if ("exit".equalsIgnoreCase(input)) {
                break;
            }
            String[] code = input.split("\\s+");

            int vs = -1, aim = -1;

            for (int i = 0; i < mVexs.length; i++) {
                if (mVexs[i].equals(code[0])) {
                    vs = i;
                }
                if (mVexs[i].equals(code[1])) {
                    aim = i;
                }
            }
            if (vs < 0 || aim < 0) {
                System.out.println("error input format.please input as example: 1 2");
                continue;
            }
            Executor.dijkstra(vs, aim, mVexs, mMatrix);
            System.out.println("Please input two point split with blank character:");
        }
        System.out.println("Program exit.");
    }

    /**
     *
     * @param br
     * @return
     * @throws IOException
     */
    private static String readLineFormat(BufferedReader br) throws IOException {
        String str = br.readLine();
        if (str == null) {
            System.out.println("Read rcFile named usa.txt format exception.");
            return null;
        }
        return str;
    }
}
