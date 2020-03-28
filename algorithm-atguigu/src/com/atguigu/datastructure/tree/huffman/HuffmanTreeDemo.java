package com.atguigu.datastructure.tree.huffman;

/**
 * @Author 李非凡
 * @Description:TODE
 * @Date 2020/3/11 13:45
 * @Version 1.0
 */
public class HuffmanTreeDemo {

    public static void main(String[] args) {
        int[] array = {13, 7, 8, 3, 29, 6, 1};
        HuffmanTree huffmanTree = new HuffmanTree();
        Node node = huffmanTree.createHuffmanTree(array);
        huffmanTree.preOrder(node);
    }
}
