public class Solution {
    static String[] ARITHS = new String[]{"+", "-", "*", "/"};
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<String>();
        for(String token : tokens){
            if(isArith(token)){
                int y = Integer.parseInt(stack.pop());
                int x = Integer.parseInt(stack.pop());
                int z = 0;
                if(token.equals("+"))
                    z = x + y;
                else if(token.equals("-"))
                    z = x - y;
                else if(token.equals("*"))
                    z = x * y;
                else
                    z = x / y;
                stack.push("" + z);
            } else{
                stack.push(token);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    private boolean isArith(String s){
        for(String arith : ARITHS)
            if(arith.equals(s))
                return true;
        return false;
    }
}
