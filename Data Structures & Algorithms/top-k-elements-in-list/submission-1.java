class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

list.sort(Map.Entry.<Integer, Integer>comparingByValue().reversed());
        /*for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
          System.out.println("value outside for loop "+entry.getKey()+" " +entry.getValue());
          if( k>0){
          System.out.println("value "+entry.getValue());
           ans.add(entry.getKey());
          }
            k--;
        } */
       
        for (Map.Entry<Integer, Integer> entry : list) {
            if (k > 0) {
               // System.out.println("value " + entry.getValue());
                ans.add(entry.getKey());
            }
            k--;
        }
        int[] arr = new int[ans.size()];

        for (int i = 0; i < ans.size(); i++) {
            arr[i] = ans.get(i);
        }
        return arr;
    }
}