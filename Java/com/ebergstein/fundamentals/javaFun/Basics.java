import java.util.ArrayList;
public class Basics {
	public void printAll(){
		for(int i = 1; i <= 255; i++){
			System.out.println(i);
		}
	}
	public void printOdd(){
		for(int i = 1; i <= 255; i++){
			if(i % 2 == 0){
				System.out.println(i);
			}
		}
	}
	public void printSum(){
		int sum = 0;
		for(int i = 0; i <= 255; i++){
			sum = sum + i;
			System.out.println(sum);
		}
	}
	public void iterate(int[] arr){
		for(int number: arr){
			System.out.println(number);
		}
	}
	public void findMax(int[] arr){
		int max = arr[0];
		for(int i = 1; i < arr.length; i++){
			if(max < arr[i]){
				max = arr[i];
			}
		}
		System.out.println(max);
	}
	public void getAverage(int[] arr){
		int total = 0;
		for(int number: arr){
			total = total + number;
		}
		System.out.println(total/arr.length);
	}
	public ArrayList<Integer> oddArray(){
		ArrayList<Integer> result = new ArrayList<>();
		for(int i = 1; i <= 255; i++){
			if(i % 2 == 0){
				result.add(i);
			}
		}
		return result;
	}
	public void greaterThan(int[] arr, int y){
		int total = 0;
		for(int number: arr){
			if(number > y){
				total++;
			}
		}
		System.out.println(total);
	}
	public void squareArray(int[] arr){
		for(int i = 0; i < arr.length; i++){
			arr[i] = arr[i] * arr[i];
		}
		for(int element: arr){
			System.out.println(element);
		}
	}
	public void noNeg(int[] arr){
		for(int i = 0; i < arr.length; i++){
			if(arr[i] < 0){
				arr[i] = 0;
			}
		}
		for(int element: arr){
			System.out.println(element);
		}
	}
	public void maxMinAvg(int[] arr){
		int[] result = new int[3];
		int max = arr[0];
		int min = arr[0];
		int avg = 0;
		for(int i = 0; i < arr.length; i++){
			if (max < arr[i]){
				max = arr[i];
			}
			if (min > arr[i]){
				min = arr[i];
			}
			avg = avg + arr[i];
		}
		result[0] = max;
		result[1] = min;
		result[2] = avg/arr.length;
		for(int element: result){
			System.out.println(element);
		}
	}
	public void shift(int[] arr){
		int temp = arr[0];
		for(int i = 1; i < arr.length; i++){
			
			int temp2 = arr[i];
			arr[i] = temp;
			temp = temp2;
			if(i == arr.length-1){
				arr[0] = temp;
			}
		}
		for(int element: arr){
			System.out.println(element);
		}
		
	}
}