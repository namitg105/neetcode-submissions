// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
//         int size = nums.length;
//         Set<String> set = new HashSet<>();
//         List<List<Integer>> output = new ArrayList<>();
//         for (int i = 0; i < nums.length; i++) {
//             for (int j = i + 1; j < nums.length; j++) {
//                 for (int k = j + 1; k < nums.length; k++) {
//                     int sum = nums[i] + nums[j] + nums[k];
//                     if (sum == 0) {
//                         List<Integer> list = new ArrayList<>();
//                         list.add(nums[i]);
//                         list.add(nums[j]);
//                         list.add(nums[k]);
//                         output.add(list);
//                     }
//                 }
//             }
//         }
//         return output;
//     }
// }

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            // skip duplicate fixed numbers
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // small optimization: if smallest possible sum > 0, no more triplets possible
            if (nums[i] > 0) break;

            int left = i + 1, right = n - 1;
            int target = -nums[i];

            while (left < right) {
                int sum = nums[left] + nums[right];

                if (sum == target) {
                    output.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    // skip duplicates for left
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    // skip duplicates for right
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return output;
    }
}