// // M-1
// class Solution {
//     public int largestRectangleArea(int[] heights) {
//         int maxArea = 0;
//         for (int i = 0; i < heights.length; i++) {
//             int rC = 0, lC = 0;
//             for (int j = i - 1; j >= 0; j--) {
//                 if (heights[j] >= heights[i]) {
//                     rC++;
//                 } else {
//                     break;
//                 }
//             }

//             for (int j = i + 1; j < heights.length; j++) {
//                 if (heights[j] >= heights[i]) {
//                     lC++;
//                 } else {
//                     break;
//                 }
//             }

//             int area = heights[i] * (lC + rC + 1);
//             if (area > maxArea) {
//                 maxArea = area;
//             }
//             System.out.println(" Current ht: " + heights[i] + " rC: " + rC + " lC: " + lC
//                 + " Area: " + area + " MAx Area: " + maxArea);
//         }
//         return maxArea;
//     }
// }
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= heights.length; i++) {

            int currHeight = (i == heights.length) ? 0 : heights[i];

            while (!st.isEmpty() && heights[st.peek()] > currHeight) {
                int height = heights[st.pop()];

                int width;
                if (st.isEmpty()) {
                    width = i;
                } else {
                    width = i - st.peek() - 1;
                }

                maxArea = Math.max(maxArea, height * width);
            }

            st.push(i);
        }

        return maxArea;
    }
}