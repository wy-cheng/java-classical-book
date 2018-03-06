package chap05;

import chap02.Apple;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 使用流
 */
public class UseStreamDemo {

    public static void main(String[] args) {
        /**
         * 筛选和切片
         */
        // 1. 用谓词筛选
        List<Apple> inventory  = Collections.emptyList();
        List<Apple> greenApples = inventory.stream().filter(apple->"green".equals(apple.getColor())).collect(Collectors.toList());

        // 2. 筛选各异的元素
        Stream.of(1,2,1,3,3,2,4).filter(i->i%2==0).distinct().forEach(System.out::println);

        // 3. 截短流
        Stream.of(1,2,1,3,3,2,4).filter(i->i==1).limit(1).collect(Collectors.toList());

        // 4. 跳过元素
        Stream.of(1,2,1,3,3,2,4).filter(i->i>1).skip(1).collect(Collectors.toList());

        /**
         * 映射
         */
        // 1. 对流中每一个元素应用函数
        List<String> applesColor = inventory.stream().map(Apple::getColor).collect(Collectors.toList());

        // 2.流的扁平化
        List<String> words = Arrays.asList("Java 8","Lambdas","In","Action");
        // 如果返回一张列表，列出里面各不相同的字符呢？
        // flatMap方法效果是各个数组并不是分别映射成一个流，而是映射成流的内容
        List<String> uniqueCharacters = words.stream().map(w->w.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());

        /**
         * 查找和匹配
         */
        // 1. 检查谓词是否至少匹配一个元素
        Stream.of(1,2,1,3,3,2,4).anyMatch(i->i==1); // true

        // 2. 检查谓词是否匹配所有元素
        Stream.of(1,2,1,3,3,2,4).allMatch(i->i==1); // false

        // 3. 与allMatch相对的是noneMatch，它可以确保流中没有任何元素与给定的谓词匹配
        Stream.of(1,2,1,3,3,2,4).noneMatch(i->i==1); // false

        // 4. 查找元素
        Stream.of(1,2,1,3,3,2,4).filter(i->i==1).findAny().ifPresent(i-> System.out.println(i));

        // 5. 查找第一个元素
        Optional<Integer> someNumber = Stream.of(1,2,1,3,3,2,4).map(i->i*i).filter(x->x%3==0).findFirst();

        /**
         * 归约
         */
        // 1. 元素求和
        int sum = Stream.of(1,2,1,3,3,2,4).reduce(0,(a,b)->a+b);
        Optional<Integer> sumOp = Stream.of(1,2,1,3,3,2,4).reduce((a,b)->a+b);

        // 2. 最大值、最小值
        Optional<Integer> max = Stream.of(1,2,1,3,3,2,4).reduce(Integer::max);
        Optional<Integer> min = Stream.of(1,2,1,3,3,2,4).reduce(Integer::min);


        /**
         * 数值流
         */
        // 1. 原始类型流特化
        // 映射到数值流(装箱造成的复杂性)
        int weight = inventory.stream().mapToInt(Apple::getWeight).sum();

        // 2. 转换回对象流
        IntStream intStream = inventory.stream().mapToInt(Apple::getWeight);
        Stream<Integer> stream = intStream.boxed(); // 将数值流转换谓Stream

        // 3. 默认值OptionalInt
        OptionalInt maxWeigthOp = inventory.stream().mapToInt(Apple::getWeight).max();
        int maxWeight = maxWeigthOp.orElse(1); // 如果没有最大值的化，显示提供一个默认最大值


        /**
         * 构建流
         */
        // 1. 由值创建流
        Stream<String> streamStr = Stream.of("Java 8","Lambda","In","Action");
        streamStr.map(String::toUpperCase).forEach(System.out::println);

        // 2. 由数组创建流
        int[] numbers = {2,3,5,7,11,13};
        int sumArr =  Arrays.stream(numbers).sum();

        // 3. 由文件创建
        long uniqueWords = 0;
        try(Stream<String> lines = Files.lines(Paths.get("data.txt"), Charset.defaultCharset())){
            uniqueWords = lines.flatMap(line->Arrays.stream(line.split(" "))).distinct().count();
        }catch (IOException e){

        }

        /**
         * 由函数生成流：创建无限流
         */
        // 1. 迭代
        Stream.iterate(0,n->n+2).limit(10).forEach(System.out::println);

        // 2. 生成
        Stream.generate(Math::random).limit(5).forEach(System.out::println);
    }
}
