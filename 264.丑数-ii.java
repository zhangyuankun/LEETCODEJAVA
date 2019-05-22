/*
 * @lc app=leetcode.cn id=264 lang=java
 *
 * [264] 丑数 II
 */
class Solution {
    public int nthUglyNumber(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        int n2 = 0;
        int n3 = 0;
        int n5 = 0;
        for(int i=1;i<n;i++){
            int rn2 = result.get(n2)*2;
            int rn3 = result.get(n3)*3;
            int rn5 = result.get(n5)*5;
            int min = Math.min(result.get(n2)*2,Math.min(result.get(n3)*3,result.get(n5)*5));
            result.add(min);
            if(rn2==min) n2++;
            if(rn3==min) n3++;
            if(rn5==min) n5++;
        }
        return result.get(n-1);
    }
}

