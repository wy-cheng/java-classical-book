package chap02;

/**
 * 用静态工厂方法替换构造器
 * 动机：
 * 	1. 静态工厂方法不同于构造器，他们有名字
 * 	2. 不必再每次调用它们的时候都创建一个新对象
 * 	3. 可以返回原类型的任何子类型
 *
 * 	静态工厂方法的主要缺点：
 * 	1. 类如果不含有公有的或者受保护的构造器，就不能被子类化（如本例中的Apple）
 * 	2. 静态工厂方法与其他静态方法实际上没有任何区别
 */
public class StaticFactory{
	/**
	 * Apple的父类
	 */
	static class Fruit{

	}
	public static final class Apple extends  Fruit{
		private static Apple apple;

		private double weight;
		private String color;
		private  String name;

		private Apple(double weight, String color, String name) {
			this.weight = weight;
			this.color = color;
			this.name = name;
		}

		private Apple(String color, String name) {
			this.color = color;
			this.name = name;
		}

		private Apple(double weight, String name) {
			this.weight = weight;
			this.name = name;
		}

		/**
		 * 对应于动机1，静态工厂方法有名字
		 */
		public static Apple getInstanceByWeightColorName(double weight, String color, String name){
			return new Apple(weight,color,name);
		}

		public static Apple getInstanceByColorName(String color, String name){
			return new Apple(color,name);
		}

		public static Apple getInstanceByWeightName(double weight, String name){
			return new Apple(weight,name);
		}

		/**
		 * 动机2，可参考单例模式
		 */
		public static Apple getInstance(double weight, String color, String name){
			if(apple==null){
				return new Apple(weight,color,name);
			}
			return apple;
		}

		/**
		 * 动机3
		 */
		public Fruit getApple(double weight, String color, String name){
			return new Apple(weight,color,name);
		}
	}


}
