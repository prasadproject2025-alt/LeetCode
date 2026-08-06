class Solution {
    public int smallestNumber(int n, int t) {
        
        while (true) {
            int temp = n;
            int product = 1;

            // Find product of digits
            while (temp > 0) {
                int digit = temp % 10;
                product = product * digit;
                temp = temp / 10;
            }

            // Check divisibility
            if (product % t == 0) {
                return n;
            }

            n++;
        }
    }
}