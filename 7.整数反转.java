import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 *
 * https://leetcode-cn.com/problems/reverse-integer/description/
 *
 * algorithms
 * Easy (31.69%)
 * Total Accepted:    101.1K
 * Total Submissions: 314.1K
 * Testcase Example:  '123'
 *
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 
 * 示例 1:
 * 
 * 输入: 123
 * 输出: 321
 * 
 * 
 * 示例 2:
 * 
 * 输入: -123
 * 输出: -321
 * 
 * 
 * 示例 3:
 * 
 * 输入: 120
 * 输出: 21
 * 
 * 
 * 注意:
 * 
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回
 * 0。
 * 
 */
class Solution {
    public int reverse(int x) {
        Boolean flag = true;
        String mid = String.valueOf(x);
        System.out.println(mid);
        if(mid.contains("-")){
            mid = mid.replace("-","");
            flag=false;
        }
        char[] a = mid.toCharArray();
        if(a[a.length-1]==0) a=Arrays.copyOf(a, a.length-1);
        for(int i=0;i<a.length/2;i++){
            char midd = a[i];
            a[i] = a[a.length-i-1];
            a[a.length-i-1] = midd; 
        }
        String midAfter = String.valueOf(a);
        BigInteger result = new BigInteger(midAfter);
        if(((result.compareTo(new BigInteger("2147483647"))>0)&&(flag==true))||((result.compareTo(new BigInteger("2147483648"))>0)&&(flag==false))){
            return 0;
        }else{
            return result.intValue()*(flag==true?1:(-1));
        }
    }
}

