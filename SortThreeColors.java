/**
 * https://leetcode.com/problems/sort-colors/description/
 * 
 * Given an array with n objects colored red, white or blue, sort them in-place
 * so that objects of the same color are adjacent, with the colors in the order
 * red, white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 */
class SortThreeColors {
    public void sortColors(int[] nums) {
        int lastZero = -1;
        int lastTwo = nums.length;
        int current = 0;
        
        while(current < lastTwo) {
            if (nums[current] == 0 ) {
                swap(nums, ++lastZero, current);
                current++;
            } else if (nums[current] == 2) {
                // No need to do initial seek of lastTwo to the last 2's position.
                // Seek is done automatically as the algo runs.
                swap(nums, current, --lastTwo);
            } else {
                current++;
            }
        }
    }
    
    private void swap(int[] ip, int i, int j) {
        int temp = ip[i];
        ip[i] = ip[j];
        ip[j] = temp;
    }
}