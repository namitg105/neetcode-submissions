// class TimeMap {
//     HashMap<String, String> timeMap;
//     public TimeMap() {
//         timeMap = new HashMap<>();
//     }

//     public void set(String key, String value, int timestamp) {
//         StringBuilder sb = new StringBuilder(key);
//         String ts = String.valueOf(timestamp);
//         sb.append(ts);
//         System.out.println(sb);
//         timeMap.put(sb.toString(), value);
//         System.out.println(timeMap);
//     }

//     // public String get(String key, int timestamp) {
//     //     StringBuilder sb = new StringBuilder(key);
//     //     String ts = String.valueOf(timestamp);
//     //     sb.append(ts);
//     //     System.out.println("gettttttttttttt");
//     //     System.out.println(sb);
//     //     System.out.println(timeMap);
//     //     System.out.println(timeMap.get(sb.toString()));
//     //     return timeMap.get(sb.toString());
//     // }
//     public String get(String key, int timestamp) {
//         for (int t = timestamp; t >= 0; t--) {
//             String searchKey = key + t;

//             if (timeMap.containsKey(searchKey)) {
//                 return timeMap.get(searchKey);
//             }
//         }

//         return "";
//     }
// }



class TimeMap {

    class Pair {
        int timestamp;
        String value;

        Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    HashMap<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());

        map.get(key).add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        List<Pair> list = map.get(key);

        int low = 0;
        int high = list.size() - 1;
        String ans = "";

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (list.get(mid).timestamp <= timestamp) {
                ans = list.get(mid).value;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}