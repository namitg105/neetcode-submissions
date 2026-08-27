class Solution {
    public String encode(List<String> strs) {
        StringBuffer ans = new StringBuffer("");
        for (String i : strs) {
            char[] charArr = i.toCharArray();
            String len = String.valueOf(i.length());
            ans.append(len);
            ans.append("#");
            ans.append(i);
        }
        return ans.toString();
    }

public List<String> decode(String str) {
    List<String> res = new ArrayList<>();
    int i = 0;

    while (i < str.length()) {
        int delimiterIndex = str.indexOf('#', i);
        int len = Integer.parseInt(str.substring(i, delimiterIndex));
        int start = delimiterIndex + 1;
        int end = start + len;
        res.add(str.substring(start, end));
        i = end;
    }

    return res;
}
}