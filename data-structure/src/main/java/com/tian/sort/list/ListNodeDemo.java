package com.tian.sort.list;

/**
 * @auther: lawt
 * @date: 2018/11/4 08
 * @Description: 单向链表基本操作
 */
public class ListNodeDemo {
    /**
     * 插入头结点
     */
    public static void insertHead(Node head, Node newHead) {
        Node old = head;
        head = newHead;
        head.next = old;
    }

    /**
     * 插入尾节点
     */
    public static void insertTail(Node tail, Node newTail) {
        Node old = tail;
        tail = newTail;
        tail.next = null;
        old.next = tail;
    }

    /**
     * 遍历
     *
     * @param head 链表
     */
    public static void query(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    /**
     * 查找某个结点
     *
     * @param head 头结点
     * @param data 要找的node的data
     * @return 链表下标
     */
    public static int find(Node head, int data) {
        int index = -1;//初始值为-1
        int count = 0;//可以知道循环次数
        while (head != null) {//当头结点部位null
            if (head.data == data) {//如果该节点的值==找的
                index = count;
            }
            count++;//没有找到，循环次数+1
            head = head.next;//没有找到继续遍历
        }
        return index;//返回链表下标
    }

    /**
     * 插入
     *
     * @param p 插入到p的后
     * @param s 需要插入的node
     */
    public static void insert(Node p, Node s) {
        Node next = p.next;//记录下p结点
        p.next = s;//p的next指向s结点
        s.next = next;//把p结点的next指向s的next结点
    }

    /**
     * 删除结点q
     *
     * @param head 链表
     * @param q    删除的结点
     */
    public static void delete(Node head, Node q) {
        //q不为空，q的下一个结点也不为空
        if (q != null && q.next != null) {
            //思路：把q的next的next指向q的next，
            //这样之前q的next就被删除了
            Node p = q.next;
            q.data = p.data;
            q.next = p.next;
            p = null;
        }
        //删除最后一个节点
        if (q.next == null) {
            while (head != null) {
                //遍历前面的链表，当该节点的next就是q的时候
                //然后把q设置成null
                if (head.next != null && head.next == q) {
                    head.next = null;
                    break;
                }
                head = head.next;
            }

        }
    }

    public static void mains(String[] args) {

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
     * 当偶数个则取前面那个
     *
     * @return 中间节点
     */
    public static Node getMid(Node head) {
        if (head == null) {
            return head;
        }
        Node fast = head;
        Node slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        query(node1);
        Node newHead = new Node(6);
        insertHead(node1, newHead);
        Node node7 = new Node(7);
        insertTail(node4, node7);
        query(newHead);
        System.out.println(find(newHead, 3));
        Node node8 = new Node(8);
        insert(node3, node8);
        query(newHead);
        delete(newHead, node3);
        query(newHead);

        Node head= new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        head.next = n2;
        n2.next = n3;
        n3.next = null;
        System.out.println(getMid(head).data);
        Node node = reversal(head);
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
