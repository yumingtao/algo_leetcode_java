package com.ymt.leetcode.list.design_linked_list;

/**
 * @Description
 * @author yumingtao
 * @date 2022-06-12 19:07
 */
public class MyLinkedList {
    Node head;
    Node tail;
    int size;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int get(int index) {
        //index有效范围是[0,size-1]
        if (index < 0 || index > size - 1) {
            return -1;
        }
        Node node = getNodeByIndex(index);
        return node.val;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        if (tail == null) {
            tail = head;
        }
        ++size;
    }

    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if (tail == null) {
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        if (head == null) {
            head = tail;
        }
        ++size;
    }

    public void addAtIndex(int index, int val) {
        if (index == size) {
            addAtTail(val);
            return;
        }

        if (index <= 0) {
            addAtHead(val);
            return;
        }

        if (index > size - 1) {
            return;
        }

        //找到前驱节点
        Node pre = getPreNodeByIndex(index);
        if (pre == null) {
            //添加新的头节点
            addAtHead(val);
            return;
        }
        Node newNode = new Node(val);
        Node next = pre.next;
        //前驱节点指向新的节点
        pre.next = newNode;
        //新节点指向pre原来的next
        newNode.next = next;
        ++size;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index > size - 1) {
            return;
        }

        //先找到前驱节点
        Node pre = getPreNodeByIndex(index);
        if (pre == null) {
            //删除的是头节点
            head = head.next;
        } else {
            //删除的是中间节点
            pre.next = pre.next.next;
            if (pre.next == null) {
                //删除的是尾节点，将尾节点设置为pre
                tail = pre;
            }
        }
        --size;
    }

    private Node getPreNodeByIndex(int index) {
        //如果删除的是头节点，前驱节点返回null
        if (index == 0) {
            return null;
        }
        return getNodeByIndex(index - 1);
    }

    private Node getNodeByIndex(int index) {
        //index是0，直接返回head
        if (index == 0) {
            return head;
        }

        //index是size-1，直接返回tail
        if (index == size - 1) {
            return tail;
        }

        //index范围是(0,size-1),找到索引为index的节点，返回val
        int k = 0;
        Node node = head;
        while (k < index) {
            node = node.next;
            ++k;
        }
        return node;
    }
}
