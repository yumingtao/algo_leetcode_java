package com.ymt.leetcode.list.design_linked_list;

/**
 * @description
 * @author yumingtao
 * @date 2022-06-15 12:24
 */
public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList l = new MyLinkedList();
        l.addAtHead(84);
        l.addAtTail(2);
        l.addAtTail(39);
        l.get(3);
        l.get(1);
        l.addAtTail(42);
        l.addAtIndex(1, 80);
        l.addAtHead(14);
        l.addAtHead(1);
        l.addAtTail(53);
        l.addAtTail(98);
        l.addAtTail(19);
        l.addAtTail(12);
        l.get(2);
        l.addAtHead(16);
        l.addAtHead(33);
        l.addAtIndex(4, 17);
        l.addAtIndex(6, 8);
        l.addAtHead(37);
        l.addAtTail(43);
        l.deleteAtIndex(11);
        l.addAtHead(80);
        l.addAtHead(31);
        l.addAtIndex(13, 23);
        l.addAtTail(17);
        l.get(4);
        l.addAtIndex(10, 0);
        l.addAtTail(21);
        l.addAtHead(73);
        l.addAtHead(22);
        l.addAtIndex(24, 37);
        l.addAtTail(14);
        l.addAtHead(97);
        l.addAtHead(8);
        l.get(6);
        l.deleteAtIndex(17);
        l.addAtTail(50);
        l.addAtTail(28);
        l.addAtHead(76);
        l.addAtTail(79);
        l.get(18);
        l.deleteAtIndex(30);
        l.addAtTail(5);
        l.addAtHead(9);
        l.addAtTail(83);
        l.deleteAtIndex(3);
        l.addAtTail(40);
        l.deleteAtIndex(26);
        l.addAtIndex(20, 90);
        l.deleteAtIndex(26);
        l.addAtTail(30);
        l.addAtHead(40);
        l.addAtIndex(15, 23);
        l.addAtHead(51);
        l.addAtHead(21);
        l.get(26);
        l.addAtHead(83);
        l.get(30);
        l.addAtHead(12);
        l.deleteAtIndex(8);
        l.get(4);
        l.addAtHead(20);
        l.addAtTail(45);
        l.get(10);
        l.addAtHead(56);
        l.get(18);
        l.addAtTail(33);
        l.get(2);
        l.addAtTail(70);
        l.addAtHead(57);
        l.addAtIndex(31, 24);
        l.addAtIndex(16, 92);
        l.addAtHead(40);
        l.addAtHead(23);
        l.deleteAtIndex(26);
        l.get(1);
        l.addAtHead(92);
        l.addAtIndex(3, 78);
        l.addAtTail(42);
        l.get(18);
        l.addAtIndex(39, 9);
        l.get(13);
        l.addAtIndex(33, 17);
        l.get(51);
        l.addAtIndex(18, 95);
        l.addAtIndex(18, 33);
        l.addAtHead(80);
        l.addAtHead(21);
        l.addAtTail(7);
        l.addAtIndex(17, 46);
        l.get(33);
        l.addAtHead(60);
        l.addAtTail(26);
        l.addAtTail(4);
        l.addAtHead(9);
        l.get(45);
        l.addAtTail(38);
        l.addAtHead(95);
        l.addAtTail(78);
        l.get(54);
        l.addAtIndex(42, 86);

        System.out.println("size:" + l.size);
        System.out.println(l.head.val);
        Node node = l.head;
        for (int i = 0; i < l.size; ++i) {
            System.out.println(node.val);
            node = node.next;
        }

        l.get(0);
    }
}
