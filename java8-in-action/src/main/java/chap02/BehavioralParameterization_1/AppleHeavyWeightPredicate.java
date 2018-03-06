package chap02.BehavioralParameterization_1;

import chap02.Apple;

public class AppleHeavyWeightPredicate implements ApplePredicate{
    public boolean test(Apple apple) {
        return apple.getWeight()>150;
    }
}
