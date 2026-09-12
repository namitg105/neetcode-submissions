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
        int[] ans = new int[2];
        int sum = 9999;
        while (sum != target ) {
          //  System.out.println(" Left: " + left + " Numbers[left]: " + numbers[left]
            //    + " Numbers[right]: "+ numbers[right] + " Right: " + right + " sum: " + sum) ;
               
                sum =numbers[left] + numbers[right];

            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                ans[0] = left + 1;
                ans[1] = right + 1;
            }
        }
        return ans;
    }
}