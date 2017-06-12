package com.ebergstein.calculator.models;

public class Calculator {

	private String calculation;
	
	public Calculator(){
		this.setCalculation("");
	}
	
	public void update(String add){
		this.calculation = this.calculation.concat(add);
	}
	
	public String calculate(){
		//System.out.println(calculation);
		String[] split = calculation.split(" ");
		//System.out.println(split.length);
		for(String element: split){
			System.out.println(element);
		}
		if(split.length != 3){
			return (null);
		}
		
		//System.out.println(split[1]);
		
		if(split[1].equals("+")){
			return(Integer.toString((Integer.parseInt(split[0]) + Integer.parseInt(split[2]))));
		}
		
		else if(split[1].equals("-")){
			return(Integer.toString((Integer.parseInt(split[0]) - Integer.parseInt(split[2]))));
		}
		
		else if(split[1].equals("*")){
			return(Integer.toString((Integer.parseInt(split[0]) * Integer.parseInt(split[2]))));
		}
		else {
			return(Integer.toString((Integer.parseInt(split[0]) / Integer.parseInt(split[2]))));
		}
	}

	public String getCalculation() {
		return calculation;
	}

	public void setCalculation(String calculation) {
		this.calculation = calculation;
	}
	
}
