class Solution {
    public int numSpecial(int[][] mat) {
        int res = 0;
        int rowCnt[] = new int[mat.length];
        int colCnt[] = new int[mat[0].length];
        for(int i = 0 ; i < mat.length ; i++) {
            for(int j = 0 ; j < mat[0].length ; j++) {
                rowCnt[i] += mat[i][j];
            }
        }

        for(int i = 0 ; i < mat.length ; i++) {
            for(int j = 0 ; j < mat[0].length ; j++) {
                colCnt[j] += mat[i][j];
            }
        }     

        for(int i = 0 ; i < mat.length ; i++) {
            for(int j = 0 ; j < mat[0].length ; j++) {
                if(mat[i][j] == 1 && rowCnt[i] == 1 && colCnt[j] == 1)
                    res++;
            }
        }

        return res;
    }
}