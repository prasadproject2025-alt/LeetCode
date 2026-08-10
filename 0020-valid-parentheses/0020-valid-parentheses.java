class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        for(char c:s.toCharArray()){
            if(c=='(' || c=='[' || c=='{' ){
                st.push(c);
            }else if(c==')' || c==']' || c=='}' ){
                if(st.isEmpty()){
            return false;
        }
                char t=st.pop();
                if(c==')' && t=='(' || c==']' && t=='[' || c=='}' && t=='{'){
                    continue;
                }else{
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}