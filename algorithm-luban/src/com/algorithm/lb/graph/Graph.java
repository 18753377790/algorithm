package com.algorithm.lb.graph;

/**
 * @Author 李非凡
 * @Description:
 * 图论
 * 图的定义：
 * 是一种比线性表和树更为复杂的数据结构，在图形结构中结点之间的关系可以是任意的，
 * 任意两个数据元素都可能存在相关性，因此图论在计算中应用相当广泛,知识图谱，推荐算法。
 *
 * 图的基本元素
 * 结点：类似树的结点，图的每个元素都是一个结点
 * 顶点：类似结点
 * 弧（边）：两个顶点的连线
 * 弧尾：有向的边箭头位置
 * 弧头：有向的边末尾位置
 * 有向图：边有箭头的图
 * 无向图：边没有箭头的图，无向图没有弧尾弧头的概念
 * 权：边的权重
 * 子图：类似树的子树，递归
 * 出度：一个顶点有多少个箭头指向
 * 入度：一个顶点指向出去多少个箭头
 * 回路：从当前顶点出发，最后又能回到原顶点，一般针对有向图，处理不好容易出现死循环
 *
 * 图的表示方法：
 * 邻接矩阵（二维数组）：(V,E)V是顶点，E是权重
 * 邻接表（链表）:
 * 十字链表：邻接表的升级版，为了节约空间
 * 多重邻接表：
 *
 * 图的应用：
 * 知识图谱：图形数据库 Neo4j
 * 抖音和今日头条的推荐算法
 * QQ可能认识的人
 * 微博，知乎，贴吧的关注的人
 * 各种社交网站的好友关系
 * GC：树形结构，也是有向无环图
 * @Date 2019/10/27 15:08
 * @Version 1.0
 */
public class Graph {

    /**
     * 表示行
     */
    int n;

    /**
     * 表示列
     */
    int m;

    /**
     * 表示目标位置的x坐标
     */
    int dx;

    /**
     * 表示目标位置的y坐标
     */
    int dy;

    /**
     * 表示图的矩阵
     */
    int[][] data;

    /**
     * 用来标记走过的路 防止死循环
     */
    boolean[][] mark;

    public Graph(int n, int m, int dx, int dy, int[][] data, boolean[][] mark){
        this.n = n;
        this.m = m;
        this.dx = dx;
        this.dy = dy;
        this.data = data;
        this.mark = mark;
    }

    public Graph(){

    }
}
