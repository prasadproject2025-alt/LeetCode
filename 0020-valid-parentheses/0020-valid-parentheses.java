class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0)
            return false;

        char[] pila = new char[s.length()];
        int tope = 0;

        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                    pila[tope++] = ')';
                    break;
                case '[':
                    pila[tope++] = ']';
                    break;
                case '{':
                    pila[tope++] = '}';
                    break;
                default:
                    if(tope == 0 || pila[--tope] != c )
                        return false;
            }
        }
        return tope == 0;
    }
}