class Solution {
    public int evalRPN(String[] q) {
        Stack<Integer> s = new Stack<>();
        
        for (String s1 : q) {
            if (s1.equals("+") || s1.equals("-") || s1.equals("*") || s1.equals("/")) {
                int a = s.pop(); // second operand (right)
                int b = s.pop(); // first operand (left)
                
                int result = 0;
                switch (s1) {
                    case "+": result = b + a; break;
                    case "-": result = b - a; break;
                    case "*": result = b * a; break;
                    case "/": result = b / a; break; // Integer division
                }
                s.push(result);
            } else {
                // Parse string as int before pushing
                s.push(Integer.parseInt(s1));
            }
        }
        return s.pop();
    }
}
    

