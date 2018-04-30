/**
 * https://leetcode.com/problems/maximal-rectangle/description/
 * 
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle
 * containing only 1's and return its area.
 */
class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        int cols = rows > 0? matrix[0].length : 0;
        
        if (rows == 0)
            return 0;
        
        int largestArea = 0;
        int[][] ht = new int[rows][cols];
        int[][] wd = new int[rows][cols];
        
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                int th = 0;
                int tw = 0;
                
                if (matrix[i][j] == '0')
                    continue;
                
                ht[i][j] = wd[i][j] = 1;
                
                if (j>0) {
                    th = 1;
                    tw = wd[i][j-1]+1;
                
                    if (th*tw > ht[i][j]*wd[i][j]) {
                        ht[i][j] = th;
                        wd[i][j] = tw;
                    }
                }
                
                if (i>0) {
                    th = ht[i-1][j]+1;
                    tw = 1;
                
                    if (th*tw > ht[i][j]*wd[i][j]) {
                        ht[i][j] = th;
                        wd[i][j] = tw;
                    }
                }
                
                
                if( i>0 && j>0 ) {
                    th = Math.min(ht[i-1][j-1], ht[i-1][j]) + 1;
                    tw = Math.min(wd[i-1][j-1], wd[i][j-1]) + 1;
                
                    if (th*tw > ht[i][j]*wd[i][j]) {
                        ht[i][j] = th;
                        wd[i][j] = tw;
                    }
                }
                
                if(ht[i][j] * wd[i][j] > largestArea) {
                    largestArea = ht[i][j]* wd[i][j];
                }
            }
        }
        
        return largestArea;
    }
}