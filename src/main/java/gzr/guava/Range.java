package gzr.guava;

import com.google.common.collect.RangeSet;
import com.google.common.collect.TreeRangeSet;

/**
 * Created by gaozengrong on 16/11/21.
 */
public class Range {
    public static void main(String[] args) {
        RangeSet<Integer> rangeSet = TreeRangeSet.create();
        rangeSet.add(com.google.common.collect.Range.closed(1, 10)); // {[1,10]}
        rangeSet.add(com.google.common.collect.Range.closedOpen(11, 15));// 添加[11,15],得到不相连区间:{[1,10],
        // [11,15)}
        rangeSet.add(com.google.common.collect.Range.closedOpen(15, 20)); // 添加[15,20],相连区间; {[1,10],
        // [11,20)}
        rangeSet.add(com.google.common.collect.Range.openClosed(0, 0)); // 空区间; {[1,10], [11,20)}
        rangeSet.remove(com.google.common.collect.Range.open(5, 10)); // 分割[1, 10]; {[1,5], [10,10],
    }
}
