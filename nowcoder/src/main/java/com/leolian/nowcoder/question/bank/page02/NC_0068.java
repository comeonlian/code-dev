package com.leolian.nowcoder.question.bank.page02;

/**
 * NC 68 : 跳台阶
 * <p>
 * 描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class NC_0068 {

    public static void main(String[] args) {
        NC_0068 nc0068 = new NC_0068();

        int target = 10;
        int res = nc0068.jumpFloor(target);
        System.out.println(res);
    }

    public int jumpFloor(int target) {
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        return jumpFloor(target - 1) + jumpFloor(target - 2);
    }
    
    /*
    运行时间：328ms
    超过41.22% 用Java提交的代码
    占用内存：9720KB
    超过5.63%用Java提交的代码
    */
}
