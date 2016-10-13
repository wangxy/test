package main.java.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xwang on 9/12/16.
 */
public class MergeInterval {
    private static class Interval{
        int start;
        int end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public String toString() {
            return this.start + "," + this.end;
        }
    }

    public List<Interval> mergeIntervals(List<Interval> source) {
        if (source == null || source.size() == 0) {
            return source;
        }
        Collections.sort(source, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start < o2.start || o1.start == o2.start && o1.end < o2.end) {
                    return -1;
                } else if (o1.start == o2.start && o1.end == o2.end) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });

        List<Interval> result = new ArrayList<Interval>();
        Interval merged = null;
        for (int i = 0; i < source.size(); i++) {
            if (merged == null) {
                merged = source.get(i); continue;
            }
            if (hasOverlap(merged, source.get(i))) {
                merged = merge(merged, source.get(i));
            } else {
                result.add(merged);
                merged = source.get(i);
            }
        }
        if (merged != null) {
            result.add(merged);
        }
        return result;
    }

    private boolean hasOverlap(Interval a, Interval b) {
        return a.end >= b.start;
    }
    private Interval merge(Interval a, Interval b) {
        return new Interval(a.start, Math.max(a.end, b.end));
    }

    public static void main(String[] args) {
        MergeInterval m = new MergeInterval();
        List<Interval> res = m.mergeIntervals(null);
        List<Interval> r = new ArrayList();
        Collections.addAll(r, new Interval(1, 2), new Interval(3, 4), new Interval(4, 7), new Interval(0, 9));
        res = m.mergeIntervals(r);
        for (Interval x : res) {
            System.out.println(x.toString());
        }
    }
}
