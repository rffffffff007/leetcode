public class Solution {
    public boolean isValid(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        char[] cs = s.toCharArray();
        Map<Character, Character> paraMap = new HashMap<Character, Character>();
        paraMap.put('(', ')');
        paraMap.put('[', ']');
        paraMap.put('{', '}');
        
        Stack<Character> stack = new Stack<Character>();
        for(Character c : cs){
            if(paraMap.keySet().contains(c)){
                stack.push(c);
            } else if(paraMap.values().contains(c)){
                if(!stack.isEmpty() && paraMap.get(stack.peek()) == c){
                    stack.pop();
                } else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}