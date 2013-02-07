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
    public ArrayList<Interval> insert(ArrayList<Interval> intervals,
			Interval newInterval) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int len = intervals.size();
		int i1 = bsearch(intervals, newInterval.start, 0, len);
		int i2 = bsearch(intervals, newInterval.end, 0, len);
		ArrayList<Interval> res = new ArrayList<Interval>();

		for (int i = 0; i < i1; i++) {
			res.add(intervals.get(i));
		}
		
		if (i1 >= 0) {
			Interval inter1 = intervals.get(i1);
			if (newInterval.start > inter1.end) {
				res.add(inter1);
			} else {
				newInterval.start = inter1.start;
			}
		}
		
		if (i2 >= 0) {
			Interval inter2 = intervals.get(i2);
			if (newInterval.start > inter2.end) {
				if (i2 != i1) {
					res.add(inter2);
				}
			} else {
				newInterval.end = Math.max(newInterval.end, inter2.end);
			}
			res.add(newInterval);
		} else {
			res.add(newInterval);
		}
		
		for (int i = i2 + 1; i < len; i++) {
			res.add(intervals.get(i));
		}
		return res;
	}

	private int bsearch(List<Interval> inters, int val, int s, int e) {
		if (e - s <= 2) {
			if (e <= s) {
				return -1;
			} else if (val >= inters.get(e - 1).start) {
				return e - 1;
			} else if (val >= inters.get(s).start) {
				return s;
			} else if (val < inters.get(s).start) {
				return s - 1;
			}
		}
		int mid = (s + e) / 2;
		Interval midIn = inters.get(mid);
		if (val >= midIn.start) {
			return bsearch(inters, val, mid, e);
		} else {
			return bsearch(inters, val, s, mid);
		}
	}
}