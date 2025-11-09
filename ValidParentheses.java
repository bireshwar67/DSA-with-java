import java.util.*;

public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (isOpen(c)) {
                stk.push(c);
            } else if (isClose(c)) {
                if (!stk.isEmpty() && isComplete(stk.peek(), c)) {
                    stk.pop();
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        return stk.isEmpty();
    }

    private boolean isOpen(char c) {
        return (c == '(' || c == '{' || c == '[');
    }

    private boolean isClose(char c) {
        return (c == ')' || c == '}' || c == ']');
    }

    private boolean isComplete(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }

    public static void main(String[] args) {
        ValidParentheses sol = new ValidParentheses();

        String s1 = "()[]{}";
        String s2 = "([)]";
        String s3 = "{[]}";

        System.out.println(s1 + " -> " + sol.isValid(s1)); // true
        System.out.println(s2 + " -> " + sol.isValid(s2)); // false
        System.out.println(s3 + " -> " + sol.isValid(s3)); // true
    }
}
