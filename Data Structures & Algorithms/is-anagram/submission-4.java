class Solution {
    public boolean isAnagram(String s, String t) {
        Boolean containsElement = false, countSame = false;
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
                int count=0;
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
                if (set1.isEmpty()) countSame = true;
                for (char si : set1) {
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
            if (containsElement && countSame) {
                return true;
            } else {
                return false;
            }
        }
    }
}