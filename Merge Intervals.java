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
        // Start typing your Java solution below
        // DO NOT write main() function
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                if(a.start != b.start){
                    return a.start - b.start;
                }else{
                    return a.end - b.end;
                }
            } 
        });
        
        ArrayList<Interval> res = new ArrayList<Interval>();
        Interval last = null;
        for(Interval i : intervals){
            if(last == null){
                last = i;
            } else if(i.start > last.end){
                res.add(last);
                last = i;
            } else{
                last.end = Math.max(i.end, last.end);
            }
        }
        if(last != null){
            res.add(last);
        }
        return res;
    }
}