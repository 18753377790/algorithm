package com.practice.algorithm.dijkstra;

/**
 * @Author 靳君
 * @Description: 顶点
 * @Date 2020/3/20 22:38
 * @Version 1.0
 */
public class Point {

    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Point point = (Point) o;

        if (x != point.x) {
            return false;
        }
        return y == point.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * 计算两个顶点之间的距离
     * @param other 下一个顶点
     * @return 顶点距离
     */
    public double distinct(Point other) {
        return Math.sqrt(Math.abs((other.getX() - x) * (other.getX() - x)) + Math.abs((other.getY() - y) * (other.getY() - y)));
    }
}
