class Solution {
    public int minimumPushes(String word) {
        int a=0;
        int x=0;
        HashMap<Character,Integer> map=new HashMap<>();
        for(char b:word.toCharArray()){
            map.put(b,map.getOrDefault(b,0)+1);
        }

        List<Integer> y=new ArrayList<>(map.values());
        Collections.sort(y);
        Collections.reverse(y);
        for(int c:y){
            int t=x/8+1;
            if (t==0){
                a+=1*c;
            }else{
                a+=t*c;
            }
            x++;
        }        
        return a;
    }
}