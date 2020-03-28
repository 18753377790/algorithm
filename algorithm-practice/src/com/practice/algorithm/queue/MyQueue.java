package com.practice.algorithm.queue;

import java.util.NoSuchElementException;

/**
 * @Author 李非凡
 * @Description:
 * Interface for a stack of primitive doubles.
 * CPS 350
 *
 * NOTE: You will need to explain each method
 *
 * 队列的定义：
 * 队列是先进先出的数据结构，它是线性表的一种
 * 队列元素从队头出队，从队尾入队
 * 队列需要两个指针：一个是 head 指针，指向队头；一个是 tail 指针，指向队尾。
 *
 * 队列的实现方式：
 * 1.用数组实现的队列叫作顺序队列
 * 2.用链表实现的队列叫作链式队列
 * 此外还有双端队列和循环队列等
 *
 * 队列操作的时间复杂度：
 * 1.入队enqueue，平均时间复杂度是O(1)，顺序队列最坏情况是O(n)->队满时引发数组扩容
 * 2.出队enqueue，平均时间复杂度是O(1)
 * 3.取队顶元素peek，判断队空isEmpty和求队列元素数量size均为O(1)
 *
 * 队列的应用：
 * 1.FIFO（先进先出）缓存淘汰策略
 * 2.CPU的排队请求
 * 3.并发编程（Java concurrent）中的阻塞队列
 * 4.Linux 环形缓存
 *
 * Object Oriented Programming
 * 1.inheritance
 * 写一个接口，用一个类实现它并重写接口中的方法，就是继承的思想
 * 例：public class ArrayQueue<T> implements MyQueue<T> {}
 * 接口的实现类中重写（Override）接口中的方法
 * 例：所有用@Override注解修饰的方法
 * 2.encapsulation
 * 属性（成员变量）私有化（用private修饰）
 * 例：private int size;
 * 方法（成员方法）公开化（用public修饰）
 * 例：public int size() {return size}
 * 3.polymorphism
 * 向上造型：超类（接口）的引用指向派生类的对象
 * 例：MyQueue<Integer> q = new ArrayQueue<>(); 或者 MyQueue<Integer> q = new ListQueue<>();
 *
 * constant
 * 在计算机程序运行时，不会被程序修改的量
 * Java中的常量用static final修饰，定义并初始化后不可变
 * 例：private static final int LOOP_COUNT = 1000;
 *
 * generics
 * Java泛型是J2 SE1.5中引入的一个新特性，其本质是参数化类型，也就是说所操作的数据类型被指定为一个参数（type parameter）
 * 这种参数类型可以用在类、接口和方法的创建中，分别称为泛型类、泛型接口、泛型方法。
 * 例：
 * 1.class and interface
 * public interface MyQueue<T>{}
 * public class ListQueue<T> implements MyQueue<T> {}
 * 2.method
 * public T peek(){}
 * 3.variable
 * private T[] queue;
 *
 * exception
 * 异常指的是在程序运行过程中发生的异常事件，通常是由外部问题（如硬件错误、输入错误）所导致的。
 * 在Java等面向对象的编程语言中异常属于对象。
 * throw用于抛出新异常
 * 例：throw new NoSuchElementException("The queue is empty");
 * throws用于向上一级调用方法抛出异常。
 * 例：public T dequeue() throws NoSuchElementException{}
 * try catch用于捕获异常
 * @Date 2020/1/18 21:55
 * @Version 1.0
 */
public interface MyQueue<T> {

    /**
     * is empty?
     * @return true is empty,false is not empty
     */
    boolean isEmpty();

    /**
     * the size of the queue
     * @return the number of items in the queue
     */
    int size();

    /**
     * enqueue: add an element at the tail of queue
     * @param item the element
     */
    void enqueue(T item);

    /**
     * dequeue: remove and return the head of the queue 
     * @return the deleted value
     * @throws NoSuchElementException if queue is empty
     */
    T dequeue() throws NoSuchElementException;

    /**
     * peek: view the head of queue without removing it.
     * @return Null if queue is empty
     */
    T peek();
}
