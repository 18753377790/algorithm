package com.datastructure.hash;

/**
 * @Author 李非凡
 * @Description: 雇员链表类（不带头结点的单链表），是哈希表的一个元素
 * @Date 2020/3/7 19:16
 * @Version 1.0
 */
public class EmployeeLinkedList {

    /**
     * 头指针，默认为null，执行第一个Employee，这个链表是不带头结点的链表，所以head直接指向第一个Employee
     */
    private Employee head;

    /**
     * 添加雇员结点到链表
     * 说明：
     * 1.假定添加雇员结点时，id是自增长的，即id的分配总是从小到大
     *   因此将该雇员直接加入到本链表的最后即可
     * @param employee
     */
    public void add(Employee employee) {
        // 如果是添加第一个雇员结点
        if (head == null) {
            head = employee;
            return;
        }
        // 如果不是添加第一个雇员结点，则使用一个辅助指针帮助定位到最后
        Employee current = head;
        // 说明到链表最后，相当于在循环中加入 if (current.next == null) break
        while (current.next != null) {
            // 后移
            current = current.next;
        }
        // 退出时直接将employee加入链表
        current.next = employee;
    }

    /**
     * 遍历链表的雇员信息
     * @param no 链表的编号
     */
    public void list(int no) {
        // 说明链表为空
        if (head == null) {
            System.out.println("第" + (no + 1) + "链表为空！");
            return;
        }
        System.out.print("第" + (no + 1) + "链表的信息为：");
        // 辅助指针
        Employee current = head;
        while (true) {
            System.out.printf("=>id=%d, name=%s\n", current.id, current.name);
            //  说明到链表最后
            if (current.next == null) {
                break;
            }
            // 后移
            current = current.next;
        }
    }

    /**
     * 根据id查找雇员
     * @param id
     * @return 如果找到，返回雇员结点，如果没有找到，返回null
     */
    public Employee findEmployeeById(int id) {
        if (head == null) {
            System.out.println("链表为空！");
            return null;
        }
        // 辅助指针
        Employee current = head;
        while (true) {
            // 已找到
            if (current.id == id) {
                // 这时current就指向要查找的雇员
                break;
            }
            // 说明遍历当前链表没有找到该雇员
            if (current.next == null){
                current = null;
                // 退出循环
                break;
            }
            current = current.next;
        }
        return current;
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
