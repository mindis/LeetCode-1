import java.util.Arrays;
import java.util.Comparator;

class Solution {
    class myComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            return a[1] - b[1];
        }
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, new myComparator());
        int end = intervals[0][1];
        int count = 1;
        for (int i = 1; i < intervals.length; ++i) {
            if (intervals[i][0] >= end) {
                count++;
                end = intervals[i][1];
            }
        }
        return intervals.length - count;
    }
}

public class leetcode {
    public static void main(String[] args) {
        int[][] a = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        Solution s = new Solution();
        System.out.println(s.eraseOverlapIntervals(a));
    }
}