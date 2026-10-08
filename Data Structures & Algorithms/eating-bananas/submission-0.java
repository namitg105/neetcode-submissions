class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        for (int i = 1; i < piles.length; i++) {
            if (piles[i] > max) {
                max = piles[i];
            }
        }
        int ans = 0;
        int low = 1;
        int high = max;
        int mid = 0;
        while (low <= high) {
            mid = low + ((high - low) / 2);

            if (timeToEat(mid, piles) <= h) {
                ans = mid;
                high = mid - 1;
            } else if (timeToEat(mid, piles) > h) {
                low = mid + 1;
            }
        }
        return ans;
    }
    public int timeToEat(int k, int[] piles) {
        int len = piles.length;
        int time = 0;
        for (int i = 0; i < len; i++) {
            time += piles[i] / k;
            if (piles[i] % k != 0)
              {  time++; }// leftover bananas take one more hour        }
        }
            return time;
    }
}