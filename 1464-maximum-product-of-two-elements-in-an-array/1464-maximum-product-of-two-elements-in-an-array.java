class Solution {
    public int maxProduct(int[] nums) {
        int mx1=Integer.MIN_VALUE,mx2=Integer.MIN_VALUE;
        for(int ele:nums){
            if(ele>mx1){
                mx2=mx1;
                mx1=ele;
            }else if(ele>mx2)mx2=ele;
        }
        return (mx1-1)*(mx2-1);
    }
}