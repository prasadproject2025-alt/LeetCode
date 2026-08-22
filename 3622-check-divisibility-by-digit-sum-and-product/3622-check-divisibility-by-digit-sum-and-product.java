class Solution {
    public boolean checkDivisibility(int n) {
        String s=Integer.toString(n);
        int x=0;
        int y=1;
        for(char a:s.toCharArray()){
            int t=Character.getNumericValue(a);
            x+=t;
            y*=t;
        }
        
        return n%(x+y)==0;
    }
}