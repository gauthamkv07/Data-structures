class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0 , nums.length - 1);
        return nums;
    }
    
    public void mergeSort(int[] nums, int p, int r) {
        if(p < r) {
            int q = (p + r) / 2;
            mergeSort(nums , p , q);
            mergeSort(nums, q+1, r);
            merge(nums, p , q , r);
        }
    }
    
    public void merge(int[] nums, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        
        int[] L = new int[n1+1];
        int[] R = new int[n2+1];
        
        for(int i = 0; i < n1; i++) {
            L[i] = nums[p+i];
        }
        L[n1] = Integer.MAX_VALUE;
        
        for(int i = 0; i < n2; i++) {
            R[i] = nums[q+i+1];
        }
        R[n2] = Integer.MAX_VALUE;
        
        int i = 0;
        int j = 0;
        while(p<=r){
            if(L[i] <= R[j]) {
                nums[p++] = L[i++];
            } else {
                nums[p++] = R[j++];
            }
        }
    }
}