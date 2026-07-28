class Solution {
    public String smallestPalindrome(String s) {
        int[] x=new int[26];
        int n=s.length();
        String a="";
        String b="";
        if(n<=1){
            return s;
        }else{
            for(char y:s.toCharArray()){
                x[y-'a']++;
            }
        }

        for(int i=0;i<26;i++){
            for(int j=0;j<x[i]/2;j++){
                a+=(char)('a'+i)+"";
            }
            if(x[i]%2==1){
                b+=(char)('a'+i)+"";
            }
        }
        String c=new StringBuilder(a).reverse().toString();
        return a+b+c;
    }
}