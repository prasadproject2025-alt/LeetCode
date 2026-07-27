class Solution {
    public String removeStars(String s) {
        int n=s.length();
        char[] a=s.toCharArray();
        int j=0;
        for(int i=0;i<n;i++){
            if(a[i]=='*'){
                j--;
            }else{
                a[j]=a[i];
                j++;
            }
        }
        return new String(a,0,j);
    }
}