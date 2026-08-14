class Solution {
    public int maximumLengthSubstring(String s) {
        int n=s.length()-1;
        int left=0;
        int counter=0;
        int temp=0;
        HashMap<Character,Integer> map=new HashMap<>();

        for(int right=0;right<=n;right++){
            char a=s.charAt(right);
            map.put(a,map.getOrDefault(a,0)+1);
            if(map.get(a)<=2){
                temp++;
                counter=Math.max(counter,temp);
            }else{
                
                counter=Math.max(temp,counter);
                while(map.get(a)>2){
                    char b=s.charAt(left);
                    if(map.get(b)==1){
                        map.remove(b);
                        temp--;
                    }else{
                        map.put(b,map.getOrDefault(b,0)-1);
                        temp--;
                    }
                    left++;
                }
                temp++;
            }
        }
        return counter;
    }
}