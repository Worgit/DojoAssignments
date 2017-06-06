import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
class PuzzleJava {
	public ArrayList<Integer> problem1(){
		int[] array = {3,5,1,2,7,9,8,13,25,32};
		ArrayList<Integer> result = new ArrayList<>();
		for(int element: array){
			if(element > 10){
				result.add(element);
			}
		}
		for(int element: result){
			System.out.println(result);
		}
		return result;
	}
	public ArrayList<String> problem2(){
		String[] array = {"Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"};
		ArrayList<String> big = new ArrayList<>();
		String[] result = new String[array.length];
		Random generator = new Random();
		int check = 0;
		for(int i = 0; i < array.length; i++){
			String name = array[generator.nextInt(array.length)];
			while(check != 1){
				for(int j = 0; j < i; j++){
					if (result[j] != null){
						if(result[j].equals(name)){
							check--;
							name = array[generator.nextInt(array.length)];
							break;
						}
					}
				}
				check++;
			}
			result[i] = name;
			check--;
		}
		for(String element: result){
			if(element.length() >= 5){
				big.add(element);
			}
		}
		for(String element: big){
			System.out.println(element);
		}
		return (big);
	}
	public void problem3(){
		String[] array = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
		String[] result = new String[array.length];
		Random generator = new Random();
		int check = 0;
		for(int i = 0; i < array.length; i++){
			String name = array[generator.nextInt(array.length)];
			while(check != 1){
				for(int j = 0; j < i; j++){
					if (result[j] != null){
						if(result[j].equals(name)){
							check--;
							name = array[generator.nextInt(array.length)];
							break;
						}
					}
				}
				check++;
			}
			result[i] = name;
			check--;
		}
		System.out.println(result[result.length - 1]);
		System.out.println(result[0]);
		if(result[0] == "a" || result[0] == "e" || result[0] == "i" || result[0] == "o" || result[0] == "u"){
			System.out.println("Vowel!");
		}
		for(String element: result){
			System.out.println(element);
		}
	}
	public int[] problem4(){
		int[] result = new int[10];
		Random generator = new Random();
		for(int i = 0; i <= 9; i++){
			result[i] = generator.nextInt(46) + 55;
		}
		for(int element: result){
			System.out.println(element);
		}
		return (result);
	}
	public int[] problem5(){
		int[] result = new int[10];
		Random generator = new Random();
		for(int i = 0; i <= 9; i++){
			result[i] = generator.nextInt(46) + 55;
		}
		Arrays.sort(result);
		System.out.println(result[0]);
		int max = result[0];
		int min = result[0];
		for(int i = 0; i < result.length; i++){
			if(max < result[i]){
				max = result[i];
			}
			if(min > result[i]){
				min = result[i];
			}
			System.out.println(result[i]);
		}
		System.out.println(min);
		System.out.println(max);
		return (result);
	}
	public void problem6(){
		String result = "";
		Random generator = new Random();
		String[] array = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
		//System.out.println(array.length);
		for(int i = 0; i < 5; i++){
			result = result.concat(array[generator.nextInt(26)]);
		}
		System.out.println(result);
	}
	public String[] problem7(){
		String[] arr = new String[10];
		for(int i = 0; i < 10; i++){
			String result = "";
			Random generator = new Random();
			String[] array = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
			//System.out.println(array.length);
			for(int j = 0; j < 5; j++){
				result = result.concat(array[generator.nextInt(26)]);
			}
			arr[i] = result;
		}
		for(String element: arr){
			System.out.println(element);
		}
		return( arr );
	}
}