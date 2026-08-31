class Solution {
    public boolean isValid(String s3) {
        char[] arr = s3.toCharArray();
        //Set<Character> set = new HashSet<>();

        /*   for (char c : arr) {
               set.add(c);
           }
           for (char ch : set) {
               if (ch == ')') {
                   System.out.print(ch + " "
                       + "set.contains'('" + set.contains('('));
               } else if (ch == '}') {
                   System.out.print(ch + " "
                       + "set.contains'{'" + set.contains('{'));
               }

               else if (ch == ']') {
                   System.out.print(ch + " "
                       + "set.contains'['" + set.contains('['));
               }
           }

           for (char ch : set) {
               if (!(ch == ')' &&( ch != '{' || ch != '[' || ch != '(') && set.contains('('))) {
                   return false;
               } else if (!(ch == '}'&&( ch != '{' || ch != '[' || ch != '(') && set.contains('{')))
           { return false; } else if (!(ch == ']' &&( ch != '{' || ch != '[' || ch != '(') &&
           set.contains('['))) { return false;
               }
           }

           System.out.print("RRRRRRH");
           // int size = set.size();
           // if (size != 0 && size != 2 && size != 4 && size != 6) {
           //     return false;
           // }
           //
           System.out.print(!(set.contains('{')&&set.contains('}')&&set.contains('[')&&set.contains(']')&&set.contains('(')&&set.contains(')')));
           //
           if((set.contains('{')&&set.contains('}')&&set.contains('[')&&set.contains(']')&&set.contains('(')&&set.contains(')'))){
           //     return false;
           // }
           */
      /*  if (arr.length % 2 != 0) {
            return false;
        }*/
         
        Stack<Character> s = new Stack<>();
        Stack<Character> s1 = new Stack<>();
        for (char c : arr) {
            if (c == '(' || c == '{' || c == '[') {
                s.push(c);
            } else if (c == ')') {
                if (s.isEmpty()) {
                    return false;
                }
                char c1 = s.peek();
                System.out.print("zzzzzz" + c1);
                if (c1 == '(') {
                    s.pop();
                }
                    s1.push(c);
            } else if (c == ']') {
                if (s.isEmpty()) {
                    return false;
                }
                char c2 = s.peek();
                System.out.print("zzzzzz" + c2);

                if (c2 == '[') {
                    s.pop();
                }
                    s1.push(c);

            } else if (c == '}') {
                if (s.isEmpty()) {
                    return false;
                }
                // System.out.print(s.peek());
                char c2 = s.peek();
                System.out.print("zzzzzz" + c2);
                if (c2 == '{') {
                    s.pop();
                }
                    s1.push(c);
            }
        }
        if (s.isEmpty()&&s1.size()==arr.length/2) {
            return true;
        } else {
            return false;
        }
    }
}
