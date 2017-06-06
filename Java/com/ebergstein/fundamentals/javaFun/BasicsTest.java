public class BasicsTest {
	public static void main(String[] args){
		Basics methods = new Basics();
		System.out.println("all");
		methods.printAll();
		System.out.println("odd");
		methods.printOdd();
		System.out.println("sum");
		methods.printSum();
		System.out.println("iterate");
		int[] test1 = {1,4,2,3};
		int[] test2 = {-1,4,-2,3};
		methods.iterate(test1);
		System.out.println("max");
		methods.findMax(test1);
		System.out.println("average");
		methods.getAverage(test1);
		System.out.println("oddarr");
		System.out.println(methods.oddArray());
		System.out.println("greater");
		methods.greaterThan(test1, 2);
		System.out.println("square");
		methods.squareArray(test1);
		System.out.println("neg");
		methods.noNeg(test2);
		System.out.println("mma");
		methods.maxMinAvg(test1);
		System.out.println("shift");
		methods.shift(test1);
	}
}