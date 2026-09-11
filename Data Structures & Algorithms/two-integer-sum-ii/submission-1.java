// class Solution {
//     public int[] twoSum(int[] numbers, int target) {
//         int[] ans=new int[2];
//         for (int i = 0; i < numbers.length; i++) {
//             for (int j = i + 1; j < numbers.length; j++) {
//                 if(numbers[i]+numbers[j]==target){
//                     ans[0]=i+1;
//                     ans[1]=j+1;
//                     return ans;
//                 }
//             }
//         }
//         return ans;
//     }
// }
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } 
            else if (sum < target) {
                left++;
            } 
            else {
                right--;
            }
        }

        return new int[]{};
    }
}