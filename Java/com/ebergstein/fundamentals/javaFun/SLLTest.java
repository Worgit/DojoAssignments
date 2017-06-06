class SLLTest{
	public static void main(String args[]){
		SLL list = new SLL();
		list.add(4);
		list.add(9);
		list.add(0);
		list.add(2);
		list.remove();
		list.printValues();
		Node temp = list.find(9);
		System.out.println(temp.getValue());
		list.add(2);
		list.removeAt(2);
		list.printValues();
	}
}