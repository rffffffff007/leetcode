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
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        int n = intervals.size();
        int left = bsearch(intervals, newInterval.start, 0, intervals.size());
        int right = bsearch(intervals, newInterval.end, 0, intervals.size());
        if(left < 0 || !interleave(intervals.get(left), newInterval))
            left++;
        Interval insert = new Interval();
        insert.start = newInterval.start;
        if(left < n)
            insert.start = Math.min(insert.start, intervals.get(left).start);
        insert.end = newInterval.end;
        if(right >= 0)
            insert.end = Math.max(insert.end, intervals.get(right).end);

        ArrayList<Interval> result = new ArrayList<Interval>();
        result.addAll(intervals.subList(0, left));
        result.add(insert);
        result.addAll(intervals.subList(right + 1, n));
        return result;
    }

    private boolean interleave(Interval a, Interval b) {
        return (a.start - b.start) * (a.end - b.start) <= 0
                || (a.start - b.end) * (a.end - b.end) <= 0;
    }

    private int bsearch(List<Interval> intervals, int target, int s, int e){
        if(s == e)
            return s - 1;
        int mid = (s + e) / 2;
        Interval inter = intervals.get(mid);
        int val = inter.start;
            
        if(val == target)
            return mid;
        else if(val > target)
            return bsearch(intervals, target, s, mid);
        else
            return bsearch(intervals, target, mid + 1, e);
    }
}