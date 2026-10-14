class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int mid = 0;
        while (left <= right) {//y equal to ?
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[left] <= nums[mid]) { // left half sorted
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] <= target && target <= nums[right]) { // right is sorted   
                    left = mid + 1;

                } else {
                    right = mid - 1;
                }
            }
        }
 return -1;   }
}
