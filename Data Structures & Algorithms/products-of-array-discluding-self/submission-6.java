// class Solution {
//     public int[] productExceptSelf(int[] nums) {
        /*
        int[] arr = new int[nums.length];
         int ans = 1;
         for (int i = 0; i < nums.length; i++) {
             ans = ans * nums[i];
         }
         for (int i = 0; i < nums.length; i++) {
             if (nums[i] != 0) {
                 arr[i] = ans / nums[i];
             } else {
                 int ans1 = 1;
                 for (int j = 0; j < nums.length; j++) {
                     if (nums[j] == 0) {
                         //     System.out.print(nums[j]+"continue ");
                         continue;
                     }

                     //  System.out.print(nums[j]+" not continue ");
                     // System.out.print("BEFORE "+ans+" ");
                     ans1 = ans1 * nums[j];
                     // System.out.print("AFTER "+ans+" ");
                 }
                 arr[i] = ans1;
             }
         }
         return arr;*/


         //m-2
         /*
        int[] arr = new int[nums.length];
        int[] leftMuls=new int[nums.length];
       
        for (int k = 0; k < nums.length; k++) {
            int rhsMul = 1;

            for (int j = k + 1; j < nums.length; j++) {
                rhsMul *= nums[j];
            }
            //  System.out.print(rhsMul);

            int lhsMul = 1;
            for (int j = k - 1; j >= 0; j--) {
                lhsMul *= nums[j];
            }
            // System.out.print(lhsMul);

            arr[k] = lhsMul * rhsMul;
        }
        return arr;
    }
}*/
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] arr = new int[n];

        // 1. Build prefix product array: left[i] contains product of nums[0..i-1]
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        // 2. Build suffix product array: right[i] contains product of nums[i+1..n-1]
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        // 3. Multiply corresponding left and right values
        for (int i = 0; i < n; i++) {
            arr[i] = left[i] * right[i];
        }

        return arr;
    }
}
