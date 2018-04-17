/*
https://leetcode.com/problems/sliding-window-maximum/description/

Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
You can only see the k numbers in the window. Each time the sliding window moves right by one position.

For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3

Return: [3,3,5,5,6,7]
*/
class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        if (k==0)
            return new int[0];
        
        Deque<Integer> dq = new ArrayDeque<>();
        int[] result = new int[nums.length-k+1];
        int resInd = 0;
        
        for(int i=0; i<nums.length; i++) {
            
            // Remove anything that does not below to the current sliding window
            if(!dq.isEmpty() && dq.getFirst() == i-k)
                dq.removeFirst();
                
            while(!dq.isEmpty() && nums[i] >= nums[dq.getLast()])
                dq.removeLast();
            
            dq.addLast(i);
            
            if(i>=k-1)
                result[resInd++] = nums[dq.getFirst()];
        }
        
        return result;
    }
}