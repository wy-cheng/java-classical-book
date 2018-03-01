package chap02;

/**
 * 遇到多个构造器参数时要考虑用构造器
 * 动机：
 * 1. 静态工厂和构造器有个共同的局限性：他们都不能很好地扩展到大量可选参数
 * 2. 使用Java Bean模式的话，需要程序员付出额外的努力来确保它的线程安全
 */
public class BuilderPattern {
	public static class NutritionFacts{
		private final int servingSize;
		private final int servings;
		private final int calories;
		private final int fat;
		private final int sodium;
		private final int carbohydrate;

		public static class Builder{
			// 必填字段
			private final int servingSize;
			private final int servings;

			// 可选字段，设置默认值
			private  int calories=0;
			private  int fat=0;
			private  int sodium=0;
			private  int carbohydrate=0;

			public Builder(int servingSize, int servings) {
				this.servingSize = servingSize;
				this.servings = servings;
			}

			public Builder calories(int val){
				calories = val;
				return this;
			}
			public Builder fat(int val){
				fat = val;
				return this;
			}
			public Builder sodium(int val){
				sodium = val;
				return this;
			}
			public Builder carbohydrate(int val){
				carbohydrate = val;
				return this;
			}

			public NutritionFacts builde(){
				return new NutritionFacts(this);
			}
		}
		private  NutritionFacts(Builder builder){
			servingSize = builder.servingSize;
			servings = builder.servings;
			calories = builder.calories;
			fat = builder.fat;
			sodium = builder.sodium;
			carbohydrate = builder.carbohydrate;
		}
	}

	public static void main(String[] args) {
		NutritionFacts nutritionFacts = new NutritionFacts.Builder(240,8)
				.calories(100).sodium(35).carbohydrate(27).builde();
	}
}
