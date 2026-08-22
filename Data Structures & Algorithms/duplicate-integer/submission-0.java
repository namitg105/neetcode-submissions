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