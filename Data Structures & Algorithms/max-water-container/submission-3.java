// class Solution {
//     public int maxArea(int[] heights) {
//         int maxArea = 0, height, width;
//         for (int i = 0; i < heights.length; i++) {
//             for (int j = i + 1; j < heights.length; j++) {
//                 height = min(heights[i], heights[j]);
//                 width = j - i;
//                 int area = width * height;
//                 if (area > maxArea) {
//                     maxArea = area;
//                 }
//             }
//         }
//         return maxArea;
//     }
// }

// int min(int a, int b) {
//     if (a < b) {
//         return a;
//     } else if (b < a) {
//         return b;
//     } else {
//         return b;
//     }
// }
// class Solution {
//     public int maxArea(int[] heights) {
//         TreeMap<Integer, Integer> map = new TreeMap<>();
//         int len = heights.length;
//         int maxArea = 0, maxWidth;
//         for (int i = 0; i < len; i++) {
//             map.put(heights[i], i);
//         }
//         int middle = (0 + len) / 2;
//         for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//             maxWidthFromRemaining = calculateMaxWidth(entry.getValue(), middle, len);
//             int area = maxWidthFromRemaining * entry.getKey();
//             if (area > maxArea) {
//                 maxArea = area;
//             }
//         }
//         return maxArea;
//     }
// }

// int calculateMaxWidth(int i, int middle, int len) {
//     int maxWidth = 0;
//     if (i <= middle) {
//         maxWidth = (len - 1) - i;
//     } else if (i >= middle) {
//         maxWidth = i - (0);
//     }
//     return maxWidth;
// }



class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int width = right - left;
            int area = h * width;
            maxArea = Math.max(maxArea, area);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}