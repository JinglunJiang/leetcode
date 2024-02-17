class Solution {
    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    public void sort(int[] nums, int i, int j){
        if (i < j){
            int mid = i + (j - i) / 2;
            sort(nums, i, mid);
            sort(nums, mid + 1, j);
            merge(nums, i, mid, j);
        }
    }

    public void merge(int[] nums, int i, int mid, int j){
        int m = mid - i + 1;
        int n = j - mid;
        int[] left = new int[m];
        int[] right = new int[n];
        
        for (int a = 0; a < m; a++){
            left[a] = nums[i + a];
        }
        for (int b = 0; b < n; b++){
            right[b] = nums[mid + b + 1];
        }
        
        int k = i;
        int a = 0;
        int b = 0;

        while (a < m && b < n){
            if (left[a] < right[b]){
                nums[k] = left[a];
                k++;
                a++;
            }
            else{
                nums[k] = right[b];
                k++;
                b++;
            }
        }
        while (a < m){
            nums[k] = left[a];
            k++;
            a++;
        }
        while (b < n){
            nums[k] = right[b];
            k++;
            b++;
        }
    }
}