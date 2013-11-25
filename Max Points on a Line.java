/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        int maxCount = 0;
        int sameCount = 0;
        Map<Double, Integer> map = new HashMap<Double, Integer>();
        for(Point pi : points){
            map.clear();
            sameCount = 0;
            for(Point pj : points){
                if(pi.x == pj.x && pi.y == pj.y){
                    sameCount++;
                    continue;
                }
                double slope = Double.NaN;
                if(pi.x != pj.x)
                    slope = (pi.y - pj.y) * 1d / (pi.x - pj.x);
                increase(map, slope);
            }
            maxCount = Math.max(maxCount, sameCount);
            for(int v : map.values())
                maxCount = Math.max(maxCount, v + sameCount);
        }
        return maxCount;
    }
    
    private int increase(Map<Double, Integer> map, double d){
        int val = 1;
        if(map.containsKey(d)){
            val = map.get(d) + 1;
        }
        map.put(d, val);
        return val;
    }
}