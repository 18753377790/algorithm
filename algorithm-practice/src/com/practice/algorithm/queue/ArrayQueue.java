package com.practice.algorithm.queue;

import java.util.NoSuchElementException;

/**
 * @Author 李非凡
 * @Description: 顺序队列，数组实现
 * @Date 2020/1/18 22:00
 * @Version 1.0
 */
public class ArrayQueue<T> implements MyQueue<T> {

    /**
     * used to store data into this array in a queue manner
     */
	private T[] queue;

    /**
     *  the total number of elements in the queue
     */
	private int size;

    /**
     * the index of the first element in the queue
     */
	private int first;

    /**
     * the index of the next available element (last one's next)
     */
	private int rear;

    /**
     * 2
     */
	private static final int TWO = 2;

    /**
     * 3/4时缩容
     */
	private static final double FACTOR = 0.25;

	public ArrayQueue() {
        // initialize the queue as an array of size 2
        queue = (T[]) new Object[TWO];
        // size is 0 since this is an empty queue
        size = 0;
        // initialize other instance variables:
        first = 0;
        rear = 0;
    }

    /**
     * is empty?
     * @return true is empty,false is not empty
     */
    @Override
    public boolean isEmpty() {
    	return 0 == size;
    }

    /**
     * the size of the queue
     * @return the number of items in the queue
     */
    @Override
    public int size() {
    	return size;
    }


    /**
     * enqueue: add an element at the tail of queue
     * @param item the element
     */
    @Override
    public void enqueue(T item) {
        // rear == queue.length 表示队列末尾没有空间了
        if (rear == queue.length) {
            // rear == queue.length && first==0，表示整个队列都占满了，此时需要扩容
            if (first == 0){
                T[] temp = (T[]) new Object[size * TWO];
                System.arraycopy(queue, first, temp, first, rear - first);
                queue = temp;
            }else if (rear - first >= 0){
                System.arraycopy(queue, first, queue, 0, rear - first);

                rear -= first;
                first = 0;
            }
        }

        queue[rear] = item;
        ++rear;
        ++size;
    }

    /**
     * dequeue: remove and return the head of the queue 
     * @return the deleted value
     * @throws NoSuchElementException if queue is empty
     */
    @Override
    public T dequeue() throws NoSuchElementException {
        if (rear == first) {
            throw new NoSuchElementException("The queue is empty");
        }
        // 缩容
        int length = (int) (size * FACTOR);
        if (rear - first <= length) {
            T[] temp = (T[]) new Object[size / TWO];
            for (int i = 0; i < rear - first; ++i) {
                temp[i] = queue[i + first];
            }
            queue = temp;
        }

        T t = queue[first];
        --size;
        ++first;

        return t;
    }

    /**
     * peek: view the head of queue without removing it.
     * @return Null if queue is empty
     */
    @Override
    public T peek() {
    	return queue[first];
    }
}