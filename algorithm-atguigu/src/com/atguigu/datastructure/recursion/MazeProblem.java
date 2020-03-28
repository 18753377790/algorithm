package com.atguigu.datastructure.recursion;

/**
 * @Author 李非凡
 * @Description: 迷宫问题
 * 思考题：如何求出最短路径？
 * 通过修改策略求出最短路径：
 * 使用数组表示不同的策略，
 * 使用for循环将所有策略走一遍
 * 统计值为2的点，将所有的值为2的点保存到集合中，比较集合的大小，求得集合最小的策略就是最短路径的策略
 * @Date 2020/3/4 19:07
 * @Version 1.0
 */
public class MazeProblem {

    public static void main(String[] args) {
        // 创建一个二维数组，模拟迷宫地图
        int[][] map = new int[8][7];
        // 使用1表示墙壁，先把上下全部置为1，即第0行和第7行的每一列置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        // 把左右全部置为1，即第0列和第6列的每一行置为1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        // 设置挡板
        map[3][1] = 1;
        map[3][2] = 1;
        // 设置产生回溯的挡板
//        map[1][2] = 1;
//        map[2][2] = 1;
        // 输出迷宫地图
        System.out.println("地图的情况：");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        // 使用递归回溯给小球找路
//        findWay(map, 1, 1);
        // 修改策略
        findWay2(map, 1, 1);

        // 输出新的地图，即小球走过并标识过的地图
        System.out.println("小球走过并标识过的地图的情况  ：");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 使用回溯算法（递归实现）来给小球找路
     * 说明：
     * 1.map表示地图
     * 2.i和j表示从地图的哪个位置开始出发map[1][1](1,1)
     * 3.如果小球能到map[6][5](6,5)位置，则说明通路找到
     * 4.约定：当map[i][j]为0表示该点没有走过，1表示墙，2表示通路可以走，3表示已经探测过走不通
     * 5.在走迷宫时，需要确定一个策略（方法）：下->右->上->左，如果该点走不通再回溯
     * @param map 表示地图
     * @param i 纵坐标
     * @param j 横坐标
     * @return true为找到通路，false为没有找到
     */
    private static boolean findWay(int[][] map, int i, int j) {
        // 通路已经找到（终点map[6][5](6,5)为2）
        if (map[6][5] == 2) {
            return true;
        }else {
            // 如果当前这个点还没有走过
            if (map[i][j] == 0) {
                // 假定该点是可以走通的
                map[i][j] = 2;
                // 按照策略：下->右->上->左 走
                if (findWay(map, i + 1, j)) {
                    // 向下走
                    return true;
                }else if (findWay(map, i, j + 1)) {
                    // 向右走
                    return true;
                }else if (findWay(map, i - 1, j)) {
                    // 向上走
                    return true;
                }else if (findWay(map, i, j - 1)) {
                    // 向左走
                    return true;
                }else {
                    // 说明该点走不通，是死路
                    map[i][j] = 3;
                    return false;
                }
            }else {
                // 如果map[i][j] != 0，可能是1，2，3，1是墙壁，2是已经走过的通路，3是走不通的路，所以没必要继续探测
                return false;
            }
        }
    }

    /**
     * 修改找路的策略，改成上->右->下->左
     * @param map 表示地图
     * @param i 纵坐标
     * @param j 横坐标
     * @return true为找到通路，false为没有找到
     */
    private static boolean findWay2(int[][] map, int i, int j) {
        // 通路已经找到（终点map[6][5](6,5)为2）
        if (map[6][5] == 2) {
            return true;
        }else {
            // 如果当前这个点还没有走过
            if (map[i][j] == 0) {
                // 假定该点是可以走通的
                map[i][j] = 2;
                // 按照策略：上->右->下->左 走
                if (findWay2(map, i - 1, j)) {
                    // 向上走
                    return true;
                }else if (findWay2(map, i, j + 1)) {
                    // 向右走
                    return true;
                }else if (findWay2(map, i + 1, j)) {
                    // 向下走
                    return true;
                }else if (findWay2(map, i, j - 1)) {
                    // 向左走
                    return true;
                }else {
                    // 说明该点走不通，是死路
                    map[i][j] = 3;
                    return false;
                }
            }else {
                // 如果map[i][j] != 0，可能是1，2，3，1是墙壁，2是已经走过的通路，3是走不通的路，所以没必要继续探测
                return false;
            }
        }
    }
}
