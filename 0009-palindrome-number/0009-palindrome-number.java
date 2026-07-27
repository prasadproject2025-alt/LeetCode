
class Solution {
    static{
        for(int i=0;i<500;i++){
            i++;
        }
    }
    public static boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }

        int original = x;
        int reverse = 0;

        while(x != 0){
            int digit = x % 10;
            reverse = reverse * 10 + digit;
            x = x / 10;

        }
        return original == reverse;
    }
}