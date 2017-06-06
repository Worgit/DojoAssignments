class StringManipulator {
	public String trimAndConcat(String one, String two){
		return one.concat(two);
	}
	public int getIndexOrNull(String string, char character){
		int result = string.indexOf(character);
		return (result);
	}
	public int getIndexOrNull(String one, String two){
		int result = one.indexOf(two.charAt(0));
		return (result);
	}
	public String concatSubstring(String one, int start, int end, String two){
		return two.concat(one.substring(start, end));
	}
}