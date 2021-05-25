package May2021.addTwoNumbers2;

/**
 * @program: leetcodeDemo
 * @description:
 * @Author wei
 * @Date 2021/5/25 19:21
 *
 * 执行用时：2 ms, 在所有 Java 提交中击败了100.00% 的用户
 * 内存消耗：39 MB, 在所有 Java 提交中击败了22.69% 的用户
 *
 **/
public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;//指针向右移动
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

}


