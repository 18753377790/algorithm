package com.practice.algorithm.queue;

import java.util.NoSuchElementException;

/**
 * @Author 李非凡
 * @Description: 链式队列，链表实现
 * @Date 2020/1/18 22:10
 * @Version 1.0
 */
public class ListQueue<T> implements MyQueue<T> {

	/**
	 * 队头指针
	 */
	private Node head = null;

	/**
	 * 队尾指针
	 */
    private Node tail = null;

	/**
	 * 队列长度
	 */
	private int size = 0;

	/**
	 * 内部类作为链表的结点类
	 */
	private class Node {
		// public
		T item;
		// null
		Node next;

		public Node(T item, Node next) {
			this.item = item;
			this.next = next;
		}
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
		if (tail == null) {
			Node newNode = new Node(item, null);
			head = newNode;
			tail = newNode;
		} else {
			tail.next = new Node(item, null);
			tail = tail.next;
		}
		size++;
	}
	
	/**
	 * dequeue: remove and return the head of the queue 
	 * @return the deleted value
	 * @throws NoSuchElementException if queue is empty
	 */
	@Override
	public T dequeue() throws NoSuchElementException{
		if (isEmpty()) {
			throw new NoSuchElementException("The queue is empty");
		}

		T value = head.item;
		head = head.next;
		if (head == null) {
			tail = null;
		}

		size--;
		return value;
	}
	
	/**
	 * peek: view the head of queue without removing it.
	 * @return Null if queue is empty
	 */
	@Override
	public T peek() {
		if (head == null) {
			return null;
		}
		return head.item;
	}
}