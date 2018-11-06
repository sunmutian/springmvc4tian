package com.tian.sort.list;

/**
 * @auther: lawt
 * @date: 2018/11/6 09
 * @Description: 两个有序链表合并
 *
 */
public class MyList {


    /**
     * 非递归方式
     * 递归方式见 com.tian.sort.list.Interview1
     * @param head1 有序链表1
     * @param head2 有序链表2
     * @return 合并后的链表
     */
    public static Node mergeTwoList2(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return head1 != null ? head1 : head2;
        }
        //合并后链表头结点
        Node head = head1.data < head2.data ? head1 : head2;

        Node cur1 = head == head1 ? head1 : head2;
        Node cur2 = head == head1 ? head2 : head1;

        Node pre = null;//cur1前一个元素
        Node next = null;//cur2的后一个元素

        while (cur1 != null && cur2 != null) {
            //第一次进来肯定走这里
            if (cur1.data <= cur2.data) {
                pre = cur1;
                cur1 = cur1.next;
            } else {
                next = cur2.next;
                pre.next = cur2;
                cur2.next = cur1;
                pre = cur2;
                cur2 = next;
            }
        }
        pre.next = cur1 == null ? cur2 : cur1;
        return head;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node1.next = node3;
        node3.next = node5;
        node2.next = node4;
//        Node node = mergeTwoList(node1, node2);
        Node node = mergeTwoList2(node2, node1);
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
