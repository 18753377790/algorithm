package com.algorithm.lb.tree;

import java.util.*;

/**
 * @Author 李非凡
 * @Description:
 * 哈夫曼树（最优二叉树）
 * 叶子节点带权路径长度和最小的树的结构就是最优二叉树（哈夫曼树）
 *
 * 核心思想：
 * 贪心算法：利用局部最优解推出全局最优解
 * 1.排序权重（从小到大）
 * 2.每次取数值最小的两个节点，将之组成为一颗子树（小的放在左边，大的放在右边，保证顺序性），并移除原来的两个点。
 *
 * 哈夫曼树的用途
 * 1.加密解密：
 * 数字通信：路由器，基站
 * 电文加密解密
 * 前后端接口加密（加密参数）
 * token验证
 * 2.压缩：AB->10000将字符变为二进制字节
 * 3.编码
 *
 * 如何加密？
 * 电报加密规则
 * 1.越短越好：数字通信。
 * 2.破解难：
 * 3.解码也的容易：
 * 4.换加密树也容易：加密树->可逆
 *
 * 哈夫曼树加密
 * 1.0和1代表左指针和右指针
 * 2.按根节点到对应结点的指针编号来编码
 * 3.前缀编码：每个结点编码都按前缀，前缀不重复
 * @Date 2019/9/21 20:54
 * @Version 1.0
 */
public class HuffmanTree {

    /**
     * 根结点
     */
    private HTNode root;

    /**
     * 叶子结点
     */
    private List<HTNode> leafNodes;

    /**
     * 每个叶子节点的权重，key是结点存的数据，value是对应的权重值
     */
    private Map<Character, Integer> weights;

    public HuffmanTree(Map<Character, Integer> weights) {
        this.leafNodes = new ArrayList<>();
        this.weights = weights;
    }

    /**
     * 编码，其实就是树的遍历
     * @return
     */
    private Map<Character, String> encode() {
        Map<Character, String> map = new HashMap<>();
        // 这里是从叶子节点开始的，也可以从root节点开始找
        for (HTNode node : leafNodes) {
            Character c = node.getData().charAt(0);
            // 记录编码
            String code = "";
            // 从这个点开始找
            HTNode currentNode = node;
            // 从叶子节点往前面找 一直找到根节点，即parentNode没有了
            do{
                // 判断当前这个点是在左边还是右边，因为左边是0 右边是1
                if (currentNode.getParentNode() != null && currentNode.getParentNode().getLeftNode() == currentNode){
                    code = "0" + code;
                }else {
                    code = "1" + code;
                }
                currentNode = currentNode.getParentNode();
            }while (currentNode.getParentNode() != null);
            map.put(c, code);
        }
        return map;
    }

    /**
     * 解码
     */
    private void decode() {

    }

    /**
     * 创建哈夫曼树
     */
    private void createHuffmanTree(){
        // 用来排序权重的优先队列
        PriorityQueue<HTNode> priorityQueue = new PriorityQueue<>();
        // 遍历Map将key存入一个数组里
        Character[] keys = weights.keySet().toArray(new Character[0]);
        // 把所有的权重拿出来放到优先队列里面去
        for (Character c : keys) {
            HTNode node = new HTNode();
            node.setData(c.toString());
            node.setWeight(weights.get(c));
            // 将node加入优先队列
            priorityQueue.add(node);
            // 将node视为叶子结点
            leafNodes.add(node);
        }
        // 取优先队列的数据进行合并
        int length = priorityQueue.size();
        // 长度为n就要合并n-1次
        for (int i = 0; i < length - 1; i++) {
            //以下两个就是优先队列里面最小的两个数
            HTNode node1 = priorityQueue.poll();
            // 出队列操作poll()
            HTNode node2 = priorityQueue.poll();
            // 以下就是合并一个node的过程
            HTNode newNode = new HTNode();
            newNode.setData(node1.getData() + node2.getData());
            newNode.setWeight(node1.getWeight() + node2.getWeight());
            newNode.setLeftNode(node1);
            newNode.setRightNode(node2);
            node1.setParentNode(newNode);
            node2.setParentNode(newNode);
            priorityQueue.add(newNode);
        }
        // 根结点就是优先队列最后一个数据
        root = priorityQueue.poll();
        System.out.println("创建完成");
    }

    public static void main(String[] args) {
        Map<Character, Integer> weightMap = new HashMap<>();
        //这个就是构建加密树 只要随便动一下 整个就不一样了,往往以某本书的字出现了多少次作为权重map
        weightMap.put('A', 7);
        weightMap.put('B', 0);
        weightMap.put('C', 2);
        weightMap.put('D', 4);

        HuffmanTree huffmanTree = new HuffmanTree(weightMap);
        huffmanTree.createHuffmanTree();
        Map<Character, String> map = huffmanTree.encode();
        System.out.println("A:" + map.get('A'));
        System.out.println("B:" + map.get('B'));
        System.out.println("C:" + map.get('C'));
        System.out.println("D:" + map.get('D'));
        System.out.println("AB的密文:" + (map.get('A') + map.get('B')));
    }
}

/**
 * 哈夫曼树结点类
 */
class HTNode implements Comparable<HTNode>{

    /**
     * 结点存的数据（字符）
     */
    private String data = "";

    /**
     * 结点的权重值
     */
    private int weight;

    /**
     * 左结点
     */
    private HTNode leftNode;

    /**
     * 右结点
     */
    private HTNode rightNode;

    /**
     * 父结点
     */
    private HTNode parentNode;

    /**
     * 实现优先队列
     * @param o
     * @return
     */
    @Override
    public int compareTo(HTNode o) {
        return this.getWeight() - o.getWeight();
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public HTNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(HTNode leftNode) {
        this.leftNode = leftNode;
    }

    public HTNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(HTNode rightNode) {
        this.rightNode = rightNode;
    }

    public HTNode getParentNode() {
        return parentNode;
    }

    public void setParentNode(HTNode parentNode) {
        this.parentNode = parentNode;
    }
}
