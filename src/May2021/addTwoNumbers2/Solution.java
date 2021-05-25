package May2021.addTwoNumbers2;

/**
 * @program: leetcodeDemo
 * @description: 2. 两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。
 * 它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。。
 * @Author wei
 * @Date 2021/5/25 19:13
 *
 *
 * 执行用时：3 ms, 在所有 Java 提交中击败了18.53% 的用户
 * 内存消耗：38.5 MB, 在所有 Java 提交中击败了89.99% 的用户
 **/
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        //由于它们都是逆序储存，所以第一个就是最后一位，因此直接相加即可。（注意进位）
        //建立链表的指针
        ListNode first = null;
        ListNode last = null;
        int add = 0;
        //l1和l2本身不为空，继续循环
        while (l1 != null || l2 != null || add != 0) {
            //l1和l2若为空
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;

            //添加的值
            int result = x + y + add;

            //向尾节点添加数据
            //最后一个节点变成倒二个节点
            ListNode oldLast = last;

            //新的最后一个节点
            last = new ListNode();
            last.val = result % 10;
            last.next = null;

            //如果第一个节点为空/
            if (first == null) {
                first = last;
            } else {
                oldLast.next = last;
            }

            //它们的和除以10，就能判断是否进位
            add = result / 10;

            //l1和l2向右移动，如果已经是空节点了，就不移动
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

        }

        //返回第一个节点
        return first;
    }
}



