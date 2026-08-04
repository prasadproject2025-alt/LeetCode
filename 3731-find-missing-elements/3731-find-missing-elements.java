class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        int x=0;
        ArrayList<Integer> a=new ArrayList<>();
        for(int i=nums[0];i<nums[nums.length-1];i++){
            if(nums[x]==i){
                x++;
            }else{
                a.add(i);
            }
        }
        return a;
    }
}