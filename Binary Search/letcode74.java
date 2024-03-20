class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix.length * matrix[0].length - 1;
        while (i <= j){
            int mid = i + (j - i) / 2;
            int row = mid / matrix[0].length;
            int column = mid % matrix[0].length;
            if (matrix[row][column] < target){
                i = mid + 1;
            }
            else if (matrix[row][column] > target){
                j = mid - 1;
            }
            else{
                return true;
            }
        }
        return false;
    }
}