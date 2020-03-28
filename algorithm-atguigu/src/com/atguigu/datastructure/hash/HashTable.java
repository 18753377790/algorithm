package com.atguigu.datastructure.hash;

/**
 * @Author 李非凡
 * @Description: 散列表（哈希表），用于管理多条链表
 * 根据关键码值
 * 映射函数叫散列函数
 * 存放记录的数组叫散列表
 *
 * 哈希表应用
 * 缓存产品：redis，Memcache
 * 自己实现缓存：
 * 数组+链表
 * 数组+二叉树（红黑树）
 * 一级缓存，二级缓存的再哈希
 *
 * 思考题：如果id不是从低到高插入，但要求各条链表仍是从低到高，怎么解决？
 * @Date 2020/3/7 16:59
 * @Version 1.0
 */
public class HashTable {

    /**
     * 管理链表的数组
     */
    private EmployeeLinkedList[] employeeLinkedLists;

    /**
     * 数组的大小
     */
    private int size;

    /**
     * 构造器
     * @param size
     */
    public HashTable(int size) {
        this.size = size;
        // 初始化employeeLinkedLists
        employeeLinkedLists = new EmployeeLinkedList[size];
        // 注意：需要分别初始化每个链表，否则在操作链表的时候会报空指针异常
        for (int i = 0; i < size; i++) {
            employeeLinkedLists[i] = new EmployeeLinkedList();
        }

    }

    /**
     * 散列函数（取模法）
     * @param id
     * @return
     */
    public int hash(int id){
        return id % size;
    }

    /**
     * 添加雇员结点
     * @param employee
     */
    public void add(Employee employee) {
        // 根据雇员的id得到该雇员结点应该添加到哪条链表
        int employeeLinkedListNo = hash(employee.id);
        // 将雇员结点添加到对应的链表中
        employeeLinkedLists[employeeLinkedListNo].add(employee);
    }

    /**
     * 遍历散列表（遍历哈希表中所有的链表）
     */
    public void list() {
        for (int i = 0; i < size; i++) {
            employeeLinkedLists[i].list(i);
        }
    }

    /**
     * 根据输入的id，查找雇员
     * @param id
     */
    public void findEmployeeById(int id) {
        // 使用散列函数确定到哪个链表查找
        int employeeLinkedListNo = hash(id);
        Employee employee = employeeLinkedLists[employeeLinkedListNo].findEmployeeById(id);
        // 已找到
        if (employee != null) {
            System.out.printf("在第%d条链表中找到雇员id=%d\n", employeeLinkedListNo + 1, id);
        }else {
            System.out.println("在哈希表中没有找到该雇员结点");
        }
    }

    /**
     * 思考题：删除雇员结点
     * @param id
     */
    public void delete(int id) {

    }

    /**
     * 按id顺序插入
     * @param employee
     */
    public void addByOrder(Employee employee) {

    }
}
