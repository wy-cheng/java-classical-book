package chap02.BehavioralParameterization_1;

import chap02.Apple;

/**
 * 典型的函数接口
 */
@FunctionalInterface
public interface ApplePredicate {
    boolean test(Apple apple);
}

