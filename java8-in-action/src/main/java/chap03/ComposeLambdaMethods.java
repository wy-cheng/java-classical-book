package chap03;

import chap02.Apple;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * 复合Lambda表达式的有用方法
 */
public class ComposeLambdaMethods {
    public static void main(String[] args) {
        /**
         比较器复合
         */
        Comparator<Apple> c = Comparator.comparing(Apple::getWeight);
        // 1. 逆序
        List<Apple> inventory = Collections.emptyList();
        inventory.sort(Comparator.comparing(Apple::getWeight).reversed());
        // 2. 比较器链
        inventory.sort(Comparator.comparing(Apple::getWeight).reversed().thenComparing(Apple::getColor));


        /**
         * 谓词复合
         */
        Predicate<Apple> redApple = (Apple red)-> true;
        Predicate<Apple> notRedApple = redApple.negate();

        // 1.链接两个谓词来生成另一个Predicate对象
        Predicate<Apple> readAndHeavyApple = redApple.and(a->a.getWeight()>150);

        // 2.链接Predicate的方法来构造更复杂Predicate对象---> a&b||c
        Predicate<Apple> redAndHeavyAppleOrGreen=redApple.and(a->a.getWeight()>150).or(a->"green".equals(a.getColor()));


        /**
         * 函数复合
         */
        Function<Integer,Integer> f = x->x+1;
        Function<Integer,Integer> g = x->x*2;
        Function<Integer,Integer> h = f.andThen(g);

        // g(f(x))
        int result = h.apply(1); // 输出为4

        Function<Integer,Integer> ff = x->x+1;
        Function<Integer,Integer> gg = x->x*2;
        Function<Integer,Integer> hh = ff.compose(gg);

        // f(g(x))
        int resultDup = hh.apply(1); // 输出为3


    }
}
