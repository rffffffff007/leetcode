public class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(strs, new Comparator<String>(){
            public int compare(String a, String b){
                return a.length() - b.length();
            } 
        });
        if(strs.length == 0){
            return "";
        }
        String str0 = strs[0];
        int i, j;
        for(i = 0; i < str0.length(); i++){
            char c = str0.charAt(i);
            for(j = 1; j < strs.length; j++){
                if(c != strs[j].charAt(i)){
                    break;
                }
            }
            if(j != strs.length){
                break;
            }
        }
        return str0.substring(0, i);
    }
    
    
}