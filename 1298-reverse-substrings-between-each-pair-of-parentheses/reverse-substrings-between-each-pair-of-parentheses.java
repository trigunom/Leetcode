class Solution {
    public String reverseParentheses(String s) {
        Stack<StringBuilder> stack = new Stack<>();
        stack.push(new StringBuilder());

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(new StringBuilder());
            } else if (c == ')') {
                StringBuilder current = stack.pop();
                current.reverse();
                stack.peek().append(current);
            } else {
                stack.peek().append(c);
            }
        }

        return stack.pop().toString();
    }
}