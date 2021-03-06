import datastructure.ListNode;
import datastructure.Node;

/**
 * 剑指22
 * 链表中倒数第K个节点
 * 思路：距离双指针
 */
class JZ22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        ListNode p2 = head;
        for (int i = 1; i < k; i++) p1 = p1.next;
        while (p1.next != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        return p2;
    }

}

/**
 * 删除链表中倒数第K个节点
 */


/**
 * 剑指24
 * 反转链表
 * 思路：1）递归 2）双指针
 */
class JZ24 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode temp = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }
}

/**
 * 剑指25
 * 合并排序链表
 * 思路：一个索引指针
 */
class JZ25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode cur = res;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            }
            else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) cur.next = l1;
        if (l2 != null) cur.next = l2;
        return res.next;
    }
}

/**
 * 剑指35
 * 请实现 copyRandomList 函数，复制一个复杂链表。
 * 在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 * 思路：复制相同节点在节点之后
 */
class JZ35 {
    public Node copyRandomList(Node head) {
        Node cur = head;
        while (cur != null) {
            Node duplicate = new Node(cur.val);
            duplicate.next = cur.next;
            cur.next = duplicate;
            cur = duplicate.next;
        }
        cur = head;
        while (cur != null) {
            if (cur.random == null) cur.next.random = null;
            else cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        cur = head;
        Node res = new Node(-1);
        Node Head = res;
        while (cur != null) {
            if (cur.next.next == null) {
                res.next = cur.next;
                cur.next = null;
                cur = null;

            }
            else {
                res.next = cur.next;
                res = res.next;
                cur.next = cur.next.next;
                cur = cur.next;
            }
        }
        return Head.next;
    }
}

/**
 * 剑指52
 * 输入两个链表，找出它们的第一个公共节点。
 * 思路：双指针
 */
class JZ52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int countA = 0, countB = 0;
        ListNode a = headA;
        ListNode b = headB;
        while (a != null) {
            a = a.next;
            countA++;
        }
        while (b != null) {
            b = b.next;
            countB++;
        }
        a = headA;
        b = headB;
        if (countA > countB) {
            for (int i = 0; i < countA - countB; i++) a = a.next;
        }
        if (countA < countB) {
            for (int i = 0; i < countB - countA; i++) b = b.next;
        }
        while (a != null && b != null) {
            if (a == b) return a;
            else {
                a = a.next;
                b = b.next;
            }
        }
        return null;
    }
}

/**
 * LeetCode 2
 * Two Sum
 */




/**
 * 环形链表
 *
 * 思路：超级优雅的双指针。
 */
class LC142 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}


class LC61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        k = k % len;
        if (k == 0) return head;
        k = len - k;
        ListNode old = new ListNode(-1);
        ListNode pre = old;
        old.next = head;
        cur = head;

        while (k > 0) {
            pre = pre.next;
            cur = cur.next;
            k--;
        }
        ListNode res = new ListNode(-1);
        res.next = cur;
        pre.next = null;
        while (cur.next != null) cur = cur.next;
        cur.next = head;
        return res.next;
    }
}