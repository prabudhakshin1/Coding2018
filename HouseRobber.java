/*
https://leetcode.com/problems/house-robber/description/

You are a professional robber planning to rob houses along a street.
Each house has a certain amount of money stashed, the only constraint stopping you from robbing
each of them is that adjacent houses have security system connected and it will automatically
contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house,
determine the maximum amount of money you can rob tonight without alerting the police.
*/
class HouseRobber {
    /*
    * This is same as longest increasing subsequnce problem.
    * Need to find the subsequence subject to the constraint that no two adjacent houses
    * are selected. 
    * dp[i] = Max value obtainable by stealing in house 'i' and some houses on or before i-2.
    */

    public int rob(int[] nums) {
        // if current is 'i', then prevMax holds maximum value ontainable from 0 to i-2.
        int prevMax = 0;
        int prev = 0;
        
        for(int i=0; i<nums.length; i++) {
            int current = prevMax + nums[i];
            prevMax = Math.max(prevMax, prev);
            prev = current;
        }
        
        return Math.max(prevMax, prev);
    }
}