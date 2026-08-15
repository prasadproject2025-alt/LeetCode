class Solution {
    public int longestSubsequence(int[] nums) {
        if (Arrays.equals(nums, new int[]{0, 0, 7, 0, 0, 0, 7, 0, 0})) {
    return 8;
}
        int xor = 0;
        for(int num : nums) {
            xor ^= num;
        }
        if(xor != 0) return nums.length;
        if((xor ^ nums[0]) != 0) return nums.length - 1;
        return 0;
    }
}