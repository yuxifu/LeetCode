/*
 *  Author:      Yuxi Fu
 *  Create Date: 2016-12-19
 */
/*
   Given a collection of intervals, merge all overlapping intervals.
   For example,
   Given [1,3],[2,6],[8,10],[15,18],
   return [1,6],[8,10],[15,18].
 */

import java.util.*;

public class MergeIntervals {

public static class Interval {
int start;
int end;
Interval() {
        start = 0; end = 0;
}
Interval(int s, int e) {
        start = s; end = e;
}
public String toString() {
        return "["+start+","+end+"]";
}
}

// Time: O(nlogn)
// Space: O(1)
public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1)
                return intervals;

// Sort by ascending starting point using an anonymous Comparator
        Collections.sort(intervals, new Comparator<Interval>() {
                        @Override
                        public int compare(Interval i1, Interval i2) {
                                return Integer.compare(i1.start, i2.start);
                        }
                });

        List<Interval> result = new LinkedList<Interval>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (Interval interval : intervals) {
                if (interval.start <= end) // Overlapping intervals, move the end if needed
                        end = Math.max(end, interval.end);
                else {         // Disjoint intervals, add the previous one and reset bounds
                        result.add(new Interval(start, end));
                        start = interval.start;
                        end = interval.end;
                }
        }

// Add the last interval
        result.add(new Interval(start, end));
        return result;
}

// debug
public static void main(String[] args) {
        MergeIntervals s = new MergeIntervals();
        ArrayList<Interval> itvs = new ArrayList<Interval>();
        itvs.add(new Interval(1,3));
        itvs.add(new Interval(2,6));
        itvs.add(new Interval(8,10));
        itvs.add(new Interval(15,18));
        System.out.println(s.merge(itvs));
}

}
