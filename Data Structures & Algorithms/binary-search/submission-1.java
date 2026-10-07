class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
/*
 * WHY: int mid = left + (right - left) / 2;   instead of   (left + right) / 2
 *
 * Reason: INTEGER OVERFLOW.
 * An int can hold at most Integer.MAX_VALUE = 2,147,483,647.
 * (left + right) is computed BEFORE dividing, so if both are large,
 * the sum exceeds that limit. Java does NOT throw an error; it silently
 * wraps around to a NEGATIVE number.
 *
 * Example:
 *   left  = 1_500_000_000
 *   right = 2_000_000_000
 *
 *   (left + right) / 2
 *     = 3_500_000_000 / 2        -> 3.5 billion doesn't fit in an int
 *     = -794_967_296 / 2         -> wraps around (3.5B - 2^32)
 *     = -397_483_648             -> WRONG, negative index -> crash or bad search
 *
 *   left + (right - left) / 2
 *     = 1_500_000_000 + 500_000_000 / 2
 *     = 1_500_000_000 + 250_000_000
 *     = 1_750_000_000            -> CORRECT
 *
 * Why the subtraction version is safe:
 *   If 0 <= left <= right, then (right - left) is between 0 and right,
 *   so it always fits in an int. And left + (right - left)/2 is never
 *   bigger than right, so the final result also fits.
 

int mid = left + (right - left) / 2;      // standard safe version

// Alternative 1: unsigned right shift (also safe, for non-negative left/right)
int mid2 = (left + right) >>> 1;

 * Works even though (left + right) overflows:
 * The sum of two non-negative ints is < 2^32, so its 32 bits are still the
 * correct value IF read as unsigned. The overflow only makes Java interpret
 * the top bit as a sign bit.
 *   >>  (signed shift)   copies the sign bit in from the left -> stays negative
 *   >>> (unsigned shift) shifts in a 0 from the left          -> correct positive half
 * Example: (1_500_000_000 + 2_000_000_000) >>> 1 = 1_750_000_000
 

// Alternative 2: widen to long (safe for int ranges, costs a cast)
int mid3 = (int) (((long) left + right) / 2);*/