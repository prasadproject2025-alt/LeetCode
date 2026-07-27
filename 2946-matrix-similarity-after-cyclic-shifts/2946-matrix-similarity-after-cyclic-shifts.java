class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        
        k = k % n; // reduce unnecessary shifts
        
        for (int i = 0; i < m; i++) {
            int[] original = mat[i];
            int[] shifted = new int[n];
            
            if (i % 2 == 0) {
                // even row → left shift
                for (int j = 0; j < n; j++) {
                    shifted[j] = original[(j + k) % n];
                }
            } else {
                // odd row → right shift
                for (int j = 0; j < n; j++) {
                    shifted[j] = original[(j - k + n) % n];
                }
            }
            
            // compare arrays
            for (int j = 0; j < n; j++) {
                if (shifted[j] != original[j]) {
                    return false;
                }
            }
        }
        
        return true;
    }
}