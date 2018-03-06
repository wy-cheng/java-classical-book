package chap02;

import java.util.ArrayList;
import java.util.List;

/**
 * 通过行为参数话传递代码
 */
public class MultiFilterAppleMethods {
    /**
     * 筛选绿苹果
     * @param inventory
     * @return
     */
    public static List<Apple> filterGreenApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<Apple>();
        for(Apple apple:inventory){
            if("green".equals(apple.getColor())){ ///////////NOTICE//////////////
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 将颜色作为参数
     * @param inventory
     * @param color
     * @return
     */
    public static List<Apple> filterApplesByColor(List<Apple> inventory, String color){
        List<Apple> result = new ArrayList<Apple>();
        for(Apple apple:inventory){
            if(color.equals(apple.getColor())){ ///////////NOTICE//////////////
                result.add(apple);
            }
        }
        return result;
    }


}
