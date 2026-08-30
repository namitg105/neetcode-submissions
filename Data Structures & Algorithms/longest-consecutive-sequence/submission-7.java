/*M-1
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        /*  int min=nums[0];
          for(int i=1;i<nums.length;i++){
              if(min>nums[i]){
                  min=nums[i];
              }
          }
          System.out.print("Min element:"+min);
           here we dont need to solve only for minimum element as there could be elements which have
          a more longer consecutive strings as in nums=[9,1,4,7,3,-1,0,5,8,-1,6]*/
    /*
          int[] maxCountArr =new int[nums.length];
    
    
        for (int i = 0; i < nums.length; i++) {
            int ele = nums[i], count = 0;
            while (Array.isElementInArray(ele, nums)) {
                count++;
                ele = ele + 1;
            }
           maxCountArr[i]= count;
        }
         int max=maxCountArr[0];
          for(int i=1;i<maxCountArr.length;i++){
              if(max<maxCountArr[i]){
                  max=maxCountArr[i];
              }
          }
          //System.out.print("Max element:"+max);
          return max;

        
    }
}
class Array {
    public static boolean isElementInArray(int a, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == a) {
                return true;
            }
        }
        return false;
    }
}

*/

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
    
        for (int num : nums) {
            numSet.add(num);
        }

        int longest = 0;

        for (int n : numSet) {
            if (!numSet.contains(n - 1)) {
                int length = 1;

                while (numSet.contains(n + length)) {
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}
