public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = (int)Math.pow(2, n);
        Integer[] codes = new Integer[len];
        codes[0] = 0;
        int curLen = 1;
        int offset = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < curLen; j++){
                codes[curLen + j] = codes[curLen - 1 - j] | offset;
            }
            curLen <<= 1;
            offset <<= 1;
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.addAll(Arrays.asList(codes));
        return res;
    }
}