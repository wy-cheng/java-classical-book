package chap04;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 介绍流的一些特性
 */
public class StreamDemo {
    public static void iterStream(){
        //#####与迭代器类似,流只能遍历一次#####
        List<String> title = Arrays.asList("Java8","in","action");
        Stream<String> s = title.stream();
        s.forEach(System.out::println);
        s.forEach(System.out::println); // 此处会抛出流已被操作或关闭异常-->java.lang.IllegalStateException
    }

    // 流上的操作可分为两种：中间操作和终端操作
    /**
     * 流的流水线背后的思想类似于构建器模式（Builder Pattern）
     */
    /**
     * 总而言之，流的使用一般包含三件事：
     * 1. 一个数据源（如集合）来执行一个查询
     * 2. 一个中间操作链，形成一条流的流水线
     * 3. 一个终端操作，执行流水线，并能生成结果
     */
}
