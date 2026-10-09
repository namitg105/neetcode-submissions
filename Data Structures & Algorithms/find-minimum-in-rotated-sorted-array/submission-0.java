class Solution {
    public int findMin(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[left] < nums[right]) {
                return nums[left];
            }
            else if(nums[mid]>=nums[left]){
                left=mid+1;
            }
            else if(nums[mid]<nums[left]){
                right=mid;
            }
        }
        return nums[left-1];
    }
}

// 4 5 0 1 2 3 
