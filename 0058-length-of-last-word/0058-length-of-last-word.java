class Solution {
    public int lengthOfLastWord(String s) {
        String[] x=s.split(" ");
        int y=x.length;
        int z=x[y-1].length();
        return z;
    }
}