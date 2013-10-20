public class Solution {
    static Map<Character, String> letterMap = new HashMap<Character, String>();
    static{
        letterMap.put('1', "");
        letterMap.put('2', "abc");
        letterMap.put('3', "def");
        letterMap.put('4', "ghi");
        letterMap.put('5', "jkl");
        letterMap.put('6', "mno");
        letterMap.put('7', "pqrs");
        letterMap.put('8', "tuv");
        letterMap.put('9', "wxyz");
    }
    
    public ArrayList<String> letterCombinations(String digits) {
        char[] cs = new char[digits.length()];
        ArrayList<String> res = new ArrayList<String>();
        appendDigits(digits, 0, cs, res);
        return res;
    }
    
    private void appendDigits(String digits, int i, char[] cs, ArrayList<String> res){
        if(i == digits.length()){
            res.add(new String(cs));
            return;
        }
        String letters = letterMap.get(digits.charAt(i));
        for(int j = 0; j < letters.length(); j++){
            cs[i] = letters.charAt(j);
            appendDigits(digits, i + 1, cs, res);
        }
    }
}