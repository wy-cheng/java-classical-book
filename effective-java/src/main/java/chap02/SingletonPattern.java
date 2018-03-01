package chap02;

/**
 * 用私有构造器或枚举类型强化Singleton属性
 */
public class SingletonPattern {
	/**
	 * 恶汉模式
	 */
	public static class Elvis{
		public static final Elvis INSTANCE = new Elvis();
		private Elvis(){}

		public void otherMethods(){
		}
	}

	/**
	 * 另一种恶汉模式
	 */
	public static class ElvisA{
		private static final ElvisA INSTANCE = new ElvisA();
		private ElvisA(){}

		public static ElvisA getInstance(){
			return INSTANCE;
		}
		public void otherMethods(){
		}
	}

	/**
	 * 全场最佳实践。简洁+无偿提供序列化机制，绝对防止多次实例化
	 */
	public enum ElvisB{
		INSTANCE;

		public void otherMethods(){
		}
	}
	// p.s：还有懒汉模式，还有多线程下单例的双重锁检查模式。具体参考网上相关资料
}
