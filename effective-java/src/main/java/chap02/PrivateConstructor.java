package chap02;

/**
 * 通过私有构造器强化不可实例化能力。
 * 该trick在开发时常用。常用于不希望被实例化的工具类，因为实例化对它没有任何意义
 */
public class PrivateConstructor {
	private PrivateConstructor(){
		throw  new AssertionError("不允许实例化");
	}

	public static void otherMethod(){

	}
}
