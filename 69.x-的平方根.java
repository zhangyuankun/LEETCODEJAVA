/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根
 */
class Solution {
    public int mySqrt(int x) {
        if(x==0||x==1) return x;
        for(int i=0;i<=x/2;i++){
            if((i*i<=x&&((i+1)*(i+1)>x))||(i==46340)) return i;
        }
        return 0;
    }
}

