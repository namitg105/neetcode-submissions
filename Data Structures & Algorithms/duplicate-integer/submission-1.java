class Solution {
    public boolean hasDuplicate(int[] nums) {
        boolean hasDuplicate=false;
        for( int i=0;i<nums.length;i++){
        for( int j=i+1;j<nums.length;j++){
            if(nums[i]==nums[j]){
 hasDuplicate=true;
 break;
             }
        }
        }
        if(hasDuplicate){
            return true;
        }
        else{
            return false;
        }
    }
}

//m2 return len(set(nums)) != len(nums)?
//@Tirth Patel becuase, if we store the entire array in a set data structure, it doesn't hold any duplicate values, so that it consists of distinct values. meanwhile if our array holds any duplicate values, the length of our array and our set wouldn't be equal. #HappyCoding







