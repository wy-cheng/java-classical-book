package chap06;

import chap02.Apple;

import java.util.*;

import static java.util.stream.Collectors.*;

/**
 * 用流收集数据
 */
public class CollectorDemo {
    public static void main(String[] args) {
        /**
         * 归约和汇总
         */
        List<Apple> inventory = Collections.emptyList();
        // 1. 查找流中的最大值和最小值
        Comparator<Apple> appleWeightComparator = Comparator.comparingInt(Apple::getWeight);
        Optional<Apple> appleOp = inventory.stream().collect(maxBy(appleWeightComparator));

        // 2. 汇总
        int totalWeight = inventory.stream().collect(summingInt(Apple::getWeight));
        IntSummaryStatistics statistics = inventory.stream().collect(summarizingInt(Apple::getWeight));

        // 3. 连接字符串
        String shortMenu = inventory.stream().map(Apple::getColor).collect(joining(", "));
    }
}
