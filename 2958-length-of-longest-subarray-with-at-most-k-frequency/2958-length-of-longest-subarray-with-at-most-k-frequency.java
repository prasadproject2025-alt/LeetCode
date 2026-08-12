public class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        int l = 0, cnt = 0; // count of numbers with freq > k
        for (int r = 0; r < nums.length; r++) {
            count.put(nums[r], count.getOrDefault(nums[r], 0) + 1);
            if (count.get(nums[r]) > k) cnt++;
            if (cnt > 0) {
                if (count.get(nums[l]) > k) cnt--;
                count.put(nums[l], count.get(nums[l]) - 1);
                l++;
            }
        }
        return nums.length - l;
    }
}