import java.util.ArrayList;
//class 
public class Generic{
	/*public void test(){
		ArrayList myList = new ArrayList();
    	myList.add("13");
    	myList.add("hello world");
    	myList.add(48);
    	myList.add("Goodbye World");
    	for(int i = 0; i < myList.size(); i++){
    		try{
    			int castedValue = (Integer)myList.get(i);
    			System.out.println(castedValue);
    		}
    		catch (RuntimeException e){
    			System.out.println("Error on index " + i);
    		}
    	}
	}*/
	public void test(){
		ArrayList myList = new ArrayList();
    	myList.add("13");
    	myList.add("hello world");
    	myList.add(48);
    	myList.add("Goodbye World");
    	for(int i = 0; i < myList.size(); i++){
    		check(myList.get(i));
    	}
    }
    public <E extends Integer> void check(E element){
    	int castedValue = (Integer)element;
    	System.out.println(castedValue);
    }
	
}