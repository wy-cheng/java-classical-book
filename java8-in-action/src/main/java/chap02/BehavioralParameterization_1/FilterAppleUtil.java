package chap02.BehavioralParameterization_1;

import chap02.Apple;

import java.util.List;
import java.util.stream.Collectors;

public class FilterAppleUtil {
    /**
     * 使用Lambda表达式作为匿名类的替代
     * @param inventory
     * @param p
     * @return
     */
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p){
        return inventory.stream().filter(apple->p.test(apple)).collect(Collectors.toList());
    }

    /**
     * 另外一种简洁方式，直接调用方法的引用
     * @param inventory
     * @param p
     * @return
     */
    public static List<Apple> filterApplesDup(List<Apple> inventory, ApplePredicate p){
        return inventory.stream().filter(p::test).collect(Collectors.toList());
    }
}
