class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {

            // Operand: push its integer value
            if (!token.equals("+") &&
                !token.equals("-") &&
                !token.equals("*") &&
                !token.equals("/")) {

                stack.push(Integer.parseInt(token));
            } else {
                // Pop the right operand first
                int b = stack.pop();

                // Then pop the left operand
                int a = stack.pop();

                int result = 0;

                switch (token) {
                    case "+":
                        result = a + b;
                        break;

                    case "-":
                        result = a - b;
                        break;

                    case "*":
                        result = a * b;
                        break;

                    case "/":
                        result = a / b;
                        break;
                }

                stack.push(result);
            }
        }

        return stack.pop();
    }
}
