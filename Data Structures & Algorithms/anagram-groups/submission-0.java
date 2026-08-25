class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars); // canonical form, e.g. "eat" -> "aet"

            //m-1 lamda function is used here   map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
            //m-2
            List<String> bucket;
            if (map.containsKey(key)) {
                bucket = map.get(key);//points to the same array as in map not a pass by value its pass by refrence 
            } else {
                bucket = new ArrayList<>();
                map.put(key, bucket);
            }
            bucket.add(s);
        }

        return new ArrayList<>(map.values());
    }
}

/*class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        isAnagramm obj = new isAnagramm();
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                System.out.print(strs[i] + " " + strs[j] + " ");
                List<String> list = new ArrayList<>();
                Set<String> set1 = new HashSet<>();
                System.out.println("isAnagram? " + obj.isAnagram(strs[i], strs[j]));
                if (obj.isAnagram(strs[i], strs[j])) {
                    set1.add(strs[i]);
                    set1.add(strs[j]);
                    strs[j] = "sucker";
                    list.addAll(set1);
                    ans.add(list);
                } else {
                    ans.add(Arrays.asList(strs[i]));
                }

            }
            System.out.printf("\n");
        }
        return ans;
    }
}

class isAnagramm {
    public boolean isAnagram(String s, String t) {
        boolean containsElement = false, countSame = false;
        char[] S = s.toCharArray();
        char[] T = t.toCharArray();
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (char ch : S) {
            set1.add(ch);
        }

        for (char ch : T) {
            set2.add(ch);
        }

        if (S.length != T.length) {
            return false;
        } else {
            for (char c : set1) {
                int count = 0;
                for (int j = 0; j < S.length; j++) {
                    if (c == S[j]) {
                        count++;
                    }
                }
                map1.put(c, count);
            }
            for (char ti : set2) {
                int count1 = 0;
                for (int j = 0; j < T.length; j++) {
                    if (ti == T[j]) {
                        count1++;
                    }
                }
                map2.put(ti, count1);
            }

            if (set1.equals(set2)) {
                containsElement = true;
                for (char si : set1) {
                    // System.out.println("First set element: " + si + " ");
                    //System.out.println(map1.get(si) + " " + map2.get(si));

                    if (map1.get(si).equals(map2.get(si))) {
                        countSame = true;
                    } else {
                        countSame = false;
                        break;
                    }
                }
            } else {
                containsElement = false;
            }
            // System.out.print(containsElement + " " + countSame);
            if (containsElement && countSame) {
                return true;
            } else {
                return false;
            }
        }
    }
}*/