package com.algorithm.practice.queue;

import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description: test the queue
 * @Date 2020/1/18 22:20
 * @Version 1.0
 */
public class Driver {

    /**
     * The cycle number
     */
    private static final int LOOP_COUNT = 1000;

	public static void main(String[] args) {

		MyQueue<Integer> q;

        System.out.println("Please enter 'true' or 'false':");
        // make it false if you want to array implementation
		boolean useList = new Scanner(System.in).nextBoolean();

        if (useList) {
            q = new ListQueue<>();
        } else {
            q = new ArrayQueue<>();
        }

        // test the method size
        System.out.println("The queue size is " + q.size());

        // add a large number of items onto the queue
        for(int i = 0; i < LOOP_COUNT; i++) {
        	q.enqueue(i);
        }

        // test the method isEmpty
        System.out.println("Is the queue empty? " + q.isEmpty());
        // test the method size
        System.out.println("The queue size is " + q.size());
        // test the method peek
        System.out.println("The head of queue is " + q.peek());

        System.out.println("now, dequeue items!");
        while(!q.isEmpty()) {
        	System.out.print(q.dequeue() + " ");
        }
        System.out.println("end of dequeueing");    
        
        // you should fully test/debug all methods!

        // test the method isEmpty
        System.out.println("Is the queue empty? " + q.isEmpty());
        // test the method size
        System.out.println("The queue size is " + q.size());
        // test the method peek
        System.out.println("The head of queue is " + q.peek());
	}
}
