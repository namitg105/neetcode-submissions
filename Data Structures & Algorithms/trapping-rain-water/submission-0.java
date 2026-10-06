class Solution {
    public int trap(int[] height) {
        int n=height.length;
        //suffix max 
        int[] suffixMax =new int[height.length];
        suffixMax[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--){
             suffixMax[i]=Math.max(suffixMax[i+1],height[i]);
        }
        //prefix max 
        int[] prefixMax =new int[height.length];
        prefixMax[0]=height[0];
        for(int i=1;i<height.length;i++){
             prefixMax[i]=Math.max(prefixMax[i-1],height[i]);
        }
        int total = 0;
        for (int i = 0; i < height.length; i++) {
            int lmax=prefixMax[i];
            int rmax=suffixMax[i];
            if (height[i] < lmax && height[i] < rmax) {
                total += Math.min(lmax, rmax) - height[i];
            }
        }
        return total;
    }

}