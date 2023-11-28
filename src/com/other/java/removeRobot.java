package com.other.java;

import org.junit.Test;

/**
 * 假设有排成一行的N个位置，记为1~N，N一定大于或等于2
 * 开始时机器人在其中的M位置上(M一定是 1~N中的一个)
 * 如果机器人来到1位置，那么下一步只能往右来到2位置；
 * 如果机器人来到N位置，那么下一步只能往左来到N-1 位置；
 * 如果机器人来到中间位置，那么下一步可以往左走或者往右走；
 * 规定机器人必须走 K 步，最终能来到P位置(P也是1~N中的一个)的方法有多少种
 * 给定四个参数 N、M、K、P，返回方法数。
 */
public class removeRobot {

    @Test
    public void test() {
        System.out.println(ways1(5, 2, 4, 6));
    }

    //方法一：暴力递归
    public static int ways1(int N, int start, int aim, int K) {
        //边界判断 N至少要2个 机器人才能移动。 start开始位置和aim目标位置 范围在1-N，K步要大于0
        if (N < 2 || start < 1 || start > N || aim < 1 || aim > N || K < 1) {
            //越界输入 直接返回-1
            return -1;
        }
        //调用递归函数，返回符合的从start移动k步到aim的次数
        return process1(start, K, aim, N);
    }

    /**
     * @param cur  机器人当前来到的位置cur
     * @param rest 机器人还有rest步要走
     * @param aim  最终要达到的目标位置aim
     * @param N    一共有N个位置
     */
    public static int process1(int cur, int rest, int aim, int N) {
        if (rest == 0) {
            //base case:当步数都走完了的时候 判断cur当前位置是否来到aim 是则返回1种，否则就是0
            return cur == aim ? 1 : 0;
        }
        //如果还有剩余步数 rest >0 那么判断几种情况的移动
        //当前cur在1位置时，只有向右+1 向左会越界 来到2  步数-1
        if (cur == 1) {
            return process1(2, rest - 1, aim, N);
        }
        //当前cur在N位置时，只能向左 -1 向右会越界  步数-1
        if (cur == N) {
            return process1(N - 1, rest - 1, aim, N);
        }
        //如果不在1 N 在中间 那么既可以向左 也可以向右 那么就表示有两种情况 返回就将两者相加
        return process1(cur - 1, rest - 1, aim, N) + process1(cur + 1, rest - 1, aim, N);
    }


    //优化方法二：添加缓存表 自顶向下的动态规划  也叫 记忆化搜索
    public static int ways2(int N, int start, int aim, int K) {
        //边界判断 N至少要2个 机器人才能移动。 start开始位置和aim目标位置 范围在1-N，K步要大于0
        if (N < 2 || start < 1 || start > N || aim < 1 || aim > N || K < 1) {
            //越界输入 直接返回-1
            return -1;
        }
        //方法一中 只跟cur rest相关 目标节点aim  n位置数 整个过程不影响
        //cur 当前位置范围是 1-N   rest 剩余步数 范围是 0-K
        //定义 二维数组 cur*rest 范围来保存这两个值的全部结果，作为缓存表作用 长度N+1 K+1 dp[0]行不处理 从1-N行处理即可
        int[][] dp = new int[N + 1][K + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= K; j++) {
                //初始化赋值-1 表示还没访问到的位置
                dp[i][j] = -1;
            }
        }
        //从start开始位置移动K步 来到aim目标位置 传递dp保存访问结果 减少遍历次数 缓存表
        return process2(start, K, aim, N, dp);
    }

    public static int process2(int cur, int rest, int aim, int N, int[][] dp) {
        //如果当前位置cur 剩余步数rest 得到的结果不是-1 就直接返回
        if (dp[cur][rest] != -1) {
            //如果cur rest不是-1 说明已经访问过计算过结果了，直接返回 不用再计算
            return dp[cur][rest];
        }
        //定义一个结果集 用来返回
        int ans = 0;
        //情况1 剩余步数为0时
        if (rest == 0) {
            //步数走完 当cur位置来到aim目标位置 说明符合题意次数 返回1  否则返回0
            ans = cur == aim ? 1 : 0;
        } else if (cur == 1) {
            //情况2 如果当前位置在1 还有剩余步数 那么只能向右走来到2 步数-1 赋值给ans
            ans = process2(2, rest - 1, aim, N, dp);
        } else if (cur == N) {
            //情况3 剩余步数 cur在N 只能往左走
            ans = process2(N - 1, rest - 1, aim, N, dp);
        } else {
            //情况4 不在头尾 那么就在中间 可以往左也可以往右
            ans = process2(cur + 1, rest - 1, aim, N, dp) + process2(cur - 1, rest - 1, aim, N, dp);
        }
        //赋值完成后，最后返回前 需要进行对缓存表的赋值
        dp[cur][rest] = ans;
        return ans;
    }

    //优化方法三：最终版动态规划 通过前面的递归加缓存表可以得到结果都是存放到一个二维数组
    //而目标就是根据前面的各种情况，填充这张表dp[N+1][K+1]，而结果返回的 根据题意要求cur当前位置 走了K步 就是dp[cur][rest]
    public static int ways3(int N,int start, int aim, int K){
        //边界判断 N至少要2个 机器人才能移动。 start开始位置和aim目标位置 范围在1-N，K步要大于0
        if (N < 2 || start < 1 || start > N || aim < 1 || aim > N || K < 1) {
            //越界输入 直接返回-1
            return -1;
        }
        //方法一中 只跟cur rest相关 目标节点aim  n位置数 整个过程不影响
        //cur 当前位置范围是 1-N   rest 剩余步数 范围是 0-K
        //定义 二维数组 cur*rest 范围来保存这两个值的全部结果，作为缓存表作用 长度N+1 K+1 dp[0]行不处理 从1-N行处理即可
        int[][] dp = new int[N+1][K+1];   //默认值都是0
        //情况1 确定base case 当rest为0 时  只有cur==aim 值则为1 否则为0
        dp[aim][0] = 1;      //cur移动位置是行数，cur == aim 就在第aim行 第0列表示 rest没有剩余步数 此时值为1 该列其他位置都是0
        //当前rest剩余步数不为0时 则有多种情况
        for(int rest = 1; rest <= K; rest++) {
            //情况2 当cur位置来到1 时 机器人只能向右移动 来到2 也就是向下一行移动 并且剩余步数-1 向左一列移动 也就是依赖 左下位置的值
            dp[1][rest] = dp[2][rest-1];

            //情况3 当cur位置来到N 时 机器人只能向左移动 来到N-1 也就是向上一行移动 并且剩余步数-1 向左一列移动 也就是依赖 左上位置的值
            dp[N][rest] = dp[N-1][rest-1];

            //情况4 cur 不在1  N  机器人可以向左 向右移动 去到cur-1 cur+1 也就是上下一行的位置 剩余步数-1 左移一列 也就是以来 左下和左上位置的值
            for(int cur = 2; cur < N;cur++){
                dp[cur][rest] = dp[cur-1][rest-1] + dp[cur+1][rest-1];
            }
        }
        //把二维数组填充完成 最后题意要求的位置 就是在start位置到K步的值
        return dp[start][K];
    }
}
