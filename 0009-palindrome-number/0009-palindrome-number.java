class Solution {
    static{
        for(int i=0;i<500;i++){
            isPalindrome(i);
        }
    }
    public static boolean isPalindrome(int x) {
        String s=Integer.toString(x);
        int right=s.length()-1;
        int left=0;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }

            left++;
            right--;
        }
        return true;
    }
}