/*
 * @lc app=leetcode.cn id=50 lang=java
 *
 * [50] Pow(x, n)
 *
 * https://leetcode-cn.com/problems/powx-n/description/
 *
 * algorithms
 * Medium (31.34%)
 * Total Accepted:    12K
 * Total Submissions: 38.4K
 * Testcase Example:  '2.00000\n10'
 *
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * 
 * 示例 1:
 * 
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 
 * 
 * 示例 2:
 * 
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 
 * 
 * 示例 3:
 * 
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2^-2 = 1/2^2 = 1/4 = 0.25
 * 
 * 说明:
 * 
 * 
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−2^31, 2^31 − 1] 。
 * 
 * 
 */
class Solution {
    public double myPow(double x, int n) {
        if((x>0&&x<1&&n>2147483646)||(x>1&&n<-2147483647)) return 0.0;
        if(x==-1){
            if(n%2==0) return 1.0;
            else return -1.0;
        }
        if(x==1) return x;
        double  result=1;
        if (n>0) {
            for (int i = 0; i < n; i++) {
                result = result * x;
            }
        } else if(n<0) {
            for(int i=0;i<-n;i++){
                result = result * x;
            }
            result =1/result;
        }
        return result;
    }
}

