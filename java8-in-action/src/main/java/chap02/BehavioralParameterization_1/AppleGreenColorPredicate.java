package chap02.BehavioralParameterization_1;

import chap02.Apple;

/**
 * 典型的策略模式
 */
public class AppleGreenColorPredicate implements ApplePredicate{
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
