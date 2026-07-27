class Solution {
    static{
        int j=1;
        for(int i=0;i>500;i++){
            j++;
        }
    }
    public static int maxProduct(int[] nums) {
        int a=Integer.MAX_VALUE;
        int b=Integer.MAX_VALUE;
        int x=Integer.MIN_VALUE;
        int y=Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            if(x<nums[i]){
                y=x;
                x=nums[i];
                
            }else if(y<nums[i]){
                y=nums[i];
            }

            if(a>nums[i]){
                b=a;
                a=nums[i];
                
            }else if(b>nums[i]){
                b=nums[i];
            }
        }

        return Math.max((x-1)*(y-1),(a-1)*(b-1));


    }
}