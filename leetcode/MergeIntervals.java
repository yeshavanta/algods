package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by ykp on 9/10/16.
 */
public class MergeIntervals {

    public class Interval{
        int start;
        int end;

        public Interval(){
            start = 0;
            end = 0;
        }

        public Interval(int s, int e){
            start = s;
            end = e;
        }
    }

    public class IntervalComparator implements Comparator<Interval> {

        @Override
        public int compare(Interval it1, Interval it2){
            if(it1.start != it2.start){
                return it1.start-it2.start;
            }else{
                return it1.end - it2.end;
            }
        }
    }

    public void printIntervals(ArrayList<Interval> intervalList){
        for(Interval interval : intervalList){
            System.out.println(interval.start + " : " + interval.end);
        }
    }

    public ArrayList<Interval> getMergedIntervals(ArrayList<Interval> intervals){
        ArrayList<Interval> result = new ArrayList();

        Interval pre = intervals.get(0);

        for(int i=1;i < intervals.size();i++){
            Interval current = intervals.get(i);
            if(pre.end > current.start){
                Interval merged = new Interval(pre.start, Math.max(pre.end, current.end));
                pre = merged;
            }else{
                result.add(pre);
                pre = current;
            }
        }

        result.add(pre);

        return result;
    }

    public void start(){
        ArrayList<Interval> intervals = new ArrayList();
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(2,6));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(15,18));

        Collections.sort(intervals,new IntervalComparator());

        ArrayList<Interval> mergedIntervals = getMergedIntervals(intervals);
        printIntervals(mergedIntervals);
    }

    public static void main(String[] args){
        MergeIntervals merge = new MergeIntervals();
        merge.start();

    }
}
