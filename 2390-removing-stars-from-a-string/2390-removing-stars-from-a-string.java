class Solution {
    public String removeStars(String s) {
        int n=s.length()-1;
        String sub="";

        for(int i=0;i<=n;i++){
            int x=sub.length();
            if(s.charAt(i)=='*'){
                sub=sub.substring(0,x-1);
            }else{
                sub+=s.charAt(i)+"";
            }
        }

        return sub;
    }
}