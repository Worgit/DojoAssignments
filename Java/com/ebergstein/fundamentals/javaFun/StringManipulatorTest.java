class StringManipulatorTest {
	public static void main(String[] args){
		StringManipulator methods = new StringManipulator();
		System.out.println(methods.trimAndConcat("Apple", "Sauce"));
		System.out.println(methods.getIndexOrNull("Apple", 'e'));
		System.out.println(methods.getIndexOrNull("Apple", 'u'));
		System.out.println(methods.getIndexOrNull("Apple", "ple"));
		System.out.println(methods.getIndexOrNull("Apple", "xyz"));
		System.out.println(methods.concatSubstring("Apple", 2, 5, "Sauce"));
	}
}