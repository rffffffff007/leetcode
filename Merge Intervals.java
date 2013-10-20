/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return a.start - b.start;
            }
        });
        
        ArrayList<Interval> result = new ArrayList<Interval>();
        Interval cur = null;
        for(Interval i : intervals){
            if(cur == null || cur.end < i.start){
                cur = new Interval(i.start, i.end);
                result.add(cur);
            } else {
                cur.end = Math.max(cur.end, i.end);
            } 
        }
        return result;
    }
}