package com.tian.sort.list;

/**
 * @auther: lawt
 * @date: 2018/11/6 10
 * @Description: 链表的奇数位升序，偶数位降序，对链表进行排序
 * 1 8 2 6 3 5
 * 时间复杂度是O(n)
 * 分成三步
 * 1：按照奇数位和偶数位进行拆分成两个链表
 * 2：对偶数位链表进行反转
 * 3：合并两个链表
 */
public class Interview1 {
    /**
     * 按照奇数位和偶数位进行拆分成两个链表
     */
    public static Node[] getList(Node head) {
        //定义两个链表头结点
        Node head1 = null;
        Node head2 = null;
        //两个指针
        Node cur1 = null;
        Node cur2 = null;
        //计数
        int count = 1;
        while (head != null) {
            if (count % 2 == 1) {//计数
                if (cur1 != null) {
                    cur1.next = head;
                    cur1 = cur1.next;
                } else {
                    //这里只是第一次会执行
                    cur1 = head;
                    head1 = cur1;
                }
            } else {
                if (cur2 != null) {
                    cur2.next = head;
                    cur2 = cur2.next;
                } else {
                    //这里只是第一次会执行
                    cur2 = head;
                    head2 = cur2;
                }
            }
            //继续遍历
            head = head.next;
            count++;
        }
        //让两个链表末尾的元素指向Null
        cur1.next = null;
        cur2.next = null;
        return new Node[]{head1, head2};
    }
    /**
     * 翻转链表
     * 时间复杂度O(N)
     * 空间复杂度O(1)
     */
    public static Node reversal(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 递归方式合并两个链表
     *
     * @param head1 有序链表1
     * @param head2 有序链表2
     * @return 合并后的链表
     */
    public static Node mergeTwoList(Node head1, Node head2) {
        //递归结束条件
        if (head1 == null && head2 == null) {
            return null;
        }
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        //合并后的链表
        Node head = null;
        if (head1.data > head2.data) {
            //把head较小的结点给头结点
            head = head2;
            //继续递归head2
            head.next = mergeTwoList(head1, head2.next);
        } else {
            head = head1;
            head.next = mergeTwoList(head1.next, head2);
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        head.next = node7;
        node7.next = node2;
        node2.next = node6;
        node6.next = node3;
        node3.next = node5;
        node5.next=node4;

        Node[] nodes = getList(head);
        Node node = reversal(nodes[1]);
        Node m = mergeTwoList(nodes[0], node);

        while (m != null) {
            System.out.print(m.data + " ");
            m = m.next;
        }
    }
}
